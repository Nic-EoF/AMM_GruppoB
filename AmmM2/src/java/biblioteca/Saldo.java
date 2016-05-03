/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

/**
 *
 * @author utente
 */
public class Saldo {
    String proprietario;
    double soldi;
    
    public Saldo(){
        proprietario="";
        soldi=0;
    }
    
    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public double getSoldi() {
        return soldi;
    }

    public void setSoldi(double soldi) {
        this.soldi = soldi;
    }
    
    
}
