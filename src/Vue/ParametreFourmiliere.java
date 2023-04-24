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
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.beans.property.Property;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;
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
    private Button reset;
    
    ParametreFourmiliere(int x){
        super();
        this.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        Label titre = new Label("Paramètres :");
        
        sizeGrid = new BetterTextField("Taille Fourmiliere", String.valueOf(x));
        capaCase = new BetterTextField("Capacité case", "10");
        simulSpeed = new BetterSlider("Vitesse de simulation", 1, 60, 5);
        
        alea = new InitAlea();
                
        reset = new Button("reset");
        
        this.getChildren().addAll(titre, sizeGrid, capaCase, simulSpeed, alea, reset);
    }
    
    public StringProperty sizeProperty(){
        return sizeGrid.textProperty();
    }
    
    public StringProperty capacityProperty(){
        return capaCase.textProperty();
    }
    
    public Property speedProperty(){
        return simulSpeed.valueProperty();
    }
    
    public InitAlea getAlea(){
        return alea;
    }
    
    public Button getReset(){
        return reset;
    }
}
