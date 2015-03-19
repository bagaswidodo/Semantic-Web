<%@page import="com.hp.hpl.jena.query.QuerySolution"%>
<%@page import="com.hp.hpl.jena.query.ResultSet"%>
<%@page import="com.hp.hpl.jena.query.QueryExecutionFactory"%>
<%@page import="com.hp.hpl.jena.query.QueryExecution"%>
<%@page import="com.hp.hpl.jena.query.QueryFactory"%>
<%@page import="com.hp.hpl.jena.query.Query"%>
<%@page import="com.hp.hpl.jena.rdf.model.ModelFactory"%>
<%@page import="com.hp.hpl.jena.rdf.model.Model"%>
<%@page import="java.io.File"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            InputStream in = new FileInputStream(
                    new File("D:/Semantic/Bunga.rdf"));
            Model mod = ModelFactory.createMemModelMaker().createDefaultModel();
            mod.read(in, null);
            in.close();
        %>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form method="post" action="TambahBunga">
            <table align="center" border="0" style="width: 80%; height: 100%"
                   class="input"><tr><td>Nama Bunga</td><td>:</td>
                    <td><input type="text"  name="txtnama_bunga" style="width: 290px"></td>
                </tr><tr><td>Nama Latin Bunga</td><td>:</td>
                    <td><input type="text"  name="txtnama_latin" style="width: 290px"></td>
                </tr><tr><td>Family</td><td>:</td>
                    <td><input type="text"  name="txtfam" style="width: 290px"></td>
                </tr><tr><td>Ordo</td><td>:</td>
                    <td><input type="text"  name="txtordo" style="width: 290px"></td></tr><tr>
                    <td>Media yang Dipakai</td><td>:</td><td>
                        <select style="width: 290px" name="txtmedia"><option></option><%
                            Query quer = QueryFactory.create(
                                    "PREFIX Media:<http://www.bunga.com/media#>"
                                    + "SELECT ?Nama_Media ?Fungsi ?Cara_Buat "
                                    + " WHERE { "
                                    + "?x Media:Nama_Media ?Nama_Media .  "
                                    + "?x Media:Fungsi ?Fungsi ."
                                    + "?x Media:Cara_Buat ?Cara_Buat   }"
                                    + "ORDER BY asc(?Nama_Media)  ");
                            QueryExecution qe = QueryExecutionFactory.create(quer, mod);
                            ResultSet rs = qe.execSelect();

                            while (rs.hasNext()) {
                                QuerySolution sol = rs.nextSolution();
                                String media = sol.getResource("Nama_Media").getURI().substring(27);%>
                            <option ><% out.print(media);%></option><%}%></select>
                    </td></tr><tr><td><select style="width: 290px" name="txtmedia2">
                            <option></option>
                            <% Query quer2 = QueryFactory.create(
                                        "PREFIX Media:<http://www.bunga.com/media#> "
                                        + "SELECT ?Nama_Media ?Fungsi ?Cara_Buat "
                                        + " WHERE { "
                                        + "?x Media:Nama_Media ?Nama_Media .  "
                                        + "?x Media:Fungsi ?Fungsi . "
                                        + "?x Media:Cara_Buat ?Cara_Buat .  "
                                        + "  } ORDER BY asc(?Nama_Media)  ");
                                QueryExecution qe2 = QueryExecutionFactory.create(quer2, mod);
                                ResultSet rs2 = qe2.execSelect();

                                while (rs2.hasNext()) {
                                    QuerySolution sol2 = rs2.nextSolution();
                                    String media = sol2.getResource("Nama_Media").getURI().substring(27);%>
                            <option ><% out.print(media);%></option>
                            <%}%></select></td></tr><tr><td >Upload Gambar</td><td >:</td>
                    <td  ><input name="txtgambar" type="file" ></td></tr>  <tr>
                    <td align="right" > <input type="submit" value="Simpan"
                                               class="buton"></td></tr></table></form>

    </body>
</html>
