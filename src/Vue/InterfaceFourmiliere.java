/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package Vue;

import Controleur.MainControleur;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Simple Preloader Using the ProgressBar Control
 *
 * @author 06sha
 */
public class InterfaceFourmiliere extends BorderPane {
    private Button exit;
    private StatsFourmiliere stats;
    private ParametreFourmiliere parametre;
    private ActionsFourmiliere actions;
    private GrilleFourmiliere grille;
    private Pane pane;
    
    private MainControleur mainControleur;
    
    public InterfaceFourmiliere(int x, int y, MainControleur c){
        super();
        
        mainControleur = c;
        
        VBox v = new VBox();
        this.stats = new StatsFourmiliere();
        this.parametre = new ParametreFourmiliere(x);
        this.actions = new ActionsFourmiliere();
        
        v.getChildren().addAll(stats, parametre, actions);
        
        this.grille = new GrilleFourmiliere(x, y, mainControleur.getCTRGrid());
        this.pane = new Pane(grille);
        
        this.setCenter(pane);
        this.setRight(v);
        
        /*
            Button exit
        */
        
        this.exit = new Button("Exit");
        
        super.setBottom(this.exit);
        BorderPane.setAlignment(this.exit, Pos.CENTER_RIGHT);
        
        
        BorderPane.setAlignment(pane, Pos.CENTER_RIGHT);
    }
    
    public void setNewGrid(int taille){
        this.grille = new GrilleFourmiliere(taille, taille, mainControleur.getCTRGrid());
        this.pane = new Pane(grille);
        this.setCenter(pane);
    }
    
    public Button getExit(){
        return exit;
    }
    
    public GrilleFourmiliere getGrid(){
        return grille;
    }
    
    public StatsFourmiliere getStats(){
        return stats;
    }
    
    public ParametreFourmiliere getParametre(){
        return parametre;
    }
    
    public ActionsFourmiliere getActions(){
        return actions;
    }
}
