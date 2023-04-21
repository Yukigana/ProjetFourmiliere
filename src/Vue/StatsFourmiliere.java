/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package Vue;

import Vue.BetterComponents.BetterLabel;
import javafx.application.Preloader;
import javafx.application.Preloader.ProgressNotification;
import javafx.application.Preloader.StateChangeNotification;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.beans.property.Property;

/**
 * Simple Preloader Using the ProgressBar Control
 *
 * @author 06sha
 */
public class StatsFourmiliere extends VBox {
    private BetterLabel nbSeeds;
    private BetterLabel nbFourmi;
    private BetterLabel nbIteration;
    
    public StatsFourmiliere(){
        super();
        this.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        Label titre = new Label("Statistiques :");
        
        this.nbSeeds = new BetterLabel("Nombre de graines par case", "10");
        this.nbFourmi = new BetterLabel("Nombre de fourmis par case", "10");
        this.nbIteration = new BetterLabel("Nombre d'itérations", "0");
        
        this.getChildren().addAll(titre, nbSeeds, nbFourmi, nbIteration);
    }
    
    public Property seedsProperty(){
        return nbSeeds.textProperty();
    }
    
    public Property fourmisProperty(){
        return nbSeeds.textProperty();
    }
    
    public Property iterationProperty(){
        return nbSeeds.textProperty();
    }
    
    
    
}
