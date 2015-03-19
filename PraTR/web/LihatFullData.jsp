<%-- 
    Document   : LihatFullData
    Created on : Mar 19, 2015, 4:19:03 PM
    Author     : BagasWidodo
--%>
<%@page import="DAO.modelMedia"%>
<%@page import="DAO.modelBunga"%>
<%@page import="DAO.DAOController"%>
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
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>
        <a href="index.html">&lt;&lt;Kembali Ke Index</a>
        <%
    DAOController daox = new DAOController();
    List<modelBunga> listrdf = new ArrayList<modelBunga>();
    List<modelMedia> listrdf2 = new ArrayList<modelMedia>();
    listrdf = daox.getAllBunga();
    for (int i = 0; i < listrdf.size(); i++) {
        modelBunga x = listrdf.get(i);
        out.print("<table><tr><td>Nama Bunga </td><td>:</td><td> "
                + x.getNama_bunga() + "</td></tr>");
        out.print("<tr><td>Nama latin </td><td> :</td><td>" + x.getNama_latin()
                + "</td></tr>");
        out.print("<tr><td>Ordo </td><td>: </td><td>" + x.getOrdo()
                + "</td></tr>");
        out.print("<tr><td>Family </td><td>: </td><td>" + x.getFam()
                + "</td></tr>");
        out.print("<tr><td>Media </td><td>: </td><td>" + x.getMedia()
                + "</td></tr>");
        out.print("<tr><td> </td><td> </td><td>" + x.getMedia2()
                + "</td></tr></table>");
    }%>
    </body>
</html>