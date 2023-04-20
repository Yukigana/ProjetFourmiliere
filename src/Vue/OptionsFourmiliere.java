/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package Vue;

import javafx.application.Preloader;
import javafx.application.Preloader.ProgressNotification;
import javafx.application.Preloader.StateChangeNotification;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Simple Preloader Using the ProgressBar Control
 *
 * @author 06sha
 */
public class OptionsFourmiliere extends VBox {
    
    private Button Loupe;
    private Button Play;
    private Button Pause;
    
    private Label nbSeeds;
    private Label nbFourmi;
    private Label nbIteration;
    
    
    public OptionsFourmiliere(){
        super();
        
        Insets cellPadding = new Insets(1);
        this.Loupe = new Button("Loupe");
        this.Play = new Button("Play");
        this.Pause = new Button("Pause");
        int nb = 0;
        this.nbSeeds = new Label(String.valueOf(nb));
        this.nbFourmi = new Label(String.valueOf(nb));
        this.nbIteration = new Label(String.valueOf(nb));
        
        this.setMargin(this.Loupe, cellPadding);
        this.setMargin(this.Play, cellPadding);
        this.setMargin(this.Pause, cellPadding);
        this.setMargin(this.nbSeeds, cellPadding);
        this.setMargin(this.nbFourmi, cellPadding);
        this.setMargin(this.nbIteration, cellPadding);
        
        this.getChildren().addAll(Loupe, Play, Pause, nbSeeds, nbFourmi, nbIteration);
    }
    
}
