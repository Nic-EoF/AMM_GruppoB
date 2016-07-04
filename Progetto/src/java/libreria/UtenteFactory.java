/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;
import java.util.ArrayList;

/**
 *
 * @author utente
 */
public class UtenteFactory {
    private static UtenteFactory singleton;
    ArrayList<Utente> listaUtenti;
    ArrayList<Cliente> listaClienti;
    ArrayList<Venditore> listaVenditori;
    
    public static UtenteFactory getInstance() {
        if (singleton == null) {
            singleton = new UtenteFactory();
        }
        return singleton;
    }
    
    public UtenteFactory() {
        listaUtenti = new ArrayList<>();
        listaClienti = new ArrayList<>();
        listaVenditori = new ArrayList<>();
        
        Venditore cliente1 = new Venditore();
        cliente1.setNome("Annibale_Barca");
        cliente1.setPassword("Elefante");
        Saldo saldo1 = new Saldo();
        saldo1.setProprietario("Annibale_Barca");
        saldo1.setSoldi(300);
        cliente1.setSaldo(saldo1);
        
        listaVenditori.add(cliente1);
        
        Cliente cliente2 = new Cliente();
        cliente2.setNome("Scipione_Africano");
        cliente2.setPassword("Emilia");
        Saldo saldo2 = new Saldo();
        saldo2.setProprietario("Scipione_Africano");
        saldo2.setSoldi(250);
        cliente2.setSaldo(saldo2);
        
        listaClienti.add(cliente2);
        
        listaUtenti.addAll(listaVenditori);
        listaUtenti.addAll(listaClienti);
        
        
    }
    
    public ArrayList<Utente> getListaUtenti()
    {
        return listaUtenti;
    }
    
    public ArrayList<Cliente> getListaClienti()
    {
        return listaClienti;
    }
    
    public ArrayList<Venditore> getListaVenditori(){
        return listaVenditori;
    }
}
