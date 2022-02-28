/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fges.tp_solid.reigns;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 *
 * @author julie.jacques
 */
public class Question {
    
    // nom du perso qui pose la question
    protected String nomPersonnage;
    protected String question;
    protected String effetGauche;
    protected String effetDroite;
    protected Map<TypeJauge,Integer> effetJaugeGauche;
    protected Map<TypeJauge,Integer> effetJaugeDroite;
    
    public Question(String nomPersonnage, 
                    String question,
                    String effetGauche,
                    String effetDroite){
        this.nomPersonnage = nomPersonnage;
        this.question = question;
        this.effetGauche = effetGauche;
        this.effetDroite = effetDroite;
        this.effetJaugeGauche = new TreeMap<>();
        this.effetJaugeDroite = new TreeMap<>();
    }
    
    public void afficheQuestion(){
        String result = "["+nomPersonnage+"] "
                + question
                + "[G: "+effetGauche
                + ",D: "+effetDroite
                + "]";
        System.out.println(result);
        System.out.println("Effet G:"+afficheEffets(effetJaugeGauche));
        System.out.println("Effet D:"+afficheEffets(effetJaugeDroite));
        System.out.flush();
        
    }
    /**
     * exemple : jauge armée : -5 ; jauge peuple : +5
     * @return 
     */
    private String afficheEffets(Map<TypeJauge,Integer> effets){
        String result = "";
        for(Entry<TypeJauge,Integer> effet : effets.entrySet()){
            result += "; jauge "+effet.getKey().toString()+" : ";
            if(effet.getValue()>0)
                result += "+";
            result += effet.getValue();
        }
        return result.substring(1);
    }
    
    public void appliqueEffetsGauche(Personnage personnage){
        this.appliqueEffets(effetJaugeGauche, personnage);
    }
    
    public void appliqueEffetsDroite(Personnage personnage){
        this.appliqueEffets(effetJaugeDroite, personnage);
    }
    
    private void appliqueEffets(Map<TypeJauge,Integer> effets, 
                                Personnage personnage){
        for(Entry<TypeJauge,Integer> effet : effets.entrySet()){
            switch(effet.getKey()){
                    case ARMEE:
                        personnage.getJaugeArmee().setValeur(
                                personnage.getJaugeArmee().getValeur()
                                        +effet.getValue());
                        break;
                    case CLERGE:
                        personnage.getJaugeClerge().setValeur(
                                personnage.getJaugeClerge().getValeur()
                                        +effet.getValue());
                        break;
                    case FINANCE:
                        personnage.getJaugeFinance().setValeur(
                                personnage.getJaugeFinance().getValeur()
                                        +effet.getValue());
                        break;
                    case PEUPLE:
                        personnage.getJaugePeuple().setValeur(
                                personnage.getJaugePeuple().getValeur()
                                        +effet.getValue());
                        break;
            }
        }
    }
    
    public void ajouteEffetGauche(TypeJauge jauge,
                                   int valeur){
        effetJaugeGauche.put(jauge,valeur);
    }
    
    public void ajouteEffetDroite(TypeJauge jauge,
                                   int valeur){
        effetJaugeDroite.put(jauge,valeur);
    }

    public String getNomPersonnage() {
        return nomPersonnage;
    }

    public void setNomPersonnage(String nomPersonnage) {
        this.nomPersonnage = nomPersonnage;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getEffetGauche() {
        return effetGauche;
    }

    public void setEffetGauche(String effetGauche) {
        this.effetGauche = effetGauche;
    }

    public String getEffetDroite() {
        return effetDroite;
    }

    public void setEffetDroite(String effetDroite) {
        this.effetDroite = effetDroite;
    }
    
    
}
