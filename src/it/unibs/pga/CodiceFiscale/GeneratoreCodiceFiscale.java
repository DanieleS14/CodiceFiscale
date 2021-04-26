package it.unibs.pga.CodiceFiscale;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamException;
import java.io.FileInputStream;

public class GeneratoreCodiceFiscale {

//    public String prendi_cognome(Gestione gs){
//
//        String cognome = "CATTIVELLI";
//        //String cognome = prendiamo il cognome da xml
//        String cognomeCF;
//        //Quindi qui abbiamo una stringa con il cognome preso dal file testo XML
//        //Ora per estrapolare le prime tre consonanti mi ciclo sulla stinga e mi prendo le prime tre
//        //qual'ora non ci fossero abbastanza consonati prendo la prima vocale e qual'ora le lettere non bastassero
//        //metto una X
//        int j=0;
//        for(int i = 0; i < cognome.length(); i++){
//            if (!gs.controlloConsonanti(cognome.charAt(i))){
//                cognomeCF.charAt(j)= String.valueOf(cognome.charAt(i));
//                j++;
//            }
//        }
//        if (cognomeCF.length() < 3){
//            //aggiungere X in coda finchè non diventa di lungheza 3z
//        }
//
//        return cognomeCF;
//    }
//    public String prendi_nome(Gestione gs){
//        int conta = 0;
//        String nome = "FRANCESCA";
//        String nomeCF=null;
//        //String nome = prendo nome da input
//        int j = 0;
//        for(int i = 0; i < nome.length(); i++){
//            if (!gs.controlloConsonanti(nome.charAt(i))){
//                nomeCF.charAt(j)= String.valueOf(nome.charAt(i));
//                j++;
//            }
//        }
//        if (nomeCF.length() < 3){
//            //aggiungere X in coda finchè non diventa di lungheza 3z
//        }
//
//        return nomeCF;
//    }

    /*
    metodi che mancano
    - prendi_nascita: da input si legge la data di nascita.
      prima si prendono le ultime le due cifre dell'anno;
       poi prendiamo il mese e attrraverso un metodo che ci dice la lettera del mese a seconda del numeroe
       infine si prende il giorno e passa attraverso un metodo che ci fornirà la data a seconda del sesso.
       lo si ritorna come una stringa che andrà ad unirsi alla mstringa finale
    - metodi di supporto :
     Metodo per il mese: passandogli un intero ti ritorna, attraverso un if o uno switch, la lettera del mese a cui corrisponde

     Metodo per il giorno: prende in input il sesso della persona in questione e in base a quello se è maschio non fa
     nulla e ci ritorna il dato così com'era
     se femmina gli aggiunge 40
     */
    public String giorno(char sesso, String data){
        String[] parti = data.split("-");
        String DataGiorno = parti[2];
        int RisultatoIntero = Integer.parseInt(DataGiorno);
        if(sesso=='F')
            RisultatoIntero = RisultatoIntero + 40;

        String Risultato = String.valueOf(RisultatoIntero);
        return Risultato;
    }

    /*
    Metodo per i comuni di nascita:
    da imput si prende il comune che entra  in un controllo nella lista dei comuni xml
    e ci ritorna il codice del comune
    poi ritornerà la solita stringa che andrà alla fine ad unirsi al cf
     */

   // public String comuni(){
    //    String codice_comune=imput;
        // SE risulta dentro lo START_DOCUMENT codice bisogna aquisirlo come stringa
    //}

    /*
    Metodo per carattere di controllo: (Se volete lo fa volentieri la CATTI)
    lol:-)     si guarda da internet che è spiegato benissimo
     */


   public void XMLABBOZZO() throws XMLStreamException {

       XMLInputFactory xmlif = null;
       XMLStreamReader xmlr = null;
       try {
           xmlif = XMLInputFactory.newInstance();
           xmlr = xmlif.createXMLStreamReader("codiciFiscali.xml", new FileInputStream("codiciFiscali.xml"));
       } catch (Exception e) {
           System.out.println("Errore nell'inizializzazione del reader:");
           System.out.println(e.getMessage());
       }
       while (xmlr.hasNext()) { // continua a leggere finché ha eventi a disposizione
           switch (xmlr.getEventType()) { // switch sul tipo di evento
               case XMLStreamConstants.START_DOCUMENT: // inizio del documento: stampa che inizia il documento
                   System.out.println("Start Read Doc " + "codiciFiscali.xml");
                   break;
               case XMLStreamConstants.START_ELEMENT: // inizio di un elemento: stampa il nome del tag e i suoi attributi
                   System.out.println("Tag " + xmlr.getLocalName());
                   for (int i = 0; i < xmlr.getAttributeCount(); i++)
                       System.out.printf(" => attributo %s->%s%n", xmlr.getAttributeLocalName(i), xmlr.getAttributeValue(i));
                   break;
               case XMLStreamConstants.END_ELEMENT: // fine di un elemento: stampa il nome del tag chiuso
                   System.out.println("END-Tag " + xmlr.getLocalName());
                   break;
               case XMLStreamConstants.COMMENT:
                   System.out.println("// commento " + xmlr.getText());
                   break; // commento: ne stampa il contenuto
               case XMLStreamConstants.CHARACTERS: // content all’interno di un elemento: stampa il testo
                   if (xmlr.getText().trim().length() > 0) // controlla se il testo non contiene solo spazi
                       System.out.println("-> " + xmlr.getText());
                   break;
           }
           xmlr.next();
       }

   }

   public void leggiIntero() throws XMLStreamException{

       XMLInputFactory xmlif = null;
       XMLStreamReader xmlr = null;
       try {
           xmlif = XMLInputFactory.newInstance();
           xmlr = xmlif.createXMLStreamReader("codiciFiscali.xml", new FileInputStream("codiciFiscali.xml"));
       } catch (Exception e) {
           System.out.println("Errore nell'inizializzazione del reader:");
           System.out.println(e.getMessage());
       }
       while (xmlr.hasName()){

       }

    }
/*
 codice fiscale
 metodo genera cf
 crea una stringa dove unisce i metodi sopra
     strng = prendi_cognome + prendi nome + .....
     */
}
