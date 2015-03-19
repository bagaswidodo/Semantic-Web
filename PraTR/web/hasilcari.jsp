<%@page import="DAO.DaoController"%>
<%@page import="model.modelBunga"%>
<%@page import="model.modelMedia"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import= "com.hp.hpl.jena.query.Query" %>
<%@page import= "com.hp.hpl.jena.query.QueryExecution" %>
<%@page import= "com.hp.hpl.jena.query.QueryExecutionFactory" %>
<%@page import= "com.hp.hpl.jena.query.QueryFactory" %>
<%@page import= "com.hp.hpl.jena.query.QuerySolution" %>
<%@page import= "com.hp.hpl.jena.query.ResultSet" %>
<%@page import= "java.io.File" %>
<%@page import= "java.io.FileInputStream" %>
<%@page import= "java.io.IOException" %>
<%@page import= "java.io.InputStream" %>
<%@page import= "com.hp.hpl.jena.rdf.model.Model" %>
<%@page import= "com.hp.hpl.jena.rdf.model.ModelFactory" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Taman Wisata Kopeng</title>
        <% String keyword = request.getParameter("txtcari");%>
    </head>
    <body><table><tr><td><h3><strong>
                            <%
                                try {
                                    DaoController daox = new DaoController();
                                    modelBunga x = new modelBunga();
                                    modelMedia m = new modelMedia();
                                    List<modelBunga> listbunga = new ArrayList<modelBunga>();
                                    List<modelMedia> listmedia = new ArrayList<modelMedia>();
                                    if (keyword.equalsIgnoreCase("")) { %><script type="text/javascript">
                                        alert('Kata kunci tidak boleh kosong!');
                                        document.location = 'home.jsp';
                            </script><%} else {
                                listbunga = daox.HasilCariBungaKey(keyword);
                                listmedia = daox.HasilCariMediaKey(keyword);
                                if (listbunga.size() > 0 || listmedia.size() > 0) {
                                    out.print("Hasil Keyword  <u><b>'" + keyword + "'</b></u> berhasil ditemukan "
                                            + (listbunga.size() + listmedia.size()) + " data!<br/>");%></strong></h3>
                            <%for (int i = 0; i < listbunga.size(); i++) {
                                                x = listbunga.get(i);
                                                out.print("<table>");
                                                out.print("<tr><td><img src='gambar/" + x.getGambar() + "' alt='foto' class='gambar'><br/>");
                                                out.print("</td><td>Nama Bunga : " + x.getNama_bunga() + "</a>");
                                                out.print("</tr><hr/>");
                                                out.print("</table>");
                                            }
                                            for (int im = 0; im < listmedia.size(); im++) {
                                                m = listmedia.get(im);
                                                out.print("<table>");
                                                out.print("<tr><td><img src='gambar/" + m.getGambar() + "' alt='foto' class='gambar'>");
                                                out.print("</td><td>Nama Media : " + m.getNama_media() + "</a><br/>");
                                                out.print("</tr><hr/>");
                                                out.print("</table>");
                                            }
                                        } else {
                                            out.print("<H2><Strong>Hasil Pencarian Tidak menemukan data yang dimaksud!</Strong > < / H2 >");
                                        }
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }%></td></tr></table></body></html>
