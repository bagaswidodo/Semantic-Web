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
import com.hp.hpl.jena.ontology.Individual;
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
@WebServlet(name = "TambahBunga", urlPatterns = {"/TambahBunga"})
public class TambahBunga extends HttpServlet {

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
            String txtnama_latin = request.getParameter("txtnama_latin");
            String txtnama_bunga = request.getParameter("txtnama_bunga");
            String txtordo = request.getParameter("txtordo");
            String txtfam = request.getParameter("txtfam");
            String txtmedia = request.getParameter("txtmedia");
            String txtmedia2 = request.getParameter("txtmedia2");
            String txtgambar = request.getParameter("txtgambar");
            OntModel om = ModelFactory.createOntologyModel();
            String nsHama = "http://www.bunga.com/hama#";
            String nsBunga = "http://www.bunga.com/bunga#";
            String nsMedia = "http://www.bunga.com/media#";
            String nsObat = "http://www.bunga.com/obat#";
            om.setNsPrefix("Obat", nsObat);
            om.setNsPrefix("Hama", nsHama);
            om.setNsPrefix("Bunga", nsBunga);
            om.setNsPrefix("Media", nsMedia);
            ObjectProperty nama_bunga = om.createObjectProperty(nsBunga + "Nama_Bunga");
            DatatypeProperty nama_latin = om.createDatatypeProperty(nsBunga + "Nama_Latin");
            ObjectProperty ordo = om.createObjectProperty(nsBunga + "Ordo");
            ObjectProperty family = om.createObjectProperty(nsBunga + "Family");
            ObjectProperty media = om.createObjectProperty(nsMedia + "Media");
            ObjectProperty media2 = om.createObjectProperty(nsMedia + "Media2");
            DatatypeProperty gambar = om.createDatatypeProperty(nsBunga + "Gambar");
            OntClass media_ont = om.createClass(nsMedia + txtmedia);
            OntClass media_ont2 = om.createClass(nsMedia + txtmedia2);
            OntClass familyont = om.createClass(nsBunga + txtfam);
            OntClass ordoont = om.createClass(nsBunga + txtordo);
            OntClass nama_bungaont = om.createClass(nsBunga + txtnama_bunga);
            Individual bunga = nama_bungaont.createIndividual(nsBunga + txtnama_bunga);
            bunga.addProperty(nama_bunga, bunga)
                    .addProperty(nama_latin, txtnama_latin).addProperty(family, familyont)
                    .addProperty(ordo, ordoont).addProperty(media, media_ont)
                    .addProperty(media2, media_ont2).addProperty(gambar, txtgambar);
            String DBurl = "jdbc:mysql://localhost/dbskema";
            String DB = "MySQL";
            String className = "com.mysql.jdbc.Driver";
            try {
                Class.forName(className);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TambahBunga.class.getName()).log(Level.SEVERE, null, ex);
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
                fos.close();
                response.sendRedirect("index.html");
            } catch (Exception e) {
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
