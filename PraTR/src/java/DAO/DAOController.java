/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BagasWidodo
 */
public class DAOController {

    public List<modelBunga> getObat1(String namaBunga) {
        List<modelBunga> bungaAll = new ArrayList<modelBunga>();
        Model model = ModelFactory.createDefaultModel();
        InputStream in = FileManager.get().open("D:/Semantic/Bunga.rdf");
        model.read(in, null);
        Query qHCBK = QueryFactory.create(
                "PREFIX Bunga:<http://www.bunga.com/bunga#>"
                + "PREFIX Media:<http://www.bunga.com/media#>"
                + "SELECT"
                + "?Nama_Bunga ?Nama_Latin ?Ordo ?Family "
                + "?Media ?Media2 ?Gambar"
                + " WHERE { "
                + "?x Bunga:Nama_Bunga ?Nama_Bunga ."
                + "?x Bunga:Nama_Latin ?Nama_Latin . "
                + "?x Bunga:Ordo ?Ordo . "
                + "?x Bunga:Family ?Family . "
                + "?x Media:Media ?Media  . "
                + "?x Media:Media2 ?Media2 . "
                + "?x Bunga:Gambar ?Gambar . "
                + "  } ");
        try {
            QueryExecution qeHCBK = QueryExecutionFactory.create(qHCBK, model);
            ResultSet rsHCBK = qeHCBK.execSelect();
            while (rsHCBK.hasNext()) {
                QuerySolution solHCBK = rsHCBK.nextSolution();
                modelBunga mb = new modelBunga();
                mb.setNama_bunga(solHCBK.getResource("Nama_Bunga").getURI().substring(27));
                mb.setNama_latin(solHCBK.getLiteral("Nama_Latin").getString());
                mb.setOrdo(solHCBK.getResource("Ordo").getURI().substring(27));
                mb.setFam(solHCBK.getResource("Family").getURI().substring(27));
                mb.setMedia(solHCBK.getResource("Media").getURI().substring(27));
                mb.setMedia2(solHCBK.getResource("Media2").getURI().substring(27));
                mb.setGambar(solHCBK.getLiteral("Gambar").getString());
                bungaAll.add(mb);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return bungaAll;
    }
     public List<modelBunga> getAllBunga() {
        List<modelBunga> bungaAll = new ArrayList<modelBunga>();
        Model model = ModelFactory.createDefaultModel();
        InputStream in = FileManager.get().open("D:/Semantic/Bunga.rdf");
        model.read(in, null);
        Query qHCBK = QueryFactory.create(
                "PREFIX Bunga:<http://www.bunga.com/bunga#>"
                + "PREFIX Media:<http://www.bunga.com/media#>"
                + "SELECT"
                + "?Nama_Bunga ?Nama_Latin ?Ordo ?Family "
                + "?Media ?Media2 ?Gambar"
                + " WHERE { "
                + "?x Bunga:Nama_Bunga ?Nama_Bunga ."
                + "?x Bunga:Nama_Latin ?Nama_Latin . "
                + "?x Bunga:Ordo ?Ordo . "
                + "?x Bunga:Family ?Family . "
                + "?x Media:Media ?Media  . "
                + "?x Media:Media2 ?Media2 . "
                + "?x Bunga:Gambar ?Gambar . "
                + "  } ");
        try {
            QueryExecution qeHCBK = QueryExecutionFactory.create(qHCBK, model);
            ResultSet rsHCBK = qeHCBK.execSelect();
            while (rsHCBK.hasNext()) {
                QuerySolution solHCBK = rsHCBK.nextSolution();
                modelBunga mb = new modelBunga();
                mb.setNama_bunga(solHCBK.getResource("Nama_Bunga").getURI().substring(27));
                mb.setNama_latin(solHCBK.getLiteral("Nama_Latin").getString());
                mb.setOrdo(solHCBK.getResource("Ordo").getURI().substring(27));
                mb.setFam(solHCBK.getResource("Family").getURI().substring(27));
                mb.setMedia(solHCBK.getResource("Media").getURI().substring(27));
                mb.setMedia2(solHCBK.getResource("Media2").getURI().substring(27));
                mb.setGambar(solHCBK.getLiteral("Gambar").getString());
                bungaAll.add(mb);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return bungaAll;
    }

    public List<modelMedia> HasilCariMediaKey(String keyword) {
        List<modelMedia> ListMedia = new ArrayList<modelMedia>();
        Model model = ModelFactory.createDefaultModel();
        InputStream in = FileManager.get().open("D:/Semantic/Bunga.rdf");
        model.read(in, null);
        Query qHCMK = QueryFactory.create(
                "PREFIX Media:<http://www.bunga.com/media#> "
                + "SELECT ?Nama_Media ?Fungsi ?Cara_Buat ?Gambar"
                + " WHERE { "
                + "?x Media:Nama_Media ?Nama_Media .  "
                + "?x Media:Fungsi ?Fungsi . "
                + "?x Media:Cara_Buat ?Cara_Buat ."
                + "?x Media:Gambar ?Gambar "
                + "FILTER (regex(?Nama_Media, '" + keyword + "','i') || regex( ? Fungsi, '" + keyword + "'  ,'i') || "
                + "regex(?Cara_Buat, '" + keyword + "','i') || regex(?Gambar, '"
                + keyword + "','i')"
                + " ) } "
        );
        try {
            QueryExecution qeHCMK = QueryExecutionFactory.create(qHCMK, model);
            ResultSet rsHCMK = qeHCMK.execSelect();
            while (rsHCMK.hasNext()) {
                QuerySolution sol = rsHCMK.nextSolution();
                modelMedia mm = new modelMedia();
                mm.setNama_media(sol.getResource("Nama_Media").getURI().substring(2
                ));
                mm.setGambar(sol.getLiteral("Gambar").getString());
                ListMedia.add(mm);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ListMedia;
    }

    public List<modelBunga> HasilCariBungaKey(String keyword) {
        List<modelBunga> ListBunga = new ArrayList<modelBunga>();
        Model model = ModelFactory.createDefaultModel();
        InputStream in = FileManager.get().open("D:/Semantic/Bunga.rdf");
        model.read(in, null);
        Query qHCBK = QueryFactory.create(
                "PREFIX Bunga:<http://www.bunga.com/bunga#>"
                + "PREFIX Media:<http://www.bunga.com/media#>"
                + "SELECT"
                + "?Nama_Bunga ?Nama_Latin ?Ordo ?Family "
                + "?Media ?Media2 ?Gambar"
                + " WHERE { "
                + "?x Bunga:Nama_Bunga ?Nama_Bunga . "
                + "?x Bunga:Nama_Latin ?Nama_Latin . "
                + "?x Bunga:Ordo ?Ordo . "
                + "?x Bunga:Family ?Family . "
                + "?x Media:Media ?Media  . "
                + "?x Media:Media2 ?Media2 . "
                + "?x Bunga:Gambar ?Gambar . "
                + "FILTER (regex(str(?Nama_Bunga), '" + keyword + "', 'i') ||regex(str( ? Nama_Latin), '" + keyword + "'  , 'i') "
                + "|| regex(str(?Ordo), '" + keyword + "', 'i') || regex(str(?Family), '"
                + keyword + "', 'i') || "
                + " regex(str(?Media), '" + keyword + "', 'i') || regex(str(?Media2), '"
                + keyword + "', 'i') ||  regex(str(?Gambar), '" + keyword + "', 'i') "
                + " ) } "
        );
        try {
            QueryExecution qeHCBK = QueryExecutionFactory.create(qHCBK, model);
            ResultSet rsHCBK = qeHCBK.execSelect();
            while (rsHCBK.hasNext()) {
                QuerySolution solHCBK = rsHCBK.nextSolution();
                modelBunga mb = new modelBunga();
                mb.setNama_bunga(solHCBK.getResource("Nama_Bunga").getURI().substring(27));
                mb.setGambar(solHCBK.getLiteral("Gambar").getString());
                ListBunga.add(mb);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ListBunga;
    }

    public List<modelMedia> HasilSederhanaMedia(String pencarianMedia, String keyword) {
        List<modelMedia> ListMedia = new ArrayList<modelMedia>();
        Model model = ModelFactory.createDefaultModel();
        InputStream in = FileManager.get().open("D:/TA/TA.rdf");
        model.read(in, null);
        Query qHCMK = QueryFactory.create(
                "PREFIX Media:<http://www.bunga.com/media#> " + "SELECT ?Nama_Media ?Fungsi ?Cara_Buat ? Gambar "
                + " WHERE { "
                + "?x Media:Nama_Media ?Nama_Media .  "
                + "?x Media:Fungsi ?Fungsi . "
                + "?x Media:Cara_Buat ?Cara_Buat ."
                + "?x Media:Gambar ?Gambar "
                + "FILTER regex(str(?" + pencarianMedia + "), '" + keyword + "', 'i') "
                + "  } "
        );
        try {
            QueryExecution qeHCMK = QueryExecutionFactory.create(qHCMK, model);
            ResultSet rsHCMK = qeHCMK.execSelect();
            while (rsHCMK.hasNext()) {
                QuerySolution sol = rsHCMK.nextSolution();
                modelMedia mm = new modelMedia();
                mm.setNama_media(sol.getResource("Nama_Media").getURI().substring(27));
                mm.setGambar(sol.getLiteral("Gambar").getString());
                ListMedia.add(mm);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ListMedia;
    }

    public List<modelBunga> HasilSederhanaBunga(String pencarianBunga, String keyword) {
        List<modelBunga> ListBunga = new ArrayList<modelBunga>();
        Model model = ModelFactory.createDefaultModel();
        InputStream in = FileManager.get().open("D:/Semantic/Bunga.rdf");
        model.read(in, null);
        Query qHCBK = QueryFactory.create(
                "PREFIX Bunga:<http://www.bunga.com/bunga#>"
                + "PREFIX Media:<http://www.bunga.com/media#>"
                + "SELECT ?Nama_Bunga ?Nama_Latin ?Ordo ?Family ?Media ?Media2 ?Gambar"
                + " WHERE { ?x Bunga:Nama_Bunga ?Nama_Bunga.?x Bunga:Nama_Latin ?Nama_Latin."
                + "?x Bunga:Ordo ?Ordo.?x Bunga:Family ?Family.?x Media:Media ?Media  . "
                + "?x Media:Media2 ?Media2.?x Bunga:Gambar ?Gambar . "
                + "FILTER regex(str(?" + pencarianBunga + "),'" + keyword + "', 'i') " + "  } ");
        try {
            QueryExecution qeHCBK = QueryExecutionFactory.create(qHCBK, model);
            ResultSet rsHCBK = qeHCBK.execSelect();
            while (rsHCBK.hasNext()) {
                QuerySolution solHCBK = rsHCBK.nextSolution();
                modelBunga mb = new modelBunga();
                mb.setNama_bunga(solHCBK.getResource("Nama_Bunga").getURI().substring(27));
                mb.setGambar(solHCBK.getLiteral("Gambar").getString());
                ListBunga.add(mb);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ListBunga;
    }

    public List<modelBunga> HasilKompleksBunga(String nama_latin, String nama_bunga, String ordo, String fambunga, String media) {
        List<modelBunga> ListBunga = new ArrayList<modelBunga>();
        Model model = ModelFactory.createDefaultModel();
        InputStream in = FileManager.get().open("D:/Semantic/Bunga.rdf");
        model.read(in, null);
        Query qHCBK = QueryFactory.create(
                "PREFIX Bunga:<http://www.bunga.com/bunga#>"
                + "PREFIX Media:http://www.bunga.com/media# SELECT"
                + "?Nama_Bunga ?Nama_Latin ?Ordo ?Family ?Media ?Media2 ?Gambar"
                + " WHERE { ?x Bunga:Nama_Bunga ?Nama_Bunga . "
                + "?x Bunga:Nama_Latin ?Nama_Latin.?x Bunga:Ordo ?Ordo."
                + "?x Bunga:Family ? Family. ? x  Media : Media ? Media  . "
                + "?x Media:Media2 ?Media2 . ?x Bunga:Gambar ?Gambar . "
                + "FILTER (regex(str(?Nama_Bunga), '" + nama_bunga + "', 'i') && "
                + " regex(str(?Nama_Latin), '" + nama_latin + "', 'i') && "
                + " regex(str(?Ordo), '" + ordo + "', 'i') && "
                + " regex(str(?Family), '" + fambunga + "', 'i') && "
                + " (regex(str(?Media), '" + media + "', 'i') || regex(str(?Media2), '"
                + media + "', 'i')) ) } "
        );
        try {
            QueryExecution qeHCBK = QueryExecutionFactory.create(qHCBK, model);
            ResultSet rsHCBK = qeHCBK.execSelect();
            while (rsHCBK.hasNext()) {
                QuerySolution solHCBK = rsHCBK.nextSolution();
                modelBunga mb = new modelBunga();
                mb.setNama_bunga(solHCBK.getResource("Nama_Bunga").getURI().substring(27));
                mb.setNama_latin(solHCBK.getLiteral("Nama_Latin").getString());
                mb.setOrdo(solHCBK.getResource("Ordo").getURI().substring(27));
                mb.setFam(solHCBK.getResource("Family").getURI().substring(27));
                mb.setMedia(solHCBK.getResource("Media").getURI().substring(27));
                mb.setMedia2(solHCBK.getResource("Media2").getURI().substring(27));
                mb.setGambar(solHCBK.getLiteral("Gambar").getString());
                ListBunga.add(mb);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ListBunga;
    }


}
