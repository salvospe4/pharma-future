/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharma.future;

/**
 *
 * @author salvatore spezia
 */
public class Lotto {
    
    public int id_lotto_ordinato;
    public String data_scadenza;
    public int qty;
    public int id_farmaco;
    public String nome_farmaco;
    public String principio_attivo;
    public int banco;
    
    public Lotto(int id_lotto_ordinato, String data_scadenza, int qty, int id_farmaco, String nome_farmaco, String principio_attivo, int banco){
        this.id_lotto_ordinato = id_lotto_ordinato;
        this.data_scadenza = data_scadenza;
        this.qty = qty;
        this.id_farmaco = id_farmaco;
        this.nome_farmaco = nome_farmaco;
        this.principio_attivo = principio_attivo;
        this.banco = banco;
    }
    
}
