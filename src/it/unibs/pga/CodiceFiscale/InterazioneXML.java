package it.unibs.pga.CodiceFiscale;

import javax.xml.stream.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamException;

public class InterazioneXML {


    public void ScritturaXML(int num_pers) {

        XMLOutputFactory xmlof = null;
        XMLStreamWriter xmlw = null;
        try {
            xmlof = XMLOutputFactory.newInstance();
            xmlw = xmlof.createXMLStreamWriter(new FileOutputStream("outputPersone.xml"), "utf-8");
            xmlw.writeStartDocument("utf-8", "1.0");
        } catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del writer:");
            System.out.println(e.getMessage());
        }


        try { // blocco try per raccogliere eccezioni

            xmlw.writeStartElement("output");

            xmlw.writeStartElement("persone");
            xmlw.writeAttribute("numero", Integer.toString(num_pers));
            for (int i = 0; i< num_pers; i++){

            }
            xmlw.writeEndElement();
            xmlw.writeEndDocument();

        } catch (Exception e) { // se c’è un errore viene eseguita questa parte
            System.out.println("Errore nella scrittura");
        }


    }

















    public void leggiCodiceXML() throws XMLStreamException {

        String carattere_necessario= null;
        boolean trovato = false;
        int corretti = 0;
        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr = null;
        try {
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader("codiciFiscali.xml", new FileInputStream("codiciFiscali.xml"));
        } catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del reader:");
            System.out.println(e.getMessage());
        }
        while (xmlr.hasNext() && !trovato){

            if (xmlr.getEventType()==XMLStreamConstants.START_ELEMENT && xmlr.getLocalName().equals("codice")) {//START_ELEMENT dà come risultato un intero
                xmlr.next();
                if(xmlr.getText().trim().length() > 0){
                    CodiceFiscale cf = new CodiceFiscale(xmlr.getText());
                    if(cf.codiceValido(cf.getCodice_fiscale())){
                        corretti++;
                    }
                }


            }
            xmlr.next();
        }
        System.out.println(corretti);
        //return carattere_necessario;
    }


    public boolean controllaCodiciFiscaliXML(String stringa_da_trovare) throws XMLStreamException{
        boolean spaiato = true;
        String esistenza = null;
        boolean trovato = false;

        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr = null;
        try {
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader("codiciFiscali.xml", new FileInputStream("codiciFiscali.xml"));
        } catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del reader:");
            System.out.println(e.getMessage());
        }

        while (xmlr.hasNext() && !trovato){
            if (xmlr.getEventType()==XMLStreamConstants.CHARACTERS && xmlr.getText().equals(stringa_da_trovare)) {
                esistenza = xmlr.getText();
                spaiato = false;
                trovato = true;

                break;
            }
            xmlr.next();
        }
        if(trovato == false) {
            System.out.println("ASSENTE");

        }else{
            System.out.println(esistenza);
        }
        return spaiato;
    }


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
}