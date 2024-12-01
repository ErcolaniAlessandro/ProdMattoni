/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.esercmattoni;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Utente
 */
public class EsercMattoni {

    public static class Main {
        private static final int NUMERO_MATTONI = 8;

        public static void main(String[] args) {
            ArrayList<Thread> listaThreadProduttori = new ArrayList<>();
            ArrayList<ProduttoreMattoni> listaProduttori = new ArrayList<>();
            StringBuilder contenutoFile = new StringBuilder();
            Forno forno = new Forno();

           
            for (int id = 0; id < NUMERO_MATTONI; id++) {
                ProduttoreMattoni produttore = new ProduttoreMattoni(id, forno, contenutoFile);
                listaProduttori.add(produttore);
                Thread threadProduttore = new Thread(produttore);
                listaThreadProduttori.add(threadProduttore);
                threadProduttore.start();
            }

          
            for (Thread thread : listaThreadProduttori) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    Logger.getLogger(Programma.class.getName()).log(Level.SEVERE, null, e);
                }
            }

            
            ArrayList<Mattone> listaMattoniImballaggio = new ArrayList<>();
            for (ProduttoreMattoni produttore : listaProduttori) {
                listaMattoniImballaggio.addAll(produttore.getListaMattoni());
            }

           
            Imballatore imballatore = new Imballatore(listaMattoniImballaggio);
            contenutoFile.append(imballatore.procediImballaggio());
            contenutoFile.append(System.lineSeparator());

          
            try (PrintWriter scrittoreFile = new PrintWriter("RisultatiProduzione.txt")) {
                scrittoreFile.append(contenutoFile.toString());
            } catch (Exception e) {
                Logger.getLogger(Programma.class.getName()).log(Level.SEVERE, "Errore durante la scrittura del file", e);
            }
        }
    }
}
