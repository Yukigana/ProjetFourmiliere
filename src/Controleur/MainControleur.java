/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package Controleur;

import Vue.InterfaceFourmiliere;
import Modele.Fourmiliere;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;




public class MainControleur {
    // Vue principale
    private InterfaceFourmiliere mainVue;
    
    // Noyau fourmilière
    private Fourmiliere fourmiliere;
    
    // Les différents sous-contrôleur
    private ControleurGrille ctrGrille;
    private ControleurBindings ctrBinding;
    private ControleurThread ctrThread;
    private ControleurLoupe ctrLoupe;
    
    public double mouseX, mouseY; // position de la souris sur la grille de la fourmilière (utilisé uniquement pour la loupe)
    private boolean isRunning; // si la fourmilière est allumée 
    private boolean loupeRunning; // si la loupe est ouverte
    
    private Scene scene;
    
    public MainControleur(){
        // Initialisation de la fourmilière
        fourmiliere = new Fourmiliere(20, 20, 10);
        
        // Initialisation des contrôleurs 
        ctrBinding = new ControleurBindings(this);
        ctrGrille = new ControleurGrille(this);
        ctrThread = new ControleurThread(this);
        ctrLoupe = new ControleurLoupe(this);
        
        // Initialisation de vue principale
        mainVue = new InterfaceFourmiliere(20, 20, this);
        
        // Initialisation variable de base
        isRunning = false;
        loupeRunning = false;
        
        // Initialisation des différents sous-contrôleur
        ctrBinding.initBindings();
        ctrGrille.initStartFourmiliere();
        
        // Déclarations boutons/actions
        // Position de la souris sur la grille de la fourmilière
        mainVue.getGrid().setOnMouseMoved(event -> {
            mouseX = event.getSceneX();
            mouseY = event.getSceneY();
        });
        
        // Ajout fourmi/mur dans la fourmilière
        mainVue.getGrid().setOnMouseClicked(event -> {
            if(!isRunning){
                if(event.isShiftDown()){
                    ctrGrille.setFourmi(event.getX() / 10, event.getY() / 10);
                }
                else ctrGrille.setWall((int)event.getX() / 10, (int)event.getY() / 10);
            }
        });
        
        // Ajout/suppression des graines dans la fourmilière
        mainVue.getGrid().setOnScroll(event -> {
            if(!isRunning){
                ctrGrille.addGrainesMolette(event.getX() / 10, event.getY() / 10, event.getDeltaY()/20);
            }
        });
        
        // Bouton exit
        mainVue.getExit().setOnMouseClicked(new EventHandler(){
            @Override
            public void handle(Event event) {
                Platform.exit();
            }
        });
        
        // Bouton permettant de recharger une nouvelle fourmilère à partir de nouveaux paramètres
        mainVue.getParametre().getReset().setOnMouseClicked(new EventHandler(){
            @Override
            public void handle(Event event) {
                ctrBinding.getIteration().set(0);
                ctrGrille.initStartFourmiliere();
            }
        });
        
        // Lancement de la simulation
        mainVue.getActions().getPlay().setOnAction(e -> {
            isRunning = true;
            mainVue.getActions().getPlay().setDisable(true);
            ctrThread.createNewService();
            ctrThread.getService().start();
        });
        
        // Arrêt de la simulation
        mainVue.getActions().getPause().setOnAction(e -> {
            isRunning = false;
            mainVue.getActions().getPlay().setDisable(false);
            ctrThread.getService().cancel();
        });
        
        // gestion du bouton loupe
        mainVue.getActions().getLoupe().setOnAction(e -> {
            
            // action différente en fonction de si la fenêtre est déjà ouverte ou pas
            /*
                Si la fenêtre n'est pas ouverte on l'ouvre et on lance le thread qui gère la mise à jour de la loupe 
                Sinon on arrête le thread et on ferme la fenêtre
            */
            if(!loupeRunning){
                loupeRunning = true;
                
                ctrThread.createNewServiceLoupe();
                ctrThread.getServiceLoupe().start();
                
                ctrLoupe.getStage().show();
            }
            else{
                loupeRunning = false;
                ctrThread.getServiceLoupe().cancel();
                ctrLoupe.getStage().close();
            }
            
        });
        
        
        scene = new Scene(mainVue, 1000, 350);
    }
    
    
    /*
        Différents get permettant la transmission aux sous-contrôleurs
    */
    public Scene getScene(){ // public pour l'AppFourmilière
        return scene;
    }
    
    protected ControleurGrille getCTRGrid(){
        return ctrGrille;
    }
    
    protected ControleurBindings getCTRBinding(){
        return ctrBinding;
    }
    
    protected ControleurLoupe getCTRLoupe(){
        return ctrLoupe;
    }
    
    protected Fourmiliere getFourmiliere(){
        return fourmiliere;
    }
    
    protected InterfaceFourmiliere getMainVue(){
        return mainVue;
    }
}
