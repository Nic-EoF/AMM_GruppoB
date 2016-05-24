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
public class Cliente extends Utente{ //classe cliente con i relativi metodi. Cliente estende Utente
    public Cliente(){
        super();
        
    }
    
    @Override
     public Saldo getSaldo() {
        return saldo;
    }

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

    /**
     *
     * @return
     */
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
}  
