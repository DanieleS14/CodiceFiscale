package it.unibs.pga.CodiceFiscale;

public class CodiceFiscale {

    String cognome;
    String nome;
    String anno_nascita;
    char mese_nascita;
    String giorno_nascita;
    String comune_nascita;
    char controllo;

    public CodiceFiscale(String cognome, String nome, String anno_nascita, char mese_nascita, String giorno_nascita, String comune_nascita, char controllo) {
        this.cognome = cognome;
        this.nome = nome;
        this.anno_nascita = anno_nascita;
        this.mese_nascita = mese_nascita;
        this.giorno_nascita = giorno_nascita;
        this.comune_nascita = comune_nascita;
        this.controllo = controllo;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getAnno_nascita() {
        return anno_nascita;
    }

    public char getMese_nascita() {
        return mese_nascita;
    }

    public String getGiorno_nascita() {
        return giorno_nascita;
    }

    public String getComune_nascita() {
        return comune_nascita;
    }

    public char getControllo() {
        return controllo;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnno_nascita(String anno_nascita) {
        this.anno_nascita = anno_nascita;
    }

    public void setMese_nascita(char mese_nascita) {
        this.mese_nascita = mese_nascita;
    }

    public void setGiorno_nascita(String giorno_nascita) {
        this.giorno_nascita = giorno_nascita;
    }

    public void setComune_nascita(String comune_nascita) {
        this.comune_nascita = comune_nascita;
    }

    public void setControllo(char controllo) {
        this.controllo = controllo;
    }

    /*

     */

    /**
     * CATTI fa il metodo per vedere se un codice è valido
     * ciclo for che mi cicla su tutto il codice. poi verrà in soccorso ALFIERE per la data del giorno di nascita
     * ...
     */

}
