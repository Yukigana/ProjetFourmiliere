/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package Vue;

import javafx.application.Platform;
import javafx.application.Preloader;
import javafx.application.Preloader.ProgressNotification;
import javafx.application.Preloader.StateChangeNotification;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Simple Preloader Using the ProgressBar Control
 *
 * @author 06sha
 */
public class InterfaceFourmiliere extends BorderPane {
    private Button exit;
    private OptionsFourmiliere options;
    private GrilleFourmiliere grille;
    private Pane pane;
    
    public InterfaceFourmiliere(int x, int y){
        super();
        this.options = new OptionsFourmiliere();
        
        this.grille = new GrilleFourmiliere(x, y);
        this.pane = new Pane(grille);
        
        this.setCenter(pane);
        this.setRight(options);
        
        /*
            Button exit
        */
        
        this.exit = new Button("Exit");
        
        super.setBottom(this.exit);
        BorderPane.setAlignment(this.exit, Pos.CENTER_RIGHT);
        
        this.exit.setOnMouseClicked(new EventHandler(){
            @Override
            public void handle(Event event) {
                Platform.exit();
            }
        });
        
        BorderPane.setAlignment(pane, Pos.CENTER_RIGHT);
    }
}
