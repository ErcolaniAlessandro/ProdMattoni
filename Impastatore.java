/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit questo template
 */
package com.mycompany.esercmattoni;

/**
 *
 * @author Utente
 */
class Impastatore {

    private int idMescolatore;

    Impastatore(int idThreadProduttore) {
        this.idMescolatore = idThreadProduttore;
    }

    public String mescolaMalta() {
        return "Preparata la malta per 200 mattoni dal mescolatore " + idMescolatore;
    }
}
