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
class RulloStampante {
    private int Crullo;
    private ArrayList<Mattone> mattoniStampatiList; 
    private static final int NUM_MATTONI_STAMPATI=200;
    
    public RulloStampante(int codiceThreadProduttore){
        Crullo=codiceThreadProduttore;
        mattoniStampatiList= new ArrayList<>();
    }
    public String StampaMattoni(){
        for(int i=0; i<NUM_MATTONI_STAMPATI; i++){
            Mattone m= new Mattone(String.valueOf(Crullo)+"_"+String.valueOf(i)+"_");
            mattoniStampatiList.add(m);
        }
        return "Prodotti 200 mattoni in uscita dal rullo "+Crullo;
    }
    public ArrayList<Mattone> TrasportaMattoni(){
        return mattoniStampatiList;
    }
}