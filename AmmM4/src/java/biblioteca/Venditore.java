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
public class Venditore extends Utente{  ///classe venditore con i relativi metodi. estende Utente
        
        public Venditore(){
            super();
            
        }
        
    /**
     *
     * @return
     */
    @Override
         public Saldo getSaldo() {
        return saldo;
    }

    /**
     *
     * @param saldo
     */
    @Override
    public void setSaldo(Saldo saldo) {
        this.saldo = saldo;
    }

        @Override
    public String getNome() {
        return nome;
    }

        @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

        @Override
    public String getPassword() {
        return password;
    }

        @Override
    public void setPassword(String password) {
        this.password = password;
    }
}
