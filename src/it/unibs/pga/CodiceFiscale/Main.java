package it.unibs.pga.CodiceFiscale;

import it.unibs.fp.mylib.InputDati;

import javax.xml.stream.XMLStreamException;

public class Main {

    public static final int NUMERO_PERSONE = 1000;
    public static final String SALUTO = "Salve utente!";


    public static void main(String[] args) throws XMLStreamException {

        System.out.println(SALUTO);

        InterazioneXML interazione = new InterazioneXML();

        interazione.ScritturaXML(1000);
    }
}
