/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.esercmattoni;
/**
 *
 * @author Utente
 */
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe che rappresenta un produttore di mattoni in un processo multithreading.
 */
public class ProduttoreMattoni implements Runnable {

    private int idThreadProduttore;
    private ArrayList<Mattone> blocchiStampati;
    private Forno forno;
    private StringBuilder logProduzione;

    public ProduttoreMattoni(int idProduttore, Forno forno, StringBuilder registroLog) {
        this.idThreadProduttore = idProduttore;
        this.forno = forno;
        this.logProduzione = registroLog;
    }

    @Override
    public void run() {
        try {
            String risultato;
            Impastatore mescolatore = new Impastatore(idThreadProduttore);
            risultato = mescolatore.mescolaMalta();
            System.out.println(risultato);
            logProduzione.append(risultato).append(System.lineSeparator());

            StampatoreRullo stampatore = new StampatoreRullo(idThreadProduttore);
            risultato = stampatore.stampaBlocchi();
            System.out.println(risultato);
            logProduzione.append(risultato).append(System.lineSeparator());

            blocchiStampati = stampatore.trasportaBlocchi();
            risultato = forno.aggiungiMattoni(blocchiStampati, idThreadProduttore);
            logProduzione.append(risultato).append(System.lineSeparator());

            risultato = forno.avviaCottura();
            logProduzione.append(risultato).append(System.lineSeparator());
        } catch (InterruptedException e) {
            Logger.getLogger(FabbricatoreBlocchi.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public ArrayList<Mattone> getListaBlocchi() {
        return blocchiStampati;
    }
}
