package libreria;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author utente
 */
public class Utente {  //sia cliente che venditore estendono questa classe
    String nome;
    String password;
    Saldo saldo;
    
    
    
    public Utente(){
        //id=0;
        //nome="";
        //password="";
        //saldo.proprietario="";
        //saldo.setSoldi(0);
    }

    public Saldo getSaldo() {
        return saldo;
    }

    public void setSaldo(Saldo saldo) {
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the id
     */
  
   
    
    
}
