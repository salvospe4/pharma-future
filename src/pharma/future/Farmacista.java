/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharma.future;

/**
 *
 * @author salvatore spezia
 */
public class Farmacista {
    
    public String username;
    public Boolean autenticato;
    public Farmacia farmacia;
    
    public Farmacista(String username, String tipo, Boolean autenticato, int id_farmacia, String nome, String indirizzo){
        this.username = username;
        this.autenticato = autenticato;
        //this.farmacia = new Farmacia(id_farmacia, nome, indirizzo);
    }
    
}
