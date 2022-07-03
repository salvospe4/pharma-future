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
import java.sql.*;

/**
 *
 * @author salvatore spezia
 */
public class DBMSBoundaryFarmacia {
    
    
    Connection Con = null;
    Statement St = null;
    ResultSet Rs = null;
    
    Farmacia farmacia;
    
    public DBMSBoundaryFarmacia(Farmacia farmacia){
        this.farmacia = farmacia;
    }
    
    public int getQuantitaFarmaco(int id_farmaco){
        int qty = 0;
        String query = "select quantita from magazzino where ref_farmaco='" + id_farmaco + "';";
        
        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/" + farmacia.nome_db, "salvo", "root");
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
    
    public void vendi(int id_farmaco, int qty){
        int quantita = qty;
        try{

            String query = "select id_lotto, ref_farmaco, scadenza, quantita from magazzino where ref_farmaco="+ id_farmaco +" order by scadenza ASC";
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/" + farmacia.nome_db, "salvo", "root");
            St = Con.createStatement();
            Rs = St.executeQuery(query);
            while(Rs.next() & quantita>0){
                if(quantita >= Rs.getInt("quantita")){
                    
                    // cancella riga
                    int id_lotto = Rs.getInt("id_lotto");
                    int quantita_lotto = Rs.getInt("quantita");
                    this.rimuoviLotto(id_lotto);
                    
                    quantita -= quantita_lotto;
                    
                }else{
                                        
                    //riduci quantità
                    int id_lotto = Rs.getInt("id_lotto");
                    int quantita_lotto = Rs.getInt("quantita");
                    this.aggiornaQtyLotto(id_lotto, quantita_lotto - quantita);
                    
                    quantita = 0;
                }
                
            }
            Con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    
    }
    
    public void rimuoviLotto(int id_lotto){
        try{
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/" + farmacia.nome_db, "salvo", "root");
                String Query = "Delete from magazzino where id_lotto="+id_lotto+";";
                Statement Add = Con.createStatement();
                Add.executeUpdate(Query);
                Con.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
    
    }
    
    public void aggiornaQtyLotto(int id_lotto, int qty){
        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/" + farmacia.nome_db, "salvo", "root");
            String UpdateQuery = "update magazzino set quantita=" + qty + " where id_lotto="+id_lotto+";";
            Statement Add = Con.createStatement();
            Add.executeUpdate(UpdateQuery);
            Con.close();
        }catch(SQLException e){
                e.printStackTrace();
        }
    
    }
    
    
    public void aggiungiLotto(Lotto lotto){
        int id_farmaco = this.getIDFarmaco(lotto.nome_farmaco);
        try{
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/" + farmacia.nome_db, "salvo", "root");
                PreparedStatement add = Con.prepareStatement("insert into magazzino(ref_farmaco, scadenza, quantita) values(?,?,?)");
                add.setInt(1, id_farmaco);
                add.setString(2, lotto.data_scadenza);
                add.setInt(3, lotto.qty);
                int row = add.executeUpdate();
                Con.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
    
    }
    
    public int getIDFarmaco(String nome_farmaco){
        
        int id = 0;
        
        String query = "select id_farmaco from farmaco where nome='" + nome_farmaco + "';";
        
        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/" + farmacia.nome_db, "salvo", "root");
            St = Con.createStatement();
            Rs = St.executeQuery(query);
            if(Rs.next()){
                id = Rs.getInt("id_farmaco");
            }
            Con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return id;
        
    }
    
    public void aggiungiFarmaco(String nome, String principio_attivo, int banco){
        try{
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/" + farmacia.nome_db, "salvo", "root");
                PreparedStatement add = Con.prepareStatement("insert into farmaco(nome, principio_attivo, banco) values(?,?,?)");
                add.setString(1, nome);
                add.setString(2, principio_attivo);
                add.setInt(3, banco);
                int row = add.executeUpdate();
                Con.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
    
    }
    
    public boolean esisteFarmaco(String nome_farmaco){
        String query = "select id_farmaco from farmaco where nome='" + nome_farmaco + "';";
        boolean esito = false;
        
        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/" + farmacia.nome_db, "salvo", "root");
            St = Con.createStatement();
            Rs = St.executeQuery(query);
            if(Rs.next()){
                esito = true;
            }
            Con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return esito;
    }
    
    public int scorteFarmaco(String nome_farmaco){
        
        String query = "select magazzino.quantita from magazzino, farmaco where magazzino.ref_farmaco=farmaco.id_farmaco and farmaco.nome='" + nome_farmaco + "';";
        int scorte = 0;
        
        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3308/" + farmacia.nome_db, "salvo", "root");
            St = Con.createStatement();
            Rs = St.executeQuery(query);
            while(Rs.next()){
                scorte += Rs.getInt("quantita");
            }
            Con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        
        return scorte;
    }
    
}
