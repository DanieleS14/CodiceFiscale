package it.unibs.pga.CodiceFiscale;

public class CodiceFiscale {

    private String codice_fiscale;

    public CodiceFiscale(String codice_fiscale) {
        this.codice_fiscale = codice_fiscale;
    }

    public String getCodice_fiscale() {
        return codice_fiscale;
    }

    public void setCodice_fiscale(String codice_fiscale) {
        this.codice_fiscale = codice_fiscale;
    }


    /*
     * CATTI fa il metodo per vedere se un codice è valido
     * ciclo for che mi cicla su tutto il codice. poi verrà in soccorso ALFIERE per la data del giorno di nascita
     * ...
     */

    /**
     * i commenti vanno decommentati
     * i break e i valido = false vanno tolti
     *
     *chiedere per un ulteriore controllo dei comuni, se anche è solo un controllo assoluto del codice, voglio chiedere se
     * i comuni possibili devono esssere presi dalla lista oppure basta che ci sia una lettera e 3 numeri al posto
     * corretto
     *
     * chiedere anche se la lettera di controllo, sempre per la validità assoluta del codice fiscale,
     * basta che sia una lettera oppure che sia corretta secondo l'algoritmo che farò domani
     *
     * @param codice_fiscale
     * @return valido
     */
    public boolean codiceValido(String codice_fiscale){ //CTTFNC01D60B157A
        boolean valido = true;
//        boolean valido = false;
        if (codice_fiscale.length() != 16){
            valido = false;
            //return valido;
            System.out.println("non valido");
            return valido;
        }
        for (int i = 0; i < 16; i++){
            if(i < 6){
                if(codice_fiscale.charAt(i) < 'A' || codice_fiscale.charAt(i) > 'Z'){
                    valido = false;
                    //return valido;
                    break;
                }
            }else if(i >= 6 && i < 8){
                if(codice_fiscale.charAt(i) < '0' || codice_fiscale.charAt(i) >'9'){
                    valido = false;
                    //return valido;
                    break;
                }
            }else if(!controlloMese(codice_fiscale.charAt(8))){  //controlla
                valido = false;
                //return valido;
                break;
            }else if(i == 9){//fatto
                //boolean possibile= true;
                i += 1;
                if(!controlloGiornoNascita(codice_fiscale)){
                    valido = false;
                    //return valido;
                    break;
                }
            }else if(i == 11){
                if(codice_fiscale.charAt(i) < 'A' || codice_fiscale.charAt(i) > 'Z'){
                    valido = false;
                    //return valido;
                    break;
                }
            }else if(i >= 12 && i < 15){
                if(codice_fiscale.charAt(i) < '0' || codice_fiscale.charAt(i) >'9'){
                    valido = false;
                    //return valido;
                    break;
                }
            }else if(i == 15){
                if(codice_fiscale.charAt(i) < 'A' || codice_fiscale.charAt(i) > 'Z'){
                    valido = false;
                    //return valido;
                    break;
                }
            }
        }
        //valido = true;
        if(valido){
            System.out.println("codice valido");
        }else{
            System.out.println("Codice non valido");
        }
        return valido;
    }

    /**
     * controlla che il giorno esista e controlla
     * che appartenga al mese indicato in precendeza
     *
     * @author Catti+Alf
     *
     * @param codice_fiscale
     * @return valido
     */
    private boolean controlloGiornoNascita(String codice_fiscale) {
        String giorno = String.valueOf(codice_fiscale.charAt(9)) + String.valueOf(codice_fiscale.charAt(10));
        Integer gg= Integer.valueOf(giorno);
        boolean valido = false;
        if(codice_fiscale.charAt(8) == 'B'){
            if(gg >= 1 && gg <= 28 || gg >= 41 && gg <= 68){
                valido = true;
            }
        }else if(codice_fiscale.charAt(8) == 'D'||codice_fiscale.charAt(8) == 'P'||
                codice_fiscale.charAt(8) == 'H' ||codice_fiscale.charAt(8) == 'S'){
            if(gg >= 1 && gg <= 30 || gg >= 41 && gg <= 70){
                valido = true;
            }
        }else{
            if(gg >= 1 && gg <= 31 || gg >= 41 && gg <= 71){
                valido = true;
            }
        }
        return valido;
    }

    public boolean controlloMese(char lettera){
        boolean valido = true;
        if(lettera == 'A' || lettera == 'B' || lettera == 'C' || lettera == 'D'
            || lettera == 'E' || lettera == 'H' || lettera == 'L' || lettera == 'M'
            || lettera == 'P' || lettera == 'R' || lettera =='S' || lettera == 'T'){
            return valido;
        }else{
            valido = false;
            return valido;
        }
    }

}
