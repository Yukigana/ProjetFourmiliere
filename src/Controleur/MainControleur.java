/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package Controleur;

import Vue.InterfaceFourmiliere;
import Modele.Fourmiliere;
import javafx.application.Platform;
import javafx.application.Preloader;
import javafx.application.Preloader.ProgressNotification;
import javafx.application.Preloader.StateChangeNotification;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Simple Preloader Using the ProgressBar Control
 *
 * @author 06sha
 */
public class MainControleur {
    private InterfaceFourmiliere mainVue;
    
    
    private Fourmiliere fourmiliere;
    
    
    private ControleurGrille ctrGrille;
    
    
    private Scene scene;
    
    public MainControleur(){
        mainVue = new InterfaceFourmiliere(20, 20, this);
        
        fourmiliere = new Fourmiliere(20, 20, 10);
        
        ctrGrille = new ControleurGrille(fourmiliere, mainVue.getGrid());
        
        scene = new Scene(mainVue, 1000, 350);
    }
    
    public Scene getScene(){
        return scene;
    }
    
    public void exit(){
        Platform.exit();
    }
    
    public ControleurGrille getCTRGrid(){
        return ctrGrille;
    }
}
