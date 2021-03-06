/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharma.future;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author salvatore spezia
 */
public class ProduzioneControl {
    
    public void inserisciFarmaco(String nome, String principioAttivo, int banco, int giorniScadenza, int frequenza, int qty){
        DBMSBoundaryAzienda db = new DBMSBoundaryAzienda();
        
        //control inserisci farmaco
        int idFarmaco = db.inserisciFarmaco(nome, principioAttivo, banco, giorniScadenza);
        System.out.println(idFarmaco);
        //richiamare setProduzione
        this.setProduzione(idFarmaco, frequenza, qty);
    }
    
    public void setProduzione(int idFarmaco, int frequenza, int qty){
        LocalDateTime now = LocalDateTime.now();  
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        String oggi = now.format(format); 
        
        DBMSBoundaryAzienda db = new DBMSBoundaryAzienda();
        db.setProduzione(idFarmaco, frequenza, qty, oggi);
        this.produzioneAutomatica();
    }
    
    public void modificaProduzione(int id_farmaco, int frequenza, int qty){
        DBMSBoundaryAzienda db = new DBMSBoundaryAzienda();
        db.aggiornaProduzione(id_farmaco, frequenza, qty);
    }
    
    public void produzioneAutomatica(){
        DBMSBoundaryAzienda db = new DBMSBoundaryAzienda();
        db.produzioneAutomatica();
    }
    
}
