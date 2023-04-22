/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package Controleur;

import Modele.Fourmiliere;
import Vue.StatsFourmiliere;
import javafx.application.Preloader;
import javafx.application.Preloader.ProgressNotification;
import javafx.application.Preloader.StateChangeNotification;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.binding.Bindings;
import java.text.NumberFormat;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

/**
 * Simple Preloader Using the ProgressBar Control
 *
 * @author 06sha
 */
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
    
    private Fourmiliere fourmiliere;
    private StatsFourmiliere statsFourmiliere;
    
    ControleurBindings(Fourmiliere f){
        fourmiliere = f;
        nbGrainesCase= new SimpleIntegerProperty(0);
        nbFourmi= new SimpleIntegerProperty(0);
        nbIteration= new SimpleIntegerProperty(0);
        
        tailleFourmiliere= new SimpleIntegerProperty(0);
        capaciteCase= new SimpleIntegerProperty(0);
        vitesseSimu= new SimpleIntegerProperty(0);
        probaGraine= new SimpleIntegerProperty(0);
        probaFourmi= new SimpleIntegerProperty(0);
        probaMur= new SimpleIntegerProperty(0);
    }
    
    // ensemble de méthodes qui ont pour but d'être appelées pour mettre à jour les différents affichages grâce aux bindings 
    public void updateNbGraine(int v){
        nbGrainesCase.set(v);
    }
    
    public void updateNbFourmi(int v){
        nbFourmi.set(v);
    }
    
    public void updateNbIteration(int v){
        nbIteration.set(v);
    }
    
    public void setStatsFourmiliere(StatsFourmiliere vueF){
        statsFourmiliere = vueF;
    }
    
    
    // appelé une seule fois pour relier les différents composants entre eux 
    public void initBindings(){
        StringConverter<Number> converter = new NumberStringConverter();
        Bindings.bindBidirectional(statsFourmiliere.grainesProperty(), nbGrainesCase, converter);
        Bindings.bindBidirectional(statsFourmiliere.fourmisProperty(), nbFourmi, converter);
        Bindings.bindBidirectional(statsFourmiliere.iterationsProperty(), nbIteration, converter);
    }
}
