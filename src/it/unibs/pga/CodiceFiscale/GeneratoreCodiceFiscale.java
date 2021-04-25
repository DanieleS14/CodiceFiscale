package it.unibs.pga.CodiceFiscale;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;

public class GeneratoreCodiceFiscale {

    public String prendi_cognome(Gestione gs){

        String cognome = "CATTIVELLI";
        //String cognome = prendiamo il cognome da xml
        String cognomeCF;
        //Quindi qui abbiamo una stringa con il cognome preso dal file testo XML
        //Ora per estrapolare le prime tre consonanti mi ciclo sulla stinga e mi prendo le prime tre
        //qual'ora non ci fossero abbastanza consonati prendo la prima vocale e qual'ora le lettere non bastassero
        //metto una X
        int j=0;
        for(int i = 0; i < cognome.length(); i++){
            if (!gs.controlloConsonanti(cognome.charAt(i))){
                cognomeCF.charAt(j)= String.valueOf(cognome.charAt(i));
                j++;
            }
        }
        if (cognomeCF.length() < 3){
            //aggiungere X in coda finchè non diventa di lungheza 3z
        }

        return cognomeCF;
    }
    public String prendi_nome(Gestione gs){
        int conta = 0;
        String nome = "FRANCESCA";
        String nomeCF=null;
        //String nome = prendo nome da input
        int j = 0;
        for(int i = 0; i < nome.length(); i++){
            if (!gs.controlloConsonanti(nome.charAt(i))){
                nomeCF.charAt(j)= String.valueOf(nome.charAt(i));
                j++;
            }
        }
        if (nomeCF.length() < 3){
            //aggiungere X in coda finchè non diventa di lungheza 3z
        }

        return nomeCF;
    }



    XMLInputFactory xmlif = null;
    XMLStreamReader xmlr = null;
try {
        xmlif = XMLInputFactory.newInstance();
        xmlr = xmlif.createXMLStreamReader(filename, new FileInputStream(filename));
    } catch (Exception e) {
        System.out.println("Errore nell'inizializzazione del reader:");
        System.out.println(e.getMessage());
    }
    while (xmlr.hasNext()) { // continua a leggere finché ha eventi a disposizione
 switch (xmlr.getEventType()) { // switch sul tipo di evento
    case XMLStreamConstants.START_DOCUMENT: // inizio del documento: stampa che inizia il documento
        System.out.println("Start Read Doc " + filename); break;
    case XMLStreamConstants.START_ELEMENT: // inizio di un elemento: stampa il nome del tag e i suoi attributi
        System.out.println("Tag " + xmlr.getLocalName());
        for (int i = 0; i < xmlr.getAttributeCount(); i++)
            System.out.printf(" => attributo %s->%s%n", xmlr.getAttributeLocalName(i), xmlr.getAttributeValue(i));
        break;
    case XMLStreamConstants.END_ELEMENT: // fine di un elemento: stampa il nome del tag chiuso
        System.out.println("END-Tag " + xmlr.getLocalName()); break;
    case XMLStreamConstants.COMMENT:
        System.out.println("// commento " + xmlr.getText()); break; // commento: ne stampa il contenuto
    case XMLStreamConstants.CHARACTERS: // content all’interno di un elemento: stampa il testo
        if (xmlr.getText().trim().length() > 0) // controlla se il testo non contiene solo spazi
        System.out.println("-> " + xmlr.getText());
        break;
    }
 xmlr.next();
}

}
