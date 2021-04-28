package it.unibs.pga.CodiceFiscale;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamException;
import java.io.FileInputStream;

public class GeneratoreCodiceFiscale {

    /**
     * NON TOCCARE
     * <br> questo è il metodo in cui andremo a creare il codice fiscale
     * <br>vero e proprio, non usatelo ancora peer piacere
     * ho aggiunto solo il nome per verificare la veridicità di ciò che ho scritto (agg: riga 25-26)
     *
     * <br>-Alfiere
     */
    public String generatore(int id) throws XMLStreamException {

        String id_string= String.valueOf(id);
        String cognome= prendi_cognome(id_string);
        String nome = prendi_nome(id_string);
        String data_nasctita = prendiDataNascita(id_string);
        String codice_comune = prendiComune(id_string);
        String stringa_preliminare = cognome + nome + data_nasctita + codice_comune;
        String carattere= letteraDiControllo(stringa_preliminare);
        String cog_nome = cognome + nome + data_nasctita + codice_comune + carattere;
        return cog_nome;
    }

    public String prendi_cognome(String id) throws XMLStreamException {

        Gestione gs= new Gestione();

        String cognome = leggiDatoXML(id, "cognome");
        //Quindi qui abbiamo una stringa con il cognome preso dal file testo XML
        String cognomeCF= "";
        //Ora per estrapolare le prime tre consonanti mi ciclo sulla stinga e mi prendo le prime tre
        //qual'ora non ci fossero abbastanza consonati prendo la prima vocale e qual'ora le lettere non bastassero
        //metto una X

        for(int i = 0; i < cognome.length() && cognomeCF.length() < 3; i++){
            if (gs.controlloConsonanti(cognome.charAt(i))){
                cognomeCF+=cognome.charAt(i);
            }
        }

        for (int j=0; j< cognome.length(); j++){
            if (cognomeCF.length()<3 && gs.controlloVocali(cognome.charAt(j))){
                cognomeCF+= cognome.charAt(j);
            }
        }
        int cdf_ln =cognomeCF.length();
        for (int k=0; k< 3-cdf_ln; k++){
            cognomeCF+= "X";
        }

        return cognomeCF;
    }

    public String prendi_nome(String id) throws XMLStreamException {

        Gestione gs= new Gestione();

        String nome = leggiDatoXML(id, "nome");
        //Quindi qui abbiamo una stringa con il gnome preso dal file testo XML
        String nomeCF= "";
        /*
        ora dobbiamo fare un passaggio in più rispetto al metodo per il cognome
        perchè a differenza di quello, ilnome se ha 4 o più consonanti
        bisogna prendere la prima, la terza e la quarta. nel caso invece che il nome non possiede 4 consonanti
        si procede esattamente come per il cognome
         */
        int conta_consonanti = 0; //per sapere se il nome possiede almeno 4 consonati
        for (int i = 0; i < nome.length(); i++){
            if (gs.controlloConsonanti(nome.charAt(i))){
                conta_consonanti++;
            }
        }

        if (conta_consonanti >= 4){
            int conto = 0; //mi serve per contare a che consonante sono, in modo tale da saltare la seconda
            for (int k = 0; k < nome.length() && nomeCF.length() < 3; k++){
                if (gs.controlloConsonanti(nome.charAt(k))){
                    if (conto == 1){
                        conto++;
                        continue;
                    }
                    nomeCF += nome.charAt(k);
                    conto++;
                }
            }
        }else {
            for (int i = 0; i < nome.length() && nomeCF.length() < 3; i++) {
                if (gs.controlloConsonanti(nome.charAt(i))) {
                    nomeCF += nome.charAt(i);
                }
            }
        }

        for (int j=0; j< nome.length(); j++){
            if (nomeCF.length()<3 && gs.controlloVocali(nome.charAt(j))){
                nomeCF+= nome.charAt(j);
            }
        }
        int cdf_ln =nomeCF.length();
        for (int k=0; k< 3-cdf_ln; k++){
            nomeCF+= "X";
        }

        return nomeCF;
    }

    /**
     * DA VEDERE SE SI RIESCE AD OTTIMMIZZARE (io ho una mezza idea)
     * il metodo per il giorno ho usato uno mio ma è da sostituire con quello di Daniele
     * Ho momentaneamente utilizzato il mio perchè non capendo troppo il codice scritto mi dava errori
     * quindi appena ci vediamo me lo spieghi e lo uniamo
     *
     * metodo che prende in input la data completa e mi torna il pezzo di codice fiscale corrispondente
     * per l'anno prende le utime due cifre, per il mese avviene una conversione del numero
     * alla lettera corrispondente, e il giorno va in base al sesso, se femminile aumenta di 40, altrimenti
     * resta tale
     * @param id
     * @return
     * @throws XMLStreamException
     */
    public String prendiDataNascita(String id) throws XMLStreamException{

        Gestione gs = new Gestione();

        String data = leggiDatoXML(id, "data_nascita");
        String sesso = leggiDatoXML(id, "sesso");
        String codice_nascita = "";
        String anno = String.valueOf(data.charAt(2)) + String.valueOf(data.charAt(3));
        String mese = String.valueOf(data.charAt(5)) + String.valueOf(data.charAt(6));
        Integer ms = Integer.valueOf(mese);
        char codice_mese = gs.conversioneMese(ms);
        String giorno_nascita = String.valueOf(data.charAt(8)) + String.valueOf(data.charAt(9));
        //String data_giorno = giorno(sesso, giorno_nascita);
        Integer gg = Integer.valueOf(giorno_nascita);
        String giorno = giorno(sesso, data);
        codice_nascita = anno + codice_mese + giorno;

        return codice_nascita;
    }

    /**
     *metodo che prende sia il sesso della persona sia la sua data di nascita, attraverso il metodo split dividiamo la data rispettivamente
     * parti[0] contiene l'anno, parti[1] il mese, parti[2] contiene il giorno che prenderemo trasformandolo in un intero per
     * poter aggiungere +40 in caso si stia parlando di una femmina o nel caso di un maschio non aggiungere nulla.
     * fatto ciò viene ritrasformato in una stringa per poterlo restituire.
     * @param sesso
     * @param data
     * @return
     */
    public String giorno(String sesso, String data){
        String[] parti = data.split("-");
        String data_giorno = parti[2];
    //       String DataGiorno = parti[2];
        int risultato_intero = Integer.parseInt(data_giorno);
        if(sesso.equals("F"))
            risultato_intero = risultato_intero + 40;

        String risultato = String.valueOf(risultato_intero);
        if (risultato.length()== 1){
            risultato= "0"+ risultato;
        }
        return risultato;
    }

    /**
     * Metodo per i comuni di nascita:
     *     da input si prende il comune che entra  in un controllo nella lista dei comuni xml
     *     e ci ritorna il codice del comune
     *     poi ritornerà la solita stringa che andrà alla fine ad unirsi al cf
     * @param id
     * @return
     * @throws XMLStreamException
     */
    public String prendiComune(String id) throws XMLStreamException{
        String comune_di_nascita = leggiDatoXML(id, "comune_nascita");
        //metodo di ricerca inserendo una stringa mi deve tornare ciò che mi serve
        //sarà comune perchè mi serve in più parti
        String codice_comune = leggiComuneXML(comune_di_nascita);
        return codice_comune;
    }

    /**
     * secondo me si può generalizzare per adattarelo anche ai controlli che dovremo fare poi
     * @param stringa_da_cercare
     * @return
     */
//    public String ricerca(String stringa_da_cercare){
//        boolean trovato = false;
//        do{
//            String comune = leggiDatoXML(id)
//            if(stringa_da_cercare.equals())
//        }while(!trovato /*|| o sono finiti i comuni ma non penso sia da contemplare*/ );
//    }


   // public String comuni(){
    //    String codice_comune=imput;
        // SE risulta dentro lo START_DOCUMENT codice bisogna aquisirlo come stringa
    //}


    /**
     *  QUESTO BELLISSIMO METODO DI M mi ritorna  LA STRINGA FINALE DEL CF
     *  se di commenta l'ultima parte e dsi decommenta la parte commentata ritorna la lettera di controllo e basta
     * @param codice_fiscale
     * @return
     */
    public String letteraDiControllo (String codice_fiscale){
        Gestione gs = new Gestione();
        int valore = 0;
        for(int i = 0; i < 15; i = i + 2){
            valore += gs.tabellaDispari(codice_fiscale.charAt(i));
        }
        for(int i = 1; i < 15; i = i + 2){
            valore += gs.tabellaPari(codice_fiscale.charAt(i));
        }
        valore = valore % 26;
        char carattere_controllo = gs.tabellaConversione(valore);
        String caratterino_finale = String.valueOf(carattere_controllo);
        return caratterino_finale;
//        codice_fiscale += carattere_controllo;
//        return codice_fiscale;
    }

    /**
     * NON TOCCARE
     *
     * <br>-Alfiere
     *
     * <br> sistemare il ciclo for, implementare un while?
     *
     * @param id
     * @param elemento_necessario
     * @return carattere_necessario ossia quello che cerchiamo di una persona(nome, cognome, sesso...)
     * @throws XMLStreamException
     */
   public String leggiDatoXML(String id, String elemento_necessario) throws XMLStreamException{

       String carattere_necessario= null;
       boolean trovato = false;

       XMLInputFactory xmlif = null;
       XMLStreamReader xmlr = null;
       try {
           xmlif = XMLInputFactory.newInstance();
           xmlr = xmlif.createXMLStreamReader("inputPersone.xml", new FileInputStream("inputPersone.xml"));
       } catch (Exception e) {
           System.out.println("Errore nell'inizializzazione del reader:");
           System.out.println(e.getMessage());
       }
       while (xmlr.hasNext() && !trovato){

          if (xmlr.getEventType()==XMLStreamConstants.START_ELEMENT && xmlr.getAttributeCount()>0 && xmlr.getAttributeValue(0).equals(id)) {//START_ELEMENT dà come risultato un intero
              xmlr.next();
              while (!controlloInput(xmlr)) {
                  xmlr.next();

                  if (xmlr.getEventType()==XMLStreamConstants.START_ELEMENT && xmlr.getLocalName().equals(elemento_necessario)){
                      xmlr.next();
                      carattere_necessario= xmlr.getText();
                      //è possibile andare a cancellare un elemento dal XML dato?
                      trovato= true;
                      break;
                  }

              }
          }
          xmlr.next();
       }
       return carattere_necessario;
   }

    public boolean controlloInput (XMLStreamReader xmlr){
        if (xmlr.getEventType()== XMLStreamConstants.END_ELEMENT){
            if (xmlr.getLocalName().equals("persona")){
                return true;
            }
        }
        return false;
    }


    /**
     * per funzionare funziona. è da capire e sistemare se si vuole
     *
     */
    public String leggiComuneXML(String stringa_da_trovare) throws XMLStreamException{

        //String carattere_necessario= null;
        boolean trovato = false;

        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr = null;
        try {
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader("comuni.xml", new FileInputStream("comuni.xml"));
        } catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del reader:");
            System.out.println(e.getMessage());
        }

        String codice_comune = "";
        while (xmlr.hasNext() && !trovato){
            if (xmlr.getEventType()== XMLStreamConstants.START_ELEMENT && xmlr.getLocalName().equals("comune")) {
                while (!controlloComuni(xmlr)){
                    if (xmlr.getEventType() == XMLStreamConstants.START_ELEMENT && xmlr.getLocalName().equals("nome")) {
                        xmlr.next();
                        if (xmlr.getEventType()==XMLStreamConstants.CHARACTERS && xmlr.getText().equals(stringa_da_trovare)){

                            do{
                                xmlr.next();
                            }while(!controlloCodiceComune(xmlr));

                            codice_comune += xmlr.getText();
                            trovato = true;
                            break;
                        }
                    }
                    xmlr.next();
                }
            }
            xmlr.next();
        }
        return codice_comune;

    }

    public boolean controlloComuni (XMLStreamReader xmlr){
        if (xmlr.getEventType()== XMLStreamConstants.END_ELEMENT){
            if (xmlr.getLocalName().equals("comune")){
                return true;
            }
        }
        return false;
    }

    public boolean controlloCodiceComune(XMLStreamReader xmlr){
        if (xmlr.getEventType()==XMLStreamConstants.CHARACTERS && xmlr.getText().trim().length() > 0) {
            return true;
        }
        return false;
    }


    /*
    DA FINIRE COGLIONE MARIO

    si può fare anche come boolean ma dipende da dove lo mettiamo
     */
//    public String controllaCodiciFiscaliXML(String stringa_da_trovare) throws XMLStreamException{
//        String esistenza = null;
//        boolean trovato = false;
//
//        XMLInputFactory xmlif = null;
//        XMLStreamReader xmlr = null;
//        try {
//            xmlif = XMLInputFactory.newInstance();
//            xmlr = xmlif.createXMLStreamReader("codiciFiscali.xml", new FileInputStream("codiciFiscali.xml"));
//        } catch (Exception e) {
//            System.out.println("Errore nell'inizializzazione del reader:");
//            System.out.println(e.getMessage());
//        }
//
//        while (xmlr.hasNext() && !trovato){
//            if (xmlr.getEventType()== XMLStreamConstants.START_ELEMENT && xmlr.getLocalName().equals("codici")) {
//                while (!controlloComuni(xmlr)){
//                    if (xmlr.getEventType() == XMLStreamConstants.START_ELEMENT && xmlr.getLocalName().equals("codice")) {
//                        xmlr.next();
//                        if (xmlr.getEventType()==XMLStreamConstants.CHARACTERS && xmlr.getText().equals(stringa_da_trovare)){
//
//                            do {
//                                xmlr.next();
//                            }while(xmlr.getEventType()!=XMLStreamConstants.CHARACTERS);
//
//                            esistenza += xmlr.getText();
//                            trovato = true;
//                            System.out.println(esistenza);
//                            break;
//
//                        }
//                    }
//                    xmlr.next();
//                }
//            }
//            xmlr.next();
//        }
//        System.out.println("ASSENTE");
//        return esistenza;
//    }
//    public boolean controlloSu (XMLStreamReader xmlr){
//        if (xmlr.getEventType()== XMLStreamConstants.END_ELEMENT){
//            if (xmlr.getLocalName().equals("comune")){
//                return true;
//            }
//        }
//        return false;
//    }

}