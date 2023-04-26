/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package Vue;

import Vue.BetterComponents.BetterLabel;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.beans.property.StringProperty ;




public class StatsFourmiliere extends VBox {
    private BetterLabel nbSeeds;
    private BetterLabel nbFourmi;
    private BetterLabel nbIteration;
    
    public StatsFourmiliere(){
        super();
        this.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        Label titre = new Label("Statistiques :");
        
        this.nbSeeds = new BetterLabel("Nombre de graines", "0");
        this.nbFourmi = new BetterLabel("Nombre de fourmis", "0");
        this.nbIteration = new BetterLabel("Nombre d'itérations", "0");
        
        this.getChildren().addAll(titre, nbSeeds, nbFourmi, nbIteration);
    }
    
    public StringProperty grainesProperty(){
        return nbSeeds.textProperty();
    }
    
    public StringProperty  fourmisProperty(){
        return nbFourmi.textProperty();
    }
    
    public StringProperty iterationsProperty(){
        return nbIteration.textProperty();
    }
}
