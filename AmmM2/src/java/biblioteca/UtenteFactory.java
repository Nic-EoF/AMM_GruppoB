/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.util.ArrayList;

/**
 *
 * @author utente
 */
public class UtenteFactory {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


    private static UtenteFactory singleton;
    
    /**
     *
     * @return
     */
    public static UtenteFactory getInstance(){
        if(singleton == null){
            singleton = new UtenteFactory();
        }
        return singleton;
    }
    
    public ArrayList<Utente> listaVenditori = new ArrayList<Utente>();
    
    public ArrayList<Utente> listaClienti = new ArrayList<Utente>();
    
    public UtenteFactory(){
        
        Venditore utente1 = new Venditore();
        utente1.setNome("Annibale_Barca");
        utente1.setPassword("Elefante");
        utente1.setId(1);
        
        Saldo saldo1 = new Saldo();
        saldo1.setProprietario("Annibale_Barca");
        saldo1.setSoldi(300);
        utente1.setSaldo(saldo1);
        listaVenditori.add(utente1);
        
        Cliente utente2 = new Cliente();
        utente2.setNome("Scipione_Africano");
        utente2.setPassword("Emilia");
        utente2.setId(2);
        Saldo saldo2 = new Saldo();
        saldo1.setProprietario("Scipione_Africano");
        saldo1.setSoldi(120);
        utente2.setSaldo(saldo2);
        listaClienti.add(utente2);  
    }
    
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
        ArrayList<Utente> listaUtenti = new ArrayList<Utente>();
        listaUtenti.addAll(listaVenditori);
        listaUtenti.addAll(listaClienti);
        return listaUtenti;
}

    
}


