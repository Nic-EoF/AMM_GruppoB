/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author utente
 */
public class LibroFactory {  ///Questa classe crea istance di Libro

    private static LibroFactory singleton;

    public static LibroFactory getInstance() {
        if (singleton == null) {
            singleton = new LibroFactory();
        }
        return singleton;
    }

    private ArrayList<Libro> listaLibro = new ArrayList<Libro>();
    private String connectionString;

    public LibroFactory() {  //vengono inseriti vari libri nella lista listaLibro
        Libro libro1 = new Libro();
        libro1.setNome("Storia Medievale");
        libro1.setPrezzo(15);
        libro1.setQuantità(3);
        libro1.setImmagine("Immagini/helmet.gif");
        Libro libro2 = new Libro();
        libro2.setNome("Preistoria");
        libro2.setPrezzo(10);
        libro2.setQuantità(20);
        libro2.setImmagine("Immagini/mammut.jgp");
        Libro libro3 = new Libro();
        libro3.setNome("Storia Romana");
        libro3.setPrezzo(13);
        libro3.setQuantità(17);
        libro3.setImmagine("Immagini/rome.png");
        Libro libro4 = new Libro();
        libro4.setNome("Storia Cinese");
        libro4.setPrezzo(30);
        libro4.setQuantità(11);
        libro4.setImmagine("Immagini/sun_tzu.jpg");
        Libro libro5 = new Libro();
        libro5.setNome("Storia Moderna");
        libro5.setPrezzo(50);
        libro5.setQuantità(1);
        libro5.setImmagine("Immagini/t90.jpg");
        listaLibro.add(libro1);
        listaLibro.add(libro2);
        listaLibro.add(libro3);
        listaLibro.add(libro4);
        listaLibro.add(libro5);
    }

    /*
        public ArrayList<Libro> getLibroList(){
        return listaLibro;
        }
     */
    public void setConnectionString(String s) {
        this.connectionString = s;
    }

    public String getConnectionString() {
        return this.connectionString;
    }

    ///questi metodi sono stati ricreati implementando i database
    public ArrayList<Libro> getLibroList() {
        ArrayList<Libro> listaLib = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(connectionString, "usainicola", "0000");
            Statement stmt = conn.createStatement();
            String query = "select * from libro";  //con questa query, selezioniamo i dati contenuti nella tabella libro
            ResultSet set = stmt.executeQuery(query);

            while (set.next()) {  //preleviamo i dati dalla tabella
                Libro libro = new Libro();
                libro.setNome(set.getString("nome"));
                libro.setImmagine(set.getString("immagine"));
                libro.setPrezzo(set.getInt("prezzo"));
                libro.setQuantità(set.getInt("quantità"));

                listaLib.add(libro);
                stmt.close();
                conn.close();
            }
        } catch (SQLException e) {

        }

        return listaLib;

    }
    
    
    ///queste funzioni rispettviamente aggiungono, cancellano e modificano un libro già esistente.
    public void addLibro(String nome, String immagine, double prezzo, int quantità) {
        try {
            Connection conn = DriverManager.getConnection(connectionString, "usainicola", "0000");
            String query = "insert into libro(id, nome, immagine, prezzo, quantità"
                    + "values (default, '?', '?' , ?, ?);";  ///in questa maniera possiamo inserire valori di variabili all'interno delle query
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, nome);
            stmt.setString(2, immagine);
            stmt.setDouble(3, prezzo);
            stmt.setInt(4, quantità);
            stmt.execute(query);  ///eseguiamo la query
        } catch (SQLException e) {
        }
    }

    public void deleteLibro(String nome) {
        try {
            Connection conn = DriverManager.getConnection(connectionString, "usainicola", "0000");
            String query = "delete from libro" + "where nome = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, nome);
            stmt.execute(query);
        } catch (SQLException e) {
        }

    }

    public void updateLibro(String nome, String immagine, double prezzo, int quantità) {
        try {
            Connection conn = DriverManager.getConnection(connectionString, "usainicola", "0000");
            String query = "update table" + "set immagine='?', prezzo=?, quantità=?"
                    + "where nome='?'";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, immagine);
            stmt.setDouble(2, prezzo);
            stmt.setInt(3, quantità);
            stmt.setString(4, nome);
            stmt.execute(query);
        } catch (SQLException e) {
        }
    }

}
