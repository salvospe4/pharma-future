/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharma.future;

/**
 *
 * @author salvatore spezia
 */
public class CaricoControl {
    
    
    public void effettuaCarico(int id_lotto_ordinato, Farmacia farmacia){
        Lotto lotto;
        DBMSBoundaryAzienda dbAzienda = new DBMSBoundaryAzienda();
        lotto = dbAzienda.getLottoOrdinato(id_lotto_ordinato);
        
        DBMSBoundaryFarmacia dbFarmacia = new DBMSBoundaryFarmacia(farmacia);
        
        // se non esiste il farmaco
        if(!dbFarmacia.esisteFarmaco(lotto.nome_farmaco)){
            // aggiungi farmaco in db farmacia
            dbFarmacia.aggiungiFarmaco(lotto.nome_farmaco, lotto.principio_attivo, lotto.banco);
        }
        // aggiungi lotto in magazzino farmacia
        dbFarmacia.aggiungiLotto(lotto);
        
        // recupera id_ordine da id_lotto_ordinato
        int id_ordine = dbAzienda.getIDOrdine(lotto.id_lotto_ordinato);
        // rimuovi lotto ordinato
        dbAzienda.rimuoviLottoOrdinato(lotto.id_lotto_ordinato);
        // se non ci sono più lotti elimino l'ordine e la consegna
        if( !dbAzienda.esisteLottoOrdinato(id_ordine) ){
            // rimuovi consegna
            dbAzienda.rimuoviConsegna(id_ordine);
            // rimuovi ordine
            dbAzienda.rimuoviOrdine(id_ordine);
        }
        
        
    }
    
    public void segnalaMancanze(int id_lotto_ordinato, Farmacia farmacia){
        // questo metodo rimuovere gli ordini e la consegna 
        
        Lotto lotto;
        DBMSBoundaryAzienda dbAzienda = new DBMSBoundaryAzienda();
        lotto = dbAzienda.getLottoOrdinato(id_lotto_ordinato);
        // recupera id_ordine da id_lotto_ordinato
        int id_ordine = dbAzienda.getIDOrdine(lotto.id_lotto_ordinato);
        
        dbAzienda.recuperaLottoOrdinato(id_ordine, id_lotto_ordinato);
        
        // rimuovi lotto ordinato
        dbAzienda.rimuoviLottoOrdinato(lotto.id_lotto_ordinato);
        // se non ci sono più lotti elimino l'ordine e la consegna
        if( !dbAzienda.esisteLottoOrdinato(id_ordine) ){
            dbAzienda.recuperaLottoOrdinato(id_ordine, id_lotto_ordinato);
            new OrdineControl().rimuoviOrdine(id_ordine);
        }
    }
    
}
