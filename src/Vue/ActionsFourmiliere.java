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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Simple Preloader Using the ProgressBar Control
 *
 * @author 06sha
 */
public class ActionsFourmiliere extends HBox {
    private Button loupe;
    private Button play;
    private Button pause;
    
    ActionsFourmiliere(){
        super();
        
        loupe = new Button("Loupe");
        play = new Button("Play");
        pause = new Button("Pause");
        
        this.getChildren().addAll(loupe, play, pause);
    }
    
    
}
