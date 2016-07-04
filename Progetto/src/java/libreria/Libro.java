/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

/**
 *
 * @author utente
 */
public class Libro {
    Integer n;
    String nome;
    double prezzo;
    double quantità;
    String immagine;
    
    public Libro(){
     
    }
    
    public double getQuantità() {
        return quantità;
    }

    public void setQuantità(double quantità) {
        this.quantità = quantità;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
    
    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }
    
    public Integer getN(){
        return n;
    }
    
    public void setN(Integer n){
        this.n=n;
    }
}
