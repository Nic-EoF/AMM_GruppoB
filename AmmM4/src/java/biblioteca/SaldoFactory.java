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
public class SaldoFactory {   ///questa classe crea istanze di saldo
    private static SaldoFactory singleton;
    
    public static SaldoFactory getInstance(){
        if(singleton == null){
            singleton = new SaldoFactory();
        }
        return singleton;
    }
        
        ArrayList<Saldo> listaSaldo = new ArrayList<Saldo>();
    private String connectionString;
        public SaldoFactory(){  //genera "saldi" e li associa ai rispettivi proprietari
            
            Saldo saldo1 = new Saldo();
            saldo1.setProprietario("Annibale_Barca");
            saldo1.setSoldi(300);
            listaSaldo.add(saldo1);
            Saldo saldo2 = new Saldo();
            saldo2.setProprietario("Scipione_Africano");
            saldo2.setSoldi(120);
            listaSaldo.add(saldo2);
        }

        public ArrayList<Saldo> getSaldoList(){  ///restituisce la lista di libri
        ArrayList<Saldo> listaSal = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(connectionString, "usainicola", "0000");
            Statement stmt = conn.createStatement();
            String query = "select * from saldo";  //con questa query, selezioniamo i dati contenuti nella tabella saldo
            ResultSet set = stmt.executeQuery(query);

            while (set.next()) {  //preleviamo i dati dalla tabella
                Saldo saldo = new Saldo();
                saldo.setProprietario(set.getString("proprietario"));
                saldo.setSoldi(set.getDouble("soldi"));
                listaSal.add(saldo);
                stmt.close();
                conn.close();
            }
        } catch (SQLException e) {

        }

        return listaSal;
        }
        
    public void setConnectionString(String s){
    	this.connectionString = s;
    }

    public String getConnectionString(){
    	return this.connectionString;
    } 
    
    public Saldo getSaldo(String nome){  
        try{
        Connection conn = DriverManager.getConnection(connectionString, "usainicola", "0000");
        String query = "select * from saldo" + "where nome = ?";  ///seleziona il saldo rispettivo al nome
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, nome);
        ResultSet res = stmt.executeQuery();
        Saldo s = new Saldo();
        s.setProprietario(res.getString("proprietario"));
        s.setSoldi(res.getInt("soldi"));
       
        stmt.close();
        conn.close();
        return s;
        }catch(SQLException e) 
        {
            
        }
        
        return null;
        
    }
    
   

   
    
}
