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
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head><title>Taman Wisata </title></head><body>
        <% DAOController daox = new DAOController();
            List<modelBunga> listrdf = new ArrayList<modelBunga>();
            String keyword = request.getParameter("txtcari");
            String pencarianBunga = request.getParameter("pencarianBunga");
            String pencarianMedia = request.getParameter("pencarianMedia");
            String pencarian = request.getParameter("pencarian");
            try {
                DAOController dao = new DAOController();
                List<modelBunga> listbunga = new ArrayList<modelBunga>();
                List<modelMedia> listmedia = new ArrayList<modelMedia>();
                if (pencarian.equalsIgnoreCase("Nama_Bunga")) {
                    listbunga = dao.HasilSederhanaBunga(pencarianBunga, keyword);
                    if (listbunga.size() > 0) {
                        out.print("<div class='content_resize'>Hasil Pencarian Untuk Kata Kunc<u><b>'" + keyword + "'</b></u> berhasil ditemukan "
                                + (listbunga.size()) + " data!</div>");
                        for (int i = 0; i < listbunga.size(); i++) {
                            modelBunga b = new modelBunga();
                            b = listbunga.get(i);
                            out.print("<table>");
                            out.print("<tr><td><img src='gambar/" + b.getGambar() + "' alt='foto' class='gambar'><br/>");
                            out.print("</td><td>Nama Bunga : " + b.getNama_bunga() + "</a><br/>");
                            out.print("</tr><hr/>");
                            out.print("</table>");
                        }
                    } else {
                        out.print("<H2>Hasil Pencarian Tidak menemukan data yang dimaksud</H2>");
                    }
                } else if (pencarian.equalsIgnoreCase("Nama_Media")) {
                    listmedia = dao.HasilSederhanaMedia(pencarianMedia, keyword);
                    if (listmedia.size() > 0) {
                        out.print("<div class='content_resize'>Hasil Pencarian Untuk Kata Kunci<u><b>'" + keyword + "'</b></u> berhasil ditemukan "
                                + (listmedia.size()) + " data!</div>");
                        for (int i = 0; i < listmedia.size(); i++) {
                            modelMedia m = new modelMedia();
                            m = listmedia.get(i);
                            out.print("<table>");
                            out.print("<tr><td><img src='gambar/" + m.getGambar() + "' alt='foto' class='gambar'><br/>");
                            out.print("</td><td>Nama Media : " + m.getNama_media() + "</a><br/>");
                            out.print("</tr><hr/>");
                            out.print("</table>");
                        }
                    } else {
                        out.print("<H2><Strong>Hasil Pencarian Tidak menemukan data yang dimaksud 57. !</Strong></H2>");
                    }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }%></body></html>
