/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharma.future;

/**
 *
 * @author salvatore spezia
 */
public class ConsegnaControl {
    
    public boolean controlloFirma(String codice, String nome_farmacia){
        
        DBMSBoundaryAzienda db = new DBMSBoundaryAzienda();
        String codiceDB = db.getCodiceConsegna(nome_farmacia);
        
        if(codiceDB.equals(codice)){
            return true;
        }else{
            return false;
        }
        
    }
    
    public void effettuaConsegna(int id_ordine){
        
        DBMSBoundaryAzienda db = new DBMSBoundaryAzienda();
        
        // spuntare l'ordine con consegnato = 1
        db.ordineConsegnato(id_ordine);
        
        // spunta la consegna
        //db.rimuoviConsegna(id_ordine);
        db.consegnaConsegnata(id_ordine);
        
    }
    
}
