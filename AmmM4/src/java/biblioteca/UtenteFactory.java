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
public class UtenteFactory {  ///crea istanze di utente

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */

    private static UtenteFactory singleton;
    ArrayList<Utente> listaUtenti;

    /**
     *
     * @return
     */
    public static UtenteFactory getInstance() {
        if (singleton == null) {
            singleton = new UtenteFactory();
        }
        return singleton;
    }

    public ArrayList<Utente> listaVenditori = new ArrayList<>();

    public ArrayList<Utente> listaClienti = new ArrayList<>();
    private String connectionString;

    public UtenteFactory() {  ///inserisce in listautenti 2 utenti, uno un venditore e l'altro un cliente. entrambi hanno associato un saldo
        listaUtenti = new ArrayList<>();

        Venditore utente1 = new Venditore();
        utente1.setNome("Annibale_Barca");
        utente1.setPassword("Elefante");
        utente1.setId(1);

        Saldo saldo1 = new Saldo();
        saldo1.setProprietario("Annibale_Barca");
        saldo1.setSoldi(300);
        utente1.setSaldo(saldo1);
        listaUtenti.add(utente1);

        Cliente utente2 = new Cliente();
        utente2.setNome("Scipione_Africano");
        utente2.setPassword("Emilia");
        utente2.setId(2);
        Saldo saldo2 = new Saldo();
        saldo1.setProprietario("Scipione_Africano");
        saldo1.setSoldi(120);
        utente2.setSaldo(saldo2);
        listaUtenti.add(utente2);

    }

    /*
    public ArrayList<Utente> getVenditoreList()
    {
        return listaVenditori;
    }
    
    public ArrayList<Utente> getClienteList()
    {
        return listaClienti;
    }
    
    public Utente getVenditore(int id){
    for(Utente u : listaVenditori)
    {
    if(u.id == id)
    return u;
    }
    return null;
    }
    
    public Utente getCliente(int id){
    for(Utente u : listaClienti)
    {
    if(u.id == id)
    return u;
    }
    return null;
    }
    
    public ArrayList<Utente> getUserList(){
        return listaUtenti;
    }
     */
    public void setConnectionString(String s) {
        this.connectionString = s;
    }

    public String getConnectionString() {
        return this.connectionString;
    }
    
    ///ricerca un particolare venditore e lo restituisce, tramite le tabelle
    public Utente getVenditore(String username, String password) {
        try {
            Connection conn = DriverManager.getConnection(connectionString, "nicolausai", "0000");
            String query = "select * from venditore" + "pass = ? and nome = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet set = stmt.executeQuery();

            if (set.next()) {
                Venditore venditore = new Venditore();
                venditore.id = set.getInt("id");
                venditore.nome = set.getString("nome");
                venditore.password = set.getString("pass");
                query = "select * from saldo" + "where proprietario = ?";
                PreparedStatement st = conn.prepareStatement(query);
                st.setString(1, username);
                ResultSet res2 = st.executeQuery(query);
                
                Saldo s = new Saldo();
                s.setProprietario(res2.getString("proprietario"));
                s.setSoldi(res2.getInt("soldi"));
                venditore.setSaldo(s);
                st.close();
                stmt.close();
                conn.close();
                return venditore;

            }
        } catch (SQLException e) {
        }
        return null;
    }

    ///ricerca un particolare cliente e lo restituisce, tramite le tabelle
    public Utente getCliente(String username, String password) {
        try {
            Connection conn = DriverManager.getConnection(connectionString, "nicolausai", "0000");
            String query = "select * from cliente" + "pass = ? and nome = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet set = stmt.executeQuery();

            if (set.next()) {
                Cliente cliente = new Cliente();
                cliente.id = set.getInt("id");
                cliente.nome = set.getString("nome");
                cliente.password = set.getString("pass");
                query = "select * from saldo" + "where proprietario = ?";
                PreparedStatement st = conn.prepareStatement(query);
                st.setString(1, username);
                ResultSet res2 = st.executeQuery(query);
                Saldo s = new Saldo();
                s.setProprietario(res2.getString("proprietario"));
                s.setSoldi(res2.getInt("soldi"));
                cliente.setSaldo(s);
                st.close();
                stmt.close();
                conn.close();
                return cliente;

            }

        } catch (SQLException e) {
        }

        return null;

    }
    
    ///restituisce la lista dei clienti, tramite le tabelle
    public ArrayList<Cliente> getClienteList() { 
        ArrayList<Cliente> listaClienti = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(connectionString, "usainicola", "0000");
            Statement stmt = conn.createStatement();
            String query = "select * from cliente";
            ResultSet set = stmt.executeQuery(query);

            while (set.next()) {
                Cliente cliente = new Cliente();
                cliente.id = set.getInt("id");
                cliente.nome = set.getString("nome");
                cliente.password = set.getString("pass");
                listaClienti.add(cliente);
            }

            stmt.close();
            conn.close();

        } catch (SQLException e) {

        }

        return listaClienti;

    }

    //restituisce la lista dei venditori, tramite le tabelle
    public ArrayList<Venditore> getVenditoreList() {
        ArrayList<Venditore> listaVenditore = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(connectionString, "usainicola", "0000");
            Statement stmt = conn.createStatement();
            String query = "select * from venditore";
            ResultSet set = stmt.executeQuery(query);

            while (set.next()) {
                Venditore venditore = new Venditore();
                venditore.id = set.getInt("id");
                venditore.nome = set.getString("nome");
                venditore.password = set.getString("pass");
                listaVenditore.add(venditore);
            }

            stmt.close();
            conn.close();

        } catch (SQLException e) {

        }

        return listaVenditore;

    }

    ///restituisce la lista di tutti gli utenti, sia clienti che venditori, tramite le tabelle
    public ArrayList<Utente> getUserList() {
        ArrayList<Utente> listaUtente = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(connectionString, "usainicola", "0000");
            Statement stmt = conn.createStatement();
            String query = "select * from venditore";
            ResultSet set = stmt.executeQuery(query);

            while (set.next()) {
                Utente venditore = new Venditore();
                venditore.id = set.getInt("id");
                venditore.nome = set.getString("nome");
                venditore.password = set.getString("pass");
                listaUtente.add(venditore);
            }

            stmt.close();
            conn.close();

        } catch (SQLException e) {

        }

        try {
            Connection conn = DriverManager.getConnection(connectionString, "usainicola", "0000");
            Statement stmt = conn.createStatement();
            String query = "select * from cliente";
            ResultSet set = stmt.executeQuery(query);

            while (set.next()) {
                Utente cliente = new Cliente();
                cliente.id = set.getInt("id");
                cliente.nome = set.getString("nome");
                cliente.password = set.getString("pass");
                listaUtente.add(cliente);
            }

            stmt.close();
            conn.close();

        } catch (SQLException e) {

        }

        return listaUtente;

    }

}
