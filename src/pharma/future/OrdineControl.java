/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharma.future;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author salvatore spezia
 */
public class OrdineControl {
    
    
    
    public int getQuantità(int id_farmaco){
        DBMSBoundaryAzienda db = new DBMSBoundaryAzienda();
        int qtyDB = db.getQuantitaFarmaco(id_farmaco);
        return qtyDB;
    }
    
    public boolean controlloScadenza(int id_farmaco, int qty){
        
        //data di oggi:
        LocalDateTime now = LocalDateTime.now();  
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        String formatDateTime = now.format(format);  
        String[] s = formatDateTime.split("-");
        int mese = Integer.valueOf(s[1]) + 2;
        String sogliaScadenza;
        //System.out.println(mese);
        if(mese < 10){
            sogliaScadenza = s[0] + "-0" + mese + "-" + s[2];
            //System.out.println(sogliaScadenza);
        }else{
            sogliaScadenza = s[0] + "-" + mese + "-" + s[2];
            //System.out.println(sogliaScadenza);
        }
    
        DBMSBoundaryAzienda db = new DBMSBoundaryAzienda();
        int qtyDB = db.getQtyScadenzaMaggiore2Mesi(sogliaScadenza);
        System.out.println(qtyDB);
        if(qtyDB >= qty){
            System.out.println("Tutto OK! Fai ordine");
            return true;
        }else {
            System.out.println("c'è problema ahahah");
            return false;
        }
    }
    
    public void effettuaOrdine(int id_farmaco, int qty, Farmacia farmacia){
        
        DBMSBoundaryAzienda db = new DBMSBoundaryAzienda();
        db.effettuaOrdine(id_farmaco, farmacia.id, qty);
        
        
    }
    
    public void inserisciConsegna(Farmacia farmacia){
        // La data di consegna viene calcolato dopo 2 giorni dalla data di ordine        
        String DATE_FORMAT = "yyyy-MM-dd";
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.ITALIAN);
        Date date = new Date();
        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        
        Date currentDatePlusOneDay = Date.from(localDateTime.plusDays(2).atZone(ZoneId.systemDefault()).toInstant());
        String dataConsegna = dateFormat.format(currentDatePlusOneDay);
        
        
        
        DBMSBoundaryAzienda db = new DBMSBoundaryAzienda();
        db.inserisciConsegna(farmacia.id, dataConsegna);
        
    }
    
    public void rimuoviOrdine(int id_ordine){
        DBMSBoundaryAzienda db = new DBMSBoundaryAzienda();
        
        db.rimuoviConsegna(id_ordine);
        db.rimuoviOrdine(id_ordine);
    }
    
    public void recuperaLotti(int id_ordine){
        DBMSBoundaryAzienda db = new DBMSBoundaryAzienda();
        db.recuperaLottiOrdinati(id_ordine);
    }
    
    
    public void ordiniPeriodici(){
        DBMSBoundaryAzienda db = new DBMSBoundaryAzienda();
        db.ordiniPeriodici();
    }
    
    
}
