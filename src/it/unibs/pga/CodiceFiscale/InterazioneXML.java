package it.unibs.pga.CodiceFiscale;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;

public class InterazioneXML {


//    public void ScritturaXML() {
//        XMLOutputFactory xmlof = null;
//        XMLStreamWriter xmlw = null;
//        try {
//            xmlof = XMLOutputFactory.newInstance();
//            //non riesco a capire come risolvere il problmea nella riga 16 e 17 nel loro pdf dice che dovrebbe
//            // stampare questo <?xml version="1.0" encoding="UTF-8"?>
//            xmlw = xmlof.createXMLStreamWriter(new FileOutputStream("codiciPersone.xml"), “utf - 8”);
//            xmlw.writeStartDocument(“utf - 8”, “ 1.0”);
//        } catch (Exception e) {
//            System.out.println("Errore nell'inizializzazione del writer:");
//            System.out.println(e.getMessage());
//        }
//
//        //qui bisogna inserire la stringa da fargli scrivere
//        String[] autori = {"Roberto", "Jacopo", "Enrico", "Stefano"}; // esempio di dati da scrivere
//
//        try { // blocco try per raccogliere eccezioni
//
//            xmlw.writeStartElement("programmaArnaldo"); // scrittura del tag radice <programmaArnaldo>
//            xmlw.writeComment("INIZIO LISTA"); // scrittura di un commento
//            for (int i = 0; i < autori.length; i++) {
//                xmlw.writeStartElement("autore"); // scrittura del tag autore...
//                xmlw.writeAttribute("id", Integer.toString(i)); // ...con attributo id...
//                xmlw.writeCharacters(autori[i]); // ...e content dato
//                xmlw.writeEndElement(); // chiusura di </autore>
//            }
//            xmlw.writeEndElement(); // chiusura di </programmaArnaldo>
//            xmlw.writeEndDocument(); // scrittura della fine del documento
//            xmlw.flush(); // svuota il buffer e procede alla scrittura
//            xmlw.close(); // chiusura del documento e delle risorse impiegate
//        } catch (Exception e) { // se c’è un errore viene eseguita questa parte
//            System.out.println("Errore nella scrittura");
//        }
//
//
//    }
}