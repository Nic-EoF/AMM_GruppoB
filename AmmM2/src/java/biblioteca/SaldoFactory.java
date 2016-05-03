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
public class SaldoFactory {
    private static SaldoFactory singleton;
    
    public static SaldoFactory getInstance(){
        if(singleton == null){
            singleton = new SaldoFactory();
        }
        return singleton;
    }
        
        ArrayList<Saldo> listaSaldo = new ArrayList<Saldo>();
        public SaldoFactory(){
            
            Saldo saldo1 = new Saldo();
            saldo1.setProprietario("Annibale_Barca");
            saldo1.setSoldi(300);
            listaSaldo.add(saldo1);
            Saldo saldo2 = new Saldo();
            saldo2.setProprietario("Scipione_Africano");
            saldo2.setSoldi(120);
            listaSaldo.add(saldo2);
        }

        public ArrayList<Saldo> getSaldoList(){
        return listaSaldo;
        }

   
    
}
