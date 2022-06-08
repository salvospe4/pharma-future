/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharma.future;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;


/**
 *
 * @author salvatore spezia
 */
public class CaricoOre20 extends Thread {
    
    public void run(){
        while(true){
            Calendar cal = new GregorianCalendar();
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            int minute = cal.get(Calendar.MINUTE);
            //int second = cal.get(Calendar.SECOND);
            
            if(hour==20 & minute==0){
                //JOptionPane.showMessageDialog(this, "Carico effettuato");
            }
        }
    
    }
    
}
