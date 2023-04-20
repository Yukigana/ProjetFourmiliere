/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package Vue;

import javafx.application.Preloader;
import javafx.application.Preloader.ProgressNotification;
import javafx.application.Preloader.StateChangeNotification;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Simple Preloader Using the ProgressBar Control
 *
 * @author 06sha
 */
public class InitialisationFourmiliere extends BorderPane {
    private BetterTextField sizeGrid;
    private BetterTextField capaCase;
    private SliderBetter simulSpeed;
    
    
    public InitialisationFourmiliere(){
        super();
        
        sizeGrid = new BetterTextField("Taille Fourmiliere");
        capaCase = new BetterTextField("Capacité case");
        simulSpeed = new SliderBetter("Vitesse de simulation", 1, 10, 5);
        
        
        
    }
}
