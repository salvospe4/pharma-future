/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharma.future;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Date;


/**
 *
 * @author salvatore spezia
 */
public class DBMSBoundaryAzienda {
    
    Connection Con = null;
    Statement St = null;
    ResultSet Rs = null;
    
    
    
    public String[] accedi(String username){
        String password = null;
        String tipo = null;
        String query = "select password, tipo from dipendente where username='"+username+"'";
        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
            St = Con.createStatement();
            Rs = St.executeQuery(query);
            while(Rs.next()){
                password = Rs.getString("password");
                tipo = Rs.getString("tipo");
            }
            Con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        String[] result = {password, tipo};
        return result;
    }
    
    public Farmacia creaSessione(String username){
        System.out.println("Sono dentro dbms");
        int id_farmacia = 0;
        String nome = null;
        String indirizzo = null;
        String codice_consegna = null;
        String nome_db = null;
        String query = "select id_farmacia, nome, indirizzo, codice_consegna, nome_db from farmacia where ref_farmacista='"+username+"'";
        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
            St = Con.createStatement();
            Rs = St.executeQuery(query);
            while(Rs.next()){
                id_farmacia = Rs.getInt("id_farmacia");
                nome = Rs.getString("nome");
                indirizzo = Rs.getString("indirizzo");
                codice_consegna = Rs.getString("codice_consegna");
                nome_db = Rs.getString("nome_db");
            }
            Con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return new Farmacia(id_farmacia, nome, indirizzo, codice_consegna, nome_db);
    }
    
    
    public int inserisciFarmaco(String nome, String principioAttivo, int banco, int giorniScadenza){
        int id_farmaco = 0;
        try{
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
            PreparedStatement add = Con.prepareStatement("insert into farmaco(nome, principio_attivo, banco, giorni_alla_scadenza) values(?,?,?,?)");
            add.setString(1, nome);
            add.setString(2, principioAttivo);
            add.setInt(3, banco);
            add.setInt(4, giorniScadenza);     
            int row = add.executeUpdate();
            Con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        id_farmaco = this.getIdFarmaco(nome, principioAttivo);
        return id_farmaco;
    }
    
    public int getIdFarmaco(String nome, String principioAttivo){
        String query = "select id_farmaco from farmaco where nome='" + nome + "' and principio_attivo='" + principioAttivo +"';";
        int ID = 0;
        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
            St = Con.createStatement();
            Rs = St.executeQuery(query);
            if(Rs.next()){
                ID = Rs.getInt("id_farmaco");
            }
            Con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ID;
    }
    
    public void setProduzione(int idFarmaco, int frequenza, int qty, String oggi){
        
        try{
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
            PreparedStatement add = Con.prepareStatement("insert into produzione(ref_farmaco, frequenza, quantita, data_prossima_produzione) values(?,?,?,?)");
            add.setInt(1, idFarmaco);
            add.setInt(2, frequenza);
            add.setInt(3, qty);
            add.setString(4, oggi);
            int row = add.executeUpdate();
            Con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public int getQuantitaFarmaco(int id_farmaco){
        int qty = 0;
        String query = "select quantita from lotto where ref_farmaco='" + id_farmaco + "';";
        
        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
            St = Con.createStatement();
            Rs = St.executeQuery(query);
            while(Rs.next()){
                qty += Rs.getInt("quantita");
            }
            Con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return qty;
    }
    
    public int getQtyScadenzaMaggiore2Mesi(String sogliaScadenza){
        int qty = 0;
        String query = "select quantita from lotto where data_scadenza>'" + sogliaScadenza +"';";
        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
            St = Con.createStatement();
            Rs = St.executeQuery(query);
            while(Rs.next()){
                qty += Rs.getInt("quantita");
            }
            Con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return qty;
    }
    
    public void effettuaOrdine(int id_farmaco, int id_farmacia, int qty){

        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
            PreparedStatement add = Con.prepareStatement("insert into ordine(ref_farmaco, ref_farmacia, quantita) values(?,?,?)");
            add.setInt(1, id_farmaco);
            add.setInt(2, id_farmacia);
            add.setInt(3, qty);
            int row = add.executeUpdate();
            Con.close();   
        }catch(SQLException e){
            e.printStackTrace();
        }
        this.riduciQtyLotti(id_farmaco, qty);
    
    }
    
    public void riduciQtyLotti(int id_farmaco, int qty){
        int quantita = qty;
        // prendi l'elenco lotti per ordine di scadenza crescente
        try{
            Connection Con2 = null;
            Statement St2 = null;
            ResultSet Rs2 = null;
            String query = "select id_lotto, quantita, data_scadenza from lotto where ref_farmaco="+ id_farmaco +" order by data_scadenza ASC";
            Con2 = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
            St2 = Con2.createStatement();
            Rs2 = St2.executeQuery(query);
            while(Rs2.next() & quantita>0){
                if(quantita >= Rs2.getInt("quantita")){
                    // inserisci lotto ordinato
                    int id_lotto = Rs2.getInt("id_lotto");
                    int quantita_lotto = Rs2.getInt("quantita");
                    String data_scadenza = Rs2.getString("data_scadenza");
                    this.inserisciLottoOrdinato(id_lotto, quantita_lotto, data_scadenza);

                    // cancella riga
                    this.rimuoviLotto(id_lotto);
                    
                    
                    quantita -= quantita_lotto;
                    
                }else{
                    // inserisci lotto ordinato
                    int id_lotto = Rs2.getInt("id_lotto");
                    int quantita_lotto = Rs2.getInt("quantita");
                    String data_scadenza = Rs2.getString("data_scadenza");
                    this.inserisciLottoOrdinato(id_lotto, quantita, data_scadenza);
                    
                    //riduci quantità
                    this.aggiornaQtyLotto(id_lotto, quantita_lotto - quantita);
                    
                    quantita = 0;
                }
                
            }
            Con2.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    
    }
    
    public void rimuoviLotto(int id_lotto){
        
        try{
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
                String Query = "Delete from lotto where id_lotto="+id_lotto+";";
                Statement Add = Con.createStatement();
                Add.executeUpdate(Query);
                Con.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        
    }
    
    public void aggiornaQtyLotto(int id_lotto, int qty){
        
        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
            String UpdateQuery = "update lotto set quantita=" + qty + " where id_lotto="+id_lotto+";";
            Statement Add = Con.createStatement();
            Add.executeUpdate(UpdateQuery);
            Con.close();
        }catch(SQLException e){
                e.printStackTrace();
        }
        
    }
    
    public void inserisciLottoOrdinato(int id_lotto, int qty, String data_scadenza){
        
        int id_ordine = this.getIdUltimoOrdine();
        
        if(id_ordine != 0){
            try{
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
                PreparedStatement add = Con.prepareStatement("insert into lotto_ordinato(ref_lotto, ref_ordine, data_scadenza, quantita) values(?,?,?,?)");
                add.setInt(1, id_lotto);
                add.setInt(2, id_ordine);
                add.setString(3, data_scadenza);
                add.setInt(4, qty);
                int row = add.executeUpdate();
                Con.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        
        }
    
    }
    
    public void inserisciConsegna(int id_farmacia, String dataConsegna){
        int id_ordine = this.getIdUltimoOrdine();
        
        if(id_ordine != 0){
            try{
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
                PreparedStatement add = Con.prepareStatement("insert into consegna(ref_ordine, data_consegna, ref_farmacia) values(?,?,?)");
                add.setInt(1, id_ordine);
                add.setString(2, dataConsegna);
                add.setInt(3, id_farmacia);
                int row = add.executeUpdate();
                Con.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        
        }
        
        
    }
    
    
    public void rimuoviOrdine(int id_ordine){
        try{
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
                String Query = "Delete from ordine where id_ordine="+id_ordine+";";
                Statement Add = Con.createStatement();
                Add.executeUpdate(Query);
                Con.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
    
    }
    
    public void rimuoviConsegna(int id_ordine){
        
        try{
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
                String Query = "Delete from consegna where ref_ordine="+id_ordine+";";
                Statement Add = Con.createStatement();
                Add.executeUpdate(Query);
                Con.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
    }
    
    
    public int getIdUltimoOrdine(){
        int id_ordine = 0;
        try{ // recuperare l'id dell'ordine
            String query = "select id_ordine from ordine order by id_ordine DESC";
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
            St = Con.createStatement();
            Rs = St.executeQuery(query);
            while(Rs.next()){
                id_ordine = Rs.getInt("id_ordine");
                break;
            }
            Con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return id_ordine;
    }
    
    public String getDataScadenzaLotto(int id_lotto){
        
        String dataScadenza = new String();
        
        try{
            String query = "select data_scadenza from lotto where id_lotto=" + id_lotto + ";";
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
            St = Con.createStatement();
            Rs = St.executeQuery(query);
            if(Rs.next()){
                dataScadenza = Rs.getString("data_scadenza");
            }
            Con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

        return dataScadenza;
    }
    
    
    public void recuperaLottiOrdinati(int id_ordine){
        int id_lotto_ordinato, id_lotto, qty, id_farmaco;
        String data_scadenza;        
        System.out.println("sono dentro ripristinaLotto");
        try{
            String query = "select lotto_ordinato.id_lotto_ordinato, lotto_ordinato.ref_lotto, lotto_ordinato.quantita, ordine.ref_farmaco, lotto_ordinato.data_scadenza from lotto_ordinato, ordine where lotto_ordinato.ref_ordine=ordine.id_ordine and ordine.id_ordine=" + id_ordine + ";";
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
            St = Con.createStatement();
            Rs = St.executeQuery(query);
            while(Rs.next()){
                System.out.println("sono dentro il while");
                id_lotto_ordinato = Rs.getInt("id_lotto_ordinato");
                id_lotto = Rs.getInt("ref_lotto");
                qty = Rs.getInt("quantita");
                id_farmaco = Rs.getInt("ref_farmaco");
                data_scadenza = Rs.getString("data_scadenza");
                this.ripristinaLotto(id_lotto, qty, id_farmaco, data_scadenza);
                this.rimuoviLottoOrdinato(id_lotto_ordinato);
                        
            }
            Con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    
    
    }
    public void recuperaLottoOrdinato(int id_ordine, int id_lotto_ordinato){
        int id_lotto, qty, id_farmaco;
        String data_scadenza;        
        //System.out.println("sono dentro ripristinaLotto");
        try{
            String query = "select lotto_ordinato.ref_lotto, lotto_ordinato.quantita, ordine.ref_farmaco, lotto_ordinato.data_scadenza from lotto_ordinato, ordine where lotto_ordinato.ref_ordine=ordine.id_ordine and lotto_ordinato.id_lotto_ordinato="+ id_lotto_ordinato +";";
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
            St = Con.createStatement();
            Rs = St.executeQuery(query);
            if(Rs.next()){
                //System.out.println("sono dentro il while");
                id_lotto = Rs.getInt("ref_lotto");
                qty = Rs.getInt("quantita");
                id_farmaco = Rs.getInt("ref_farmaco");
                data_scadenza = Rs.getString("data_scadenza");
                this.ripristinaLotto(id_lotto, qty, id_farmaco, data_scadenza);
                this.rimuoviLottoOrdinato(id_lotto_ordinato);
                        
            }
            Con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    
    
    }
    

    
    public void ripristinaLotto(int id_lotto, int qty, int id_farmaco, String data_scadenza){
        try{
            String query = "select id_lotto, quantita from lotto where id_lotto=" + id_lotto + ";";
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
            St = Con.createStatement();
            Rs = St.executeQuery(query);
            if(Rs.next()){
                // incrementa quantità
                System.out.println("sono dentro ripristinaLotto -> if incrementa");
                int qty_tot = qty + Rs.getInt("quantita");
                this.aggiornaQtyLotto(id_lotto, qty_tot);
            }else{
                // aggiungi lotto
                System.out.println("sono dentro ripristinaLotto -> else aggiungi");
                this.aggiungiLotto(id_farmaco, qty, data_scadenza);
            }
            Con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    
    }
    
    public void aggiungiLotto(int id_farmaco, int qty, String data_scadenza){
        try{
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
                PreparedStatement add = Con.prepareStatement("insert into lotto(ref_farmaco, quantita, data_scadenza) values(?,?,?)");
                add.setInt(1, id_farmaco);
                add.setInt(2, qty);
                add.setString(3, data_scadenza);
                int row = add.executeUpdate();
                System.out.println("sono dentro aggiungi lotto");
                Con.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
    
    }
    
    public void rimuoviLottoOrdinato(int id_lotto_ordinato){
        try{
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
                String Query = "Delete from lotto_ordinato where id_lotto_ordinato="+id_lotto_ordinato+";";
                Statement Add = Con.createStatement();
                Add.executeUpdate(Query);
                //System.out.println("sono dentro rimuovi lotto ordinato");
                Con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    
    }
    
    public String getCodiceConsegna(String nome_farmacia){
        
        String codice = new String();
        
        try{
            String query = "select codice_consegna from farmacia where nome='" + nome_farmacia + "';";
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
            St = Con.createStatement();
            Rs = St.executeQuery(query);
            if(Rs.next()){
                codice = Rs.getString("codice_consegna");
            }
            Con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

        return codice;
        
    }
    
    public void ordineConsegnato(int id_ordine){
        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
            String UpdateQuery = "update ordine set consegnato=1 where id_ordine="+id_ordine+";";
            Statement Add = Con.createStatement();
            Add.executeUpdate(UpdateQuery);
            Con.close();
        }catch(SQLException e){
                e.printStackTrace();
        }
    
    }
    
    public void aggiornaProduzione(int id_farmaco, int frequenza, int qty){
        
        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
            String UpdateQuery = "update produzione set frequenza=" + frequenza + ", quantita=" + qty + " where ref_farmaco="+id_farmaco+";";
            Statement Add = Con.createStatement();
            Add.executeUpdate(UpdateQuery);
            Con.close();
        }catch(SQLException e){
                e.printStackTrace();
        }
        
    }
    
    public Lotto getLottoOrdinato(int id_lotto_ordinato){
        Lotto lotto = null;
        try{
            String query = "select lotto_ordinato.id_lotto_ordinato, lotto_ordinato.data_scadenza, lotto_ordinato.quantita, farmaco.id_farmaco, farmaco.nome, farmaco.principio_attivo, farmaco.banco from lotto_ordinato, ordine, farmaco where lotto_ordinato.ref_ordine=ordine.id_ordine and ordine.ref_farmaco=farmaco.id_farmaco and lotto_ordinato.id_lotto_ordinato="+ id_lotto_ordinato +";";
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
            St = Con.createStatement();
            Rs = St.executeQuery(query);
            if(Rs.next()){
                int id_lotto = Rs.getInt("id_lotto_ordinato");
                String data_scadenza = Rs.getString("data_scadenza");
                int qty = Rs.getInt("quantita");
                int id_farmaco = Rs.getInt("id_farmaco");
                String nome_farmaco = Rs.getString("nome");
                String principio_attivo = Rs.getString("principio_attivo");
                int banco = Rs.getInt("banco");
                lotto = new Lotto(id_lotto, data_scadenza, qty, id_farmaco, nome_farmaco, principio_attivo, banco);
            }
            Con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    
        return lotto;
    }
    
    public void consegnaConsegnata(int id_ordine){
        // spunta l'attributo consegnata
        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
            String UpdateQuery = "update consegna set consegnata=1 where ref_ordine="+id_ordine+";";
            Statement Add = Con.createStatement();
            Add.executeUpdate(UpdateQuery);
            Con.close();
        }catch(SQLException e){
                e.printStackTrace();
        }
        
        
    }
    
    public int getIDOrdine(int id_lotto_ordinato){
        int id_ordine = 0;
        try{
            String query = "select ref_ordine from lotto_ordinato where id_lotto_ordinato=" + id_lotto_ordinato + ";";
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
            St = Con.createStatement();
            Rs = St.executeQuery(query);
            if(Rs.next()){
                id_ordine = Rs.getInt("ref_ordine");
            }
            Con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return id_ordine;
    }
    
    public boolean esisteLottoOrdinato(int id_ordine){
                
        try{
            String query = "select id_lotto_ordinato from lotto_ordinato where ref_ordine=" + id_ordine + ";";
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
            St = Con.createStatement();
            Rs = St.executeQuery(query);
            if(Rs.next()){
                return true;
            }
            Con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return false;
        
    
    }
    
    public void produzioneAutomatica(){
        LocalDateTime now = LocalDateTime.now();  
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        String oggi = now.format(format); 
        
        String DATE_FORMAT = "yyyy-MM-dd";
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.ITALIAN);
        Date date = new Date();
        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        
        try{
            String query = "select produzione.id_produzione, produzione.ref_farmaco, produzione.frequenza, produzione.quantita, produzione.data_prossima_produzione, farmaco.giorni_alla_scadenza from produzione, farmaco where produzione.ref_farmaco=farmaco.id_farmaco;";
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
            St = Con.createStatement();
            Rs = St.executeQuery(query);
            while(Rs.next()){
                if(Rs.getString("data_prossima_produzione").equals(oggi)){
                    int id_produzione = Rs.getInt("id_produzione");
                    int id_farmaco = Rs.getInt("ref_farmaco");
                    int frequenza = Rs.getInt("frequenza");
                    int qty = Rs.getInt("quantita");
                    int giorni_alla_scadenza = Rs.getInt("giorni_alla_scadenza");
                    Date currentDatePlusOneDay = Date.from(localDateTime.plusDays(giorni_alla_scadenza).atZone(ZoneId.systemDefault()).toInstant());
                    String scadenza = dateFormat.format(currentDatePlusOneDay);
                    System.out.println(scadenza);
                    this.aggiungiLotto(id_farmaco, qty, scadenza);
                    this.aggiornaDataProssimaProduzione(id_produzione, frequenza);
                }
            }
            Con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    
    }
    
    public void aggiornaDataProssimaProduzione(int id_produzione, int frequenza){
        String DATE_FORMAT = "yyyy-MM-dd";
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.ITALIAN);
        Date date = new Date();
        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        
        Date currentDatePlusOneDay = Date.from(localDateTime.plusDays(frequenza).atZone(ZoneId.systemDefault()).toInstant());
        String data_prossima_produzione = dateFormat.format(currentDatePlusOneDay);
        
        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
            String UpdateQuery = "update produzione set data_prossima_produzione='" + data_prossima_produzione + "' where id_produzione="+id_produzione+";";
            Statement Add = Con.createStatement();
            Add.executeUpdate(UpdateQuery);
            Con.close();
        }catch(SQLException e){
                e.printStackTrace();
        }
        
    }
    
    
    public void ordiniPeriodici(){
        LocalDateTime now = LocalDateTime.now();  
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        String oggi = now.format(format);
        
        try{
            Connection Con2 = null;
            Statement St2 = null;
            ResultSet Rs2 = null;
            String query = "select * from ordini_periodici;";
            Con2 = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
            St2 = Con2.createStatement();
            Rs2 = St2.executeQuery(query);
            while(Rs2.next()){
                if(Rs2.getString("prossimo_ordine").equals(oggi)){
                    int id_ordine_periodico = Rs2.getInt("id_ordine_periodico");
                    int id_farmaco = Rs2.getInt("ref_farmaco");
                    int id_farmacia = Rs2.getInt("ref_farmacia");
                    int frequenza = Rs2.getInt("frequenza");
                    int qty = Rs2.getInt("quantita");
                    //inserisci ordine
                    this.effettuaOrdine(id_farmaco, id_farmacia, qty);
                    // spunta attributo ordine_periodico in ordine
                    this.spuntaOrdinePeriodico(this.getIdUltimoOrdine());
                    // aggiorna data prossimo ordine
                    this.aggiornaDataProssimoOrdine(id_ordine_periodico, frequenza);
                    // calcola data consegna e inserisci consegna
                    String[] s = oggi.split("-");
                    int giorno = Integer.valueOf(s[2]) + 5;
                    String dataConsegna = s[0] + "-" + s[1] + "-" + giorno;
                    this.inserisciConsegna(id_farmacia, dataConsegna);
                }
            }
            Con2.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    
    }
    
    public void spuntaOrdinePeriodico(int id_ordine){
        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
            String UpdateQuery = "update ordine set periodico=1 where id_ordine="+id_ordine+";";
            Statement Add = Con.createStatement();
            Add.executeUpdate(UpdateQuery);
            Con.close();
        }catch(SQLException e){
                e.printStackTrace();
        }
    
    }
    
    public void aggiornaDataProssimoOrdine(int id_ordine_periodico, int frequenza){
        
        String DATE_FORMAT = "yyyy-MM-dd";
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.ITALIAN);
        Date date = new Date();
        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        
        Date currentDatePlusOneDay = Date.from(localDateTime.plusDays(frequenza).atZone(ZoneId.systemDefault()).toInstant());
        String data_prossimo_ordine = dateFormat.format(currentDatePlusOneDay);
        
        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/pharma_future", "salvo", "root");
            String UpdateQuery = "update ordini_periodici set prossimo_ordine='" + data_prossimo_ordine + "' where id_ordine_periodico="+id_ordine_periodico+";";
            Statement Add = Con.createStatement();
            Add.executeUpdate(UpdateQuery);
            Con.close();
        }catch(SQLException e){
                e.printStackTrace();
        }
    }
    
    
    
    
    
    
    
}

