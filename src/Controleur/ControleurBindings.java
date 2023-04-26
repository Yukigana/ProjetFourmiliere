/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package Controleur;

import Vue.StatsFourmiliere;
import Vue.ParametreFourmiliere;
import Vue.InitAlea;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.binding.Bindings;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;




public class ControleurBindings {
    // Info partie stats
    private IntegerProperty nbGrainesCase;
    private IntegerProperty nbFourmi;
    private IntegerProperty nbIteration;
    
    // Info partie paramètres
    private IntegerProperty tailleFourmiliere;
    private IntegerProperty capaciteCase;
    private IntegerProperty vitesseSimu;
    // Info partie probabilités 
    private IntegerProperty probaGraine;
    private IntegerProperty probaFourmi;
    private IntegerProperty probaMur;
    
    // Accès contrôleur principal
    private MainControleur mainControleur;
    
    ControleurBindings(MainControleur c){
        mainControleur = c;
        
        // initialisation des différents property avec leurs valeurs de base
        nbGrainesCase= new SimpleIntegerProperty(0);
        nbFourmi= new SimpleIntegerProperty(0);
        nbIteration= new SimpleIntegerProperty(0);
        
        tailleFourmiliere= new SimpleIntegerProperty(20);
        capaciteCase= new SimpleIntegerProperty(10);
        vitesseSimu= new SimpleIntegerProperty(1);
        probaGraine= new SimpleIntegerProperty(50);
        probaFourmi= new SimpleIntegerProperty(20);
        probaMur= new SimpleIntegerProperty(30);
    }
    
    // ensemble de méthodes qui ont pour but d'être appelées pour mettre à jour les différents affichages grâce aux bindings 
    public void updateNbGraine(int v){
        nbGrainesCase.set(v);
    }
    
    public void updateNbFourmi(int v){
        nbFourmi.set(v);
    }
    
    public void updateNbIteration(){
        nbIteration.set(nbIteration.get()+1);
    }
    
    
    // appelé une seule fois pour relier les différents composants entre eux 
    public void initBindings(){
        StatsFourmiliere statsFourmiliere = mainControleur.getMainVue().getStats();
        ParametreFourmiliere parametreFourmiliere = mainControleur.getMainVue().getParametre();
        InitAlea parametreAleaFourmiliere = parametreFourmiliere.getAlea();
        
        StringConverter<Number> converter = new NumberStringConverter();
        Bindings.bindBidirectional(statsFourmiliere.grainesProperty(), nbGrainesCase, converter);
        Bindings.bindBidirectional(statsFourmiliere.fourmisProperty(), nbFourmi, converter);
        Bindings.bindBidirectional(statsFourmiliere.iterationsProperty(), nbIteration, converter);
        
        Bindings.bindBidirectional(parametreFourmiliere.sizeProperty(), tailleFourmiliere, converter);
        Bindings.bindBidirectional(parametreFourmiliere.capacityProperty(), capaciteCase, converter);
        Bindings.bindBidirectional(parametreFourmiliere.speedProperty(), vitesseSimu);
        
        Bindings.bindBidirectional(parametreAleaFourmiliere.graineProperty(), probaGraine, converter);
        Bindings.bindBidirectional(parametreAleaFourmiliere.fourmiProperty(), probaFourmi, converter);
        Bindings.bindBidirectional(parametreAleaFourmiliere.murProperty(), probaMur, converter);
    }
    /*
        différents Get dont on peut avoir besoin 
    */
    protected IntegerProperty getIteration(){
        return nbIteration;
    }
    
    protected int getTaille(){
        return tailleFourmiliere.get();
    }
    
    protected int getCapacite(){
        return capaciteCase.get();
    }
    
    protected int getProbaGraine(){
        return probaGraine.get();
    }
    
    protected int getProbaFourmi(){
        return probaFourmi.get();
    }
    
    protected int getProbaMur(){
        return probaMur.get();
    }
    
    protected IntegerProperty getSpeed(){
        return vitesseSimu;
    }
    
}
