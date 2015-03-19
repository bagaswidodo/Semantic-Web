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
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head><title>Taman Wisata Kopeng</title></head><body>
        <% DAOController daox = new DAOController();
    List<modelBunga> listrdf = new ArrayList<modelBunga>();%> 
        <form action="HasilPencarianSederhana.jsp"><table>
                <tr><td colspan="3"><h2><strong>Pencarian Sederhana</strong></h2><hr/></td></tr>
                <tr><td><strong>Cari Berdasar</strong></td><td>:</td><td>
                        <select name="pencarian" class="cmb">
                            <option>Nama_Bunga</option><option>Nama_Media</option></select></td></tr><tr>
                    <td><strong>Kategori Pencarian</strong></td></tr><tr>
                    <td><strong>Bunga</strong></td><td>:</td><td>
                        <select name="pencarianBunga" class="cmb">
                            <option>Nama_Bunga</option><option>Nama_Latin</option>
                            <option>Family</option><option>Ordo</option>
                        </select></td></tr><tr>
                    <td><strong>Media</strong></td><td>:</td><td>
                        <select name="pencarianMedia" class="cmb">
                            <option>Nama_Media</option><option>Fungsi</option>
                            <option>Cara_Buat</option> </select></td></tr><tr><td>
                        <strong>Masukkan Kata Kunci</strong></td><td>:</td>
                    <td><input type="text" name="txtcari"class="txt"/></td>
                    <td><input type="submit" value="Cari" style="width: 50px; height: 30px"/></td>
                </tr><a href="index.jsp"> index </a><br/>
            </table></form></body></html>
