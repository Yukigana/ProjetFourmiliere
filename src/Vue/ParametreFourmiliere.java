/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package Vue;

import Vue.BetterComponents.BetterTextField;
import Vue.BetterComponents.BetterSlider;
import javafx.application.Preloader;
import javafx.application.Preloader.ProgressNotification;
import javafx.application.Preloader.StateChangeNotification;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.beans.property.Property;
import javafx.beans.property.DoubleProperty;
/**
 * Simple Preloader Using the ProgressBar Control
 *
 * @author 06sha
 */
public class ParametreFourmiliere extends VBox {
    private BetterTextField sizeGrid;
    private BetterTextField capaCase;
    private BetterSlider simulSpeed;
    private InitAlea alea;
    
    ParametreFourmiliere(){
        super();
        this.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        Label titre = new Label("Paramètres :");
        
        sizeGrid = new BetterTextField("Taille Fourmiliere", "10");
        capaCase = new BetterTextField("Capacité case", "10");
        simulSpeed = new BetterSlider("Vitesse de simulation", 1, 10, 5);
        
        alea = new InitAlea();
        
        this.getChildren().addAll(titre, sizeGrid, capaCase, simulSpeed, alea);
    }
    
    public Property sizeProperty(){
        return sizeGrid.textProperty();
    }
    
    public Property capacityProperty(){
        return capaCase.textProperty();
    }
    
    public DoubleProperty speedProperty(){
        return simulSpeed.valueProperty();
    }
}