/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package Vue;

import Controleur.MainControleur;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;




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
        
        this.grille = new GrilleFourmiliere(x, y, 10);
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
    
    // Permet le changement de grille
    public void setNewGrid(int taille){
        this.grille = new GrilleFourmiliere(taille, taille, 10);
        this.pane = new Pane(grille);
        this.setCenter(pane);
    }
    
    
    /*
        Différents get permettant aux contrôleurs d'affecter des actions 
    */
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
