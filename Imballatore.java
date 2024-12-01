/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit questo template
 */
package com.mycompany.esercmattoni;

import java.util.ArrayList;
/**
 *
 * @author Utente
 */
public class Imballatore {

    private ArrayList<Mattone> listaMattoniImballaggio;

    public Imballatore(ArrayList<Mattone> mattoniDaImballare) {
        this.listaMattoniImballaggio = mattoniDaImballare;
    }

    public String confezionaMattoni() {
        for (Mattone mattone : listaMattoniImballaggio) {
            mattone.setLotto("29nov2024");
            System.out.print(mattone.getString() + " ");
        }
        return "Tutti i 1600 mattoni sono stati confezionati e depositati in magazzino.";
    }
}
