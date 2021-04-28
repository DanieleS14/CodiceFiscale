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
        if (lettera == 'A' || lettera == 'E' || lettera == 'I' || lettera == 'O' || lettera == 'U' || lettera == ' '){
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

    public int tabellaDispari(char lettera){
        int valore_dispari;
        if(lettera == '0' || lettera == 'A'){
            //valore_lettera = 1;
            return valore_dispari = 1; //fare tanti break con fuori un return o subito tanti return è la stessa cosa
        }else if (lettera == '1' || lettera == 'B'){
            return valore_dispari = 0;
        }else if (lettera == '2' || lettera == 'C'){
            return valore_dispari = 5;
        } else if (lettera == '3' || lettera == 'D') {
            return valore_dispari = 7;
        }else if(lettera == '4' || lettera == 'E'){
            return valore_dispari = 9;
        }else if(lettera == '5' || lettera == 'F'){
            return valore_dispari = 13;
        }else if(lettera == '6' || lettera == 'G'){
            return valore_dispari = 15;
        }else if(lettera == '7' || lettera == 'H'){
            return valore_dispari = 17;
        }else if(lettera == '8' || lettera == 'I'){
            return valore_dispari = 19;
        }else if(lettera == '9' || lettera == 'J'){
            return valore_dispari= 21;
        }else if(lettera == 'K'){
            return valore_dispari = 2;
        }else if(lettera == 'L'){
            return valore_dispari = 4;
        }else if(lettera == 'M'){
            return valore_dispari = 18;
        }else if(lettera == 'N'){
            return valore_dispari = 20;
        }else if(lettera == 'O'){
            return valore_dispari = 11;
        }else if(lettera == 'P'){
            return valore_dispari = 3;
        }else if(lettera == 'Q'){
            return valore_dispari = 6;
        }else if(lettera == 'R'){
            return valore_dispari = 8;
        }else if(lettera == 'S'){
            return valore_dispari = 12;
        }else if(lettera == 'T'){
            return valore_dispari = 14;
        }else if(lettera == 'U'){
            return valore_dispari = 16;
        }else if(lettera == 'V'){
            return valore_dispari = 10;
        }else if(lettera == 'W'){
            return valore_dispari = 22;
        }else if(lettera == 'X'){
            return valore_dispari = 25;
        }else if(lettera == 'Y'){
            return valore_dispari = 24;
        }else{
            return valore_dispari = 23;
        }
    }

    public int tabellaPari(char lettera){
        int valore_pari;
        if(lettera == '0' || lettera == 'A'){
            return valore_pari = 0; //fare tanti break con fuori un return o subito tanti return è la stessa cosa
        }else if (lettera == '1' || lettera == 'B'){
            return valore_pari = 1;
        }else if (lettera == '2' || lettera == 'C'){
            return valore_pari = 2;
        } else if (lettera == '3' || lettera == 'D') {
            return valore_pari = 3;
        }else if(lettera == '4' || lettera == 'E'){
            return valore_pari = 4;
        }else if(lettera == '5' || lettera == 'F'){
            return valore_pari = 5;
        }else if(lettera == '6' || lettera == 'G'){
            return valore_pari = 6;
        }else if(lettera == '7' || lettera == 'H'){
            return valore_pari = 7;
        }else if(lettera == '8' || lettera == 'I'){
            return valore_pari = 8;
        }else if(lettera == '9' || lettera == 'J'){
            return valore_pari= 9;
        }else if(lettera == 'K'){
            return valore_pari = 10;
        }else if(lettera == 'L'){
            return valore_pari = 11;
        }else if(lettera == 'M'){
            return valore_pari = 12;
        }else if(lettera == 'N'){
            return valore_pari = 13;
        }else if(lettera == 'O'){
            return valore_pari = 14;
        }else if(lettera == 'P'){
            return valore_pari = 15;
        }else if(lettera == 'Q'){
            return valore_pari = 16;
        }else if(lettera == 'R'){
            return valore_pari = 17;
        }else if(lettera == 'S'){
            return valore_pari = 18;
        }else if(lettera == 'T'){
            return valore_pari = 19;
        }else if(lettera == 'U'){
            return valore_pari = 20;
        }else if(lettera == 'V'){
            return valore_pari = 21;
        }else if(lettera == 'W'){
            return valore_pari = 22;
        }else if(lettera == 'X'){
            return valore_pari = 23;
        }else if(lettera == 'Y'){
            return valore_pari = 24;
        }else{
            return valore_pari = 25;
        }
    }

    public char tabellaConversione(int valore){
        char caratterino;
        if(valore == 0){
            return caratterino = 'A';
        }else if(valore == 1){
            return caratterino = 'B';
        }else if(valore == 2){
            return caratterino = 'C';
        }else if(valore == 3){
            return caratterino = 'D';
        }else if(valore == 4){
            return caratterino = 'E';
        }else if(valore == 5){
            return caratterino = 'F';
        }else if(valore == 6){
            return caratterino = 'G';
        }else if(valore == 7){
            return caratterino = 'H';
        }else if(valore == 8){
            return caratterino = 'I';
        }else if(valore == 9){
            return caratterino = 'J';
        }else if(valore == 10){
            return caratterino = 'K';
        }else if(valore == 11){
            return caratterino = 'L';
        }else if(valore == 12){
            return caratterino = 'M';
        }else if(valore == 13){
            return caratterino = 'N';
        }else if(valore == 14){
            return caratterino = 'O';
        }else if(valore == 15){
            return caratterino = 'P';
        }else if(valore == 16) {
            return caratterino = 'Q';
        }else if(valore == 17){
            return caratterino = 'R';
        }else if(valore == 18){
            return caratterino = 'S';
        }else if(valore == 19){
            return caratterino = 'T';
        }else if(valore == 20){
            return caratterino = 'U';
        }else if(valore == 21){
            return caratterino = 'V';
        }else if(valore == 22){
            return caratterino = 'W';
        }else if(valore == 23){
            return caratterino = 'X';
        }else if(valore == 24){
            return caratterino = 'Y';
        }else{
            return caratterino = 'Z';
        }
    }

    public char conversioneMese(int numero_mese){
        char mese;
        if(numero_mese == 1){
            return mese = 'A';
        }else if(numero_mese == 2){
            return mese = 'B';
        }else if(numero_mese == 3){
            return mese = 'C';
        }else if(numero_mese == 4){
            return mese = 'D';
        }else if(numero_mese == 5){
            return mese = 'E';
        }else if(numero_mese == 6){
            return mese = 'H';
        }else if(numero_mese == 7){
            return mese = 'L';
        }else if(numero_mese == 8){
            return mese = 'M';
        }else if(numero_mese == 9){
            return mese = 'P';
        }else if(numero_mese == 10){
            return mese = 'R';
        }else if(numero_mese == 11){
            return mese = 'S';
        }else{
            return mese = 'T';
        }
    }

}
