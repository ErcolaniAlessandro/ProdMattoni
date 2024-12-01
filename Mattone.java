/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.esercmattoni;
/**
 *
 * @author Utente
 */

class Mattone {

    private String codice;
    private String numeroLotto;
    private float pesoInKg;

    public Mattone(String identificativo) {
        this.codice = identificativo;
        this.pesoInKg = 0.5f;
    }

    public void assegnaLotto(String lotto) {
        this.numeroLotto = lotto;
    }

    public String descriviBlocco() {
        return "Blocco " + numeroLotto + codice + " Peso: " + pesoInKg + "kg";
    }
}
