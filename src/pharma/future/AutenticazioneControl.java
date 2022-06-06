/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharma.future;


/**
 *
 * @author salvatore spezia
 */
public class AutenticazioneControl {
    
    
    public boolean controlloCredenziali(String username, String password, String tipo){
        System.out.println("Inizio control");
        DBMSBoundaryAzienda db = new DBMSBoundaryAzienda();
        String[] result = db.accedi(username);
        //System.out.println(password_db);
        //System.out.println(password);
        if(result[0].equals(password) & result[1].equals(tipo)){
                return true;
        }
        else{
            //System.out.println("credenziali errate");
            return false;
        }
    }
    
    public Farmacia creaSessioneFarmacia(String username){
        System.out.println("Sono dentro la control");
        DBMSBoundaryAzienda db = new DBMSBoundaryAzienda();
        Farmacia farmacia = db.creaSessione(username);
        System.out.println(farmacia.id);
        return farmacia;
    }
}
