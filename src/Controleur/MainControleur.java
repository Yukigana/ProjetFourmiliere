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
import javafx.concurrent.Task;
import javafx.event.Event;
import javafx.event.EventHandler;
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
    private ControleurBindings ctrBinding;
    private ControleurThread ctrThread;
    
    
    private Scene scene;
    
    public MainControleur(){
        // Initialisation de la fourmilière
        fourmiliere = new Fourmiliere(20, 20, 10);
        
        // Initialisation des contrôleurs 
        ctrBinding = new ControleurBindings(this);
        ctrGrille = new ControleurGrille(this);
        ctrThread = new ControleurThread(this);
        
        // Initialisation de vue principale
        mainVue = new InterfaceFourmiliere(20, 20, this);
        
        
        
        ctrBinding.initBindings();
        ctrGrille.initStartFourmiliere();
        
        
        
        // Déclarations boutons 
        mainVue.getExit().setOnMouseClicked(new EventHandler(){
            @Override
            public void handle(Event event) {
                Platform.exit();
            }
        });
        
        mainVue.getParametre().getReset().setOnMouseClicked(new EventHandler(){
            @Override
            public void handle(Event event) {
                ctrGrille.initStartFourmiliere();
            }
        });
        
        mainVue.getActions().getPlay().setOnMouseClicked(new EventHandler(){
            @Override
            public void handle(Event event){
                
            }
        });
        
        mainVue.getActions().getPlay().setOnAction(e -> {
            mainVue.getActions().getPlay().setDisable(true);
            ctrThread.createNewService();
            ctrThread.getService().start();
        });
        
        mainVue.getActions().getPause().setOnAction(e -> {
            mainVue.getActions().getPlay().setDisable(false);
            ctrThread.getService().cancel();
        });
        
        
        scene = new Scene(mainVue, 1000, 350);
    }
    
    
    public Scene getScene(){
        return scene;
    }
    
    public ControleurGrille getCTRGrid(){
        return ctrGrille;
    }
    
    public ControleurBindings getCTRBinding(){
        return ctrBinding;
    }
    
    public Fourmiliere getFourmiliere(){
        return fourmiliere;
    }
    
    public InterfaceFourmiliere getMainVue(){
        return mainVue;
    }
}
