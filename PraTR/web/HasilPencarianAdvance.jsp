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
<head><title>Taman Wisata Kopeng</title>
</head><body><%DaoController daox = new DaoController();
String nama_bunga = request.getParameter("txtnamabunga");
String nama_latin = request.getParameter("txtnamalatinbunga");
String ordo = request.getParameter("txtordobunga");
String fambunga = request.getParameter("txtfamilibunga");
String media = request.getParameter("txtmedia");
List<modelBunga> listbunga = new ArrayList<modelBunga>();
listbunga = daox.HasilKompleksBunga(nama_latin, nama_bunga, 
ordo, fambunga, media);if (listbunga.size() > 0) {
for (int i = 0; i < listbunga.size(); i++) {modelBunga mb = listbunga.get(i);
out.print("hasil pencarian '" + mb.getNama_bunga() + "' ditemukan '" +
listbunga.size() + "'");out.print("<table>");
out.print("<tr><td><img src='gambar/" + mb.getGambar() + "'><br/></td></tr>");
out.print("<tr><td>Nama Bunga </td><td>:</td><td> " + mb.getNama_bunga() +
"</td></tr>");
out.print("<tr><td>Nama Latin</td><td>: </td><td>" + mb.getNama_latin() +
"</td></tr>");
out.print("<tr><td>Ordo</td><td>: </td><td>" + mb.getOrdo() + "</td></tr>");
out.print("<tr><td>Family</td><td>: </td><td>" + mb.getFam() + "</td></tr>");
out.print("</table>");}} else if (listbunga.size() == 0  ) {
out.print("<H2>Hasil Pencarian Tidak menemukan data yang dimaksud !</H2>");
}%></body></html>
