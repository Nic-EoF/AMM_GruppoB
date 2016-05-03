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
public class Libro {
    String nome;
    double prezzo;
    double quantità;
    String immagine;
    
    public Libro(){
        nome="";
        prezzo=0;
        quantità=0;
        immagine="";
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
}
