package it.unibs.pga.CodiceFiscale;

import javax.xml.stream.XMLStreamException;

public class Main {
    public static void main(String[] args) throws XMLStreamException {

        GeneratoreCodiceFiscale gf = new GeneratoreCodiceFiscale();
        gf.leggiInput();
    }
}
