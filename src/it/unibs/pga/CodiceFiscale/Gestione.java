package it.unibs.pga.CodiceFiscale;

public class Gestione{

    /**
     * una volta preso in input il nome o cognome per creare il codice fiscale
     * bisogna prendere le prime tre consonati. Quindi dato il nome mi ciclo su di esso
     * e se la lettera presa è una consonante ti ritorna vero quindi poi bisognerà tenerne
     * conto per la formazione del codice fiscale
     * @param lettera
     * @return
     */
    public boolean controlloConsonanti(char lettera){
        boolean corretto = true;
        if (lettera == 'A' || lettera == 'E' || lettera == 'I' || lettera == 'O' || lettera == 'U'){
            corretto = false;
        }
        return corretto;
    }

    public boolean controlloVocali(char lettera){
        boolean corretto = false;
        if (lettera == 'A' || lettera == 'E' || lettera == 'I' || lettera == 'O' || lettera == 'U'){
            corretto = true;
        }
        return corretto;
    }



}
