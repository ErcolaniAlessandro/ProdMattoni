/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.esercmattoni;

import java.util.ArrayList;

/**
 *
 * @author Utente
 */
class Forno {

    private static final int CAPACITA_MASSIMA = 400;
    private int mattoniTotali = 0;
    private ArrayList<Mattone> listaMattoniCottura = new ArrayList<>();
    private boolean inCottura = false;

    public synchronized String aggiungiMattoni(ArrayList<Mattone> mattoniDaAggiungere, int idRullo) throws InterruptedException {
        while (inCottura) {
            wait();
        }

        if (listaMattoniCottura.size() <= 200) {
            ArrayList<Mattone> nuovaListaMattoni = new ArrayList<>(listaMattoniCottura);
            nuovaListaMattoni.addAll(mattoniDaAggiungere);
            listaMattoniCottura = nuovaListaMattoni;
        }

        String messaggio = "Rullo " + idRullo + " ha aggiunto 200 mattoni al forno";
        System.out.println(messaggio);
        return messaggio;
    }

    public synchronized String avviaCottura() {
        String messaggio = "";

        if (listaMattoniCottura.size() >= CAPACITA_MASSIMA) {
            inCottura = true;
            messaggio = "Sto cuocendo " + CAPACITA_MASSIMA + " mattoni";
            listaMattoniCottura = new ArrayList<>();
            inCottura = false;
            notifyAll();
        }

        System.out.println(messaggio);
        return messaggio;
    }
}
