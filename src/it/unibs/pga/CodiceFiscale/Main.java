package it.unibs.pga.CodiceFiscale;

import javax.xml.stream.XMLStreamException;

public class Main {

    public static final int NUMERO_PERSONE = 1000;

    public static void main(String[] args) throws XMLStreamException {
        InterazioneXML interazione = new InterazioneXML();

        interazione.ScritturaXML(1000);
    }
}
