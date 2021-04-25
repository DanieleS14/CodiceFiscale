package it.unibs.pga.CodiceFiscale;

public class GeneratoreCodiceFiscale {

    public boolean codiceValido(char codice_fiscale[]){
        boolean valido = false;
        if (codice_fiscale.length != 16){
            return valido;
        }
        for (int i = 0; i < 16; i++){
            if(i < 6){
                if(codice_fiscale[i] < 'A' || codice_fiscale[i] > 'Z'){
                    return valido;
                }
            }else if(i >= 6 && i < 8){
                if(codice_fiscale[i] < '0' || codice_fiscale[i] >'9'){
                    return valido;
                }
            }else if(!codice_fiscale[8].controlloMese()){
                return valido;
            }else if()
        }

        return valido;
    }

    public boolean controlloMese(char lettera){
        boolean valido = true;
        if(lettera /*non appartiene alla classe enum dei mesi*/){
            valido = false;
            return valido;
        }

        return valido;
    }

}
