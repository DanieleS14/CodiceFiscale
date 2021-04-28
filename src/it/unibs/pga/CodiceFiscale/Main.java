package it.unibs.pga.CodiceFiscale;

import javax.xml.stream.XMLStreamException;

public class Main {

    public static final int NUMERO_PERSONE = 3;

    public static void main(String[] args) throws XMLStreamException {


//        GeneratoreCodiceFiscale gf = new GeneratoreCodiceFiscale();
//        String codice = "MSSGPP40D27A177" ;
//        String codice_trasformato = gf.letteraDiControllo(codice);
//        System.out.println(codice_trasformato);

        /**
         * NON TOCCARE
         *
         * -Alfiere
         */
        for (int i = 0; i< NUMERO_PERSONE; i++){
            GeneratoreCodiceFiscale gcf= new GeneratoreCodiceFiscale();
            String cod_prov= gcf.generatore(i);
            System.out.println(cod_prov);
            //CodiceFiscale cf= new CodiceFiscale(cod_prov);
        }



      /* GeneratoreCodiceFiscale gf = new GeneratoreCodiceFiscale();
        String codice_fiscale = "CTTFNC01D70B157L";
        CodiceFiscale cf = new CodiceFiscale(codice_fiscale);
        cf.codiceValido(codice_fiscale);*/
//        String pp = String.valueOf(parola.charAt(1)) + String.valueOf(parola.charAt(2));
//        int gg= parola.charAt(1)*10+ parola.charAt(2);
//        System.out.println(pp);
//        String numero = "1234";
//        int intero = Integer.parseInt(numero);
    }
}
