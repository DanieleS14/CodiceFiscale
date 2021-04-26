package it.unibs.pga.CodiceFiscale;

import javax.xml.stream.XMLStreamException;

public class Main {
    public static void main(String[] args) throws XMLStreamException {

        GeneratoreCodiceFiscale gf = new GeneratoreCodiceFiscale();
        String codice_fiscale = "CTTFNC01D70B157L";
        CodiceFiscale cf = new CodiceFiscale(codice_fiscale);
        cf.codiceValido(codice_fiscale);
//        String pp = String.valueOf(parola.charAt(1)) + String.valueOf(parola.charAt(2));
//        int gg= parola.charAt(1)*10+ parola.charAt(2);
//        System.out.println(pp);
//        String numero = "1234";
//        int intero = Integer.parseInt(numero);
    }
}
