/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.hp.hpl.jena.db.DBConnection;
import com.hp.hpl.jena.ontology.DatatypeProperty;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.ModelMaker;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BagasWidodo
 */
@WebServlet(name = "TambahMedia", urlPatterns = {"/TambahMedia"})
public class TambahMedia extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String txtnama_media = request.getParameter("txtnama_media");
            String txtfungsi = request.getParameter("txtfungsi");
            String txtcara_pembuatan = request.getParameter("txtcara_pembuatan");
            String txtgambar = request.getParameter("uploadFile");
            OntModel om = ModelFactory.createOntologyModel();
            String nsBunga = "http://www.bunga.com/bunga#";
            String nsMedia = "http://www.bunga.com/media#";
            om.setNsPrefix("Bunga", nsBunga);
            om.setNsPrefix("Media", nsMedia);
            ObjectProperty nama_media = om.createObjectProperty(nsMedia + "Nama_Media");
            DatatypeProperty fungsi = om.createDatatypeProperty(nsMedia + "Fungsi");
            DatatypeProperty cara_buat = om.createDatatypeProperty(nsMedia + "Cara_Buat");
            DatatypeProperty gambar = om.createDatatypeProperty(nsMedia + "Gambar");
            OntClass media_ont = om.createClass(nsMedia + txtnama_media);
            media_ont.addProperty(nama_media, media_ont).
                    addProperty(fungsi, txtfungsi).
                    addProperty(cara_buat, txtcara_pembuatan).
                    addProperty(gambar, txtgambar);
            String DBurl = "jdbc:mysql://localhost/dbskema";
            String DB = "MySQL";
            String className = "com.mysql.jdbc.Driver";
            try {
                Class.forName(className);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TambahMedia.class.getName()).log(Level.SEVERE, null, ex);
            }
            String user = "root";
            String pass = "";
            DBConnection connection = new DBConnection(DBurl, user, pass, DB);
            ModelMaker maker = ModelFactory.createModelRDBMaker(connection);
            Model sensorNetModel = maker.createDefaultModel();
            sensorNetModel.begin();
            sensorNetModel.add(om);
            sensorNetModel.commit();
            try {
                FileOutputStream fos = new FileOutputStream("D:/Semantic/Bunga.rdf");
                sensorNetModel.write(fos, "RDF/XML-ABBREV");
                response.sendRedirect("index.html");
                fos.close();
            } catch (Exception e) {
            } finally {
                out.close();
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
