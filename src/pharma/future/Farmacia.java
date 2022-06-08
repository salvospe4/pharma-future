/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharma.future;

/**
 *
 * @author salvatore spezia
 */
public class Farmacia {
    
    public int id;
    public String nome;
    public String indirizzo;
    public String codice_consegna;
    public String nome_db;
    
    public Farmacia(int id, String nome, String indirizzo, String codice_consegna, String nome_db){
        this.id = id;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.codice_consegna = codice_consegna;
        this.nome_db = nome_db;
    }
    
}
