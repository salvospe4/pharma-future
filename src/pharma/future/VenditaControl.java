/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharma.future;

/**
 *
 * @author salvatore spezia
 */
public class VenditaControl {
    
    Farmacia farmacia;
    
    public VenditaControl(Farmacia farmacia){
        this.farmacia = farmacia;
    }
    
    public int getQuantita(int id_farmaco){
        DBMSBoundaryFarmacia db = new DBMSBoundaryFarmacia(this.farmacia);
        int qty = db.getQuantitaFarmaco(id_farmaco);
        
        return qty;
    }
    
    public void vendi(int id_farmaco, int qty){
        DBMSBoundaryFarmacia db = new DBMSBoundaryFarmacia(this.farmacia);
        
        db.vendi(id_farmaco, qty);
    
    }
    
}
