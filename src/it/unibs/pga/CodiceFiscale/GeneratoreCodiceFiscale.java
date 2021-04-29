package it.unibs.pga.CodiceFiscale;

import javax.xml.stream.XMLStreamException;

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
        //controllaCodiciFiscaliXML(cog_nome);
        return cog_nome;
    }

    public String prendi_cognome(String id) throws XMLStreamException {

        Gestione gs= new Gestione();
        InterazioneXML interagisci = new InterazioneXML();

        String cognome = interagisci.leggiDatoXML(id, "cognome");
        String cognomeCF= "";

        for(int i = 0; i < cognome.length() && cognomeCF.length() < 3; i++){
            if (gs.controlloConsonanti(cognome.charAt(i))){
                cognomeCF+=cognome.charAt(i);
            }
        }

        for (int j = 0; j < cognome.length(); j++){
            if (cognomeCF.length()<3 && gs.controlloVocali(cognome.charAt(j))){
                cognomeCF+= cognome.charAt(j);
            }
        }
        int cdf_ln = cognomeCF.length();
        for (int k=0; k< 3-cdf_ln; k++){
            cognomeCF+= "X";
        }

        return cognomeCF;
    }

    public String prendi_nome(String id) throws XMLStreamException {

        Gestione gs= new Gestione();
        InterazioneXML interagisci = new InterazioneXML();

        String nome = interagisci.leggiDatoXML(id, "nome");
        String nomeCF= "";

        int conta_consonanti = 0;
        for (int i = 0; i < nome.length(); i++){
            if (gs.controlloConsonanti(nome.charAt(i))){
                conta_consonanti++;
            }
        }

        if (conta_consonanti >= 4){
            int conto = 0;
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


    public String prendiDataNascita(String id) throws XMLStreamException{

        Gestione gs = new Gestione();
        InterazioneXML interagisci = new InterazioneXML();

        String data = interagisci.leggiDatoXML(id, "data_nascita");
        String sesso = interagisci.leggiDatoXML(id, "sesso");
        String codice_nascita = "";
        String anno = String.valueOf(data.charAt(2)) + String.valueOf(data.charAt(3));
        String mese = String.valueOf(data.charAt(5)) + String.valueOf(data.charAt(6));
        Integer ms = Integer.valueOf(mese);
        char codice_mese = gs.conversioneMese(ms);
        String giorno = giorno(sesso, data);
        codice_nascita = anno + codice_mese + giorno;

        return codice_nascita;
    }


    public String giorno(String sesso, String data){

        String[] parti = data.split("-");
        String data_giorno = parti[2];
        int risultato_intero = Integer.parseInt(data_giorno);

        if(sesso.equals("F")) {
            risultato_intero = risultato_intero + 40;
        }
        String risultato = String.valueOf(risultato_intero);

        if (risultato.length()== 1){
            risultato= "0"+ risultato;
        }
        return risultato;
    }


    public String prendiComune(String id) throws XMLStreamException{

        InterazioneXML interagisci = new InterazioneXML();

        String comune_di_nascita = interagisci.leggiDatoXML(id, "comune_nascita");
        String codice_comune = interagisci.leggiComuneXML(comune_di_nascita);

        return codice_comune;
    }


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
    }

}