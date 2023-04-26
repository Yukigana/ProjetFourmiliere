/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package Controleur;

import Vue.Loupe;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;




public class ControleurLoupe{
    // Fenêtre de la loupe 
    private Stage stageLoupe;
    
    // Vue de la loupe
    private Loupe vueLoupe;
    
    // Accès contrôleur principal
    private MainControleur mainControleur;
    
    ControleurLoupe(MainControleur c){
        mainControleur = c;
        
        // Création de la fenêtre
        stageLoupe = new Stage();
        stageLoupe.setTitle("Loupe");
        
        vueLoupe = new Loupe();
        
        stageLoupe.setScene(new Scene(vueLoupe, 330, 330));
    }
    
    // Initialise la grille de la loupe à partir des coordonnées (x, y) de la grille principale de la fourmilière
    public void setLoupe(int x, int y){
        
        for(int i = 0; i < 11; i++){
            for(int u = 0; u < 11; u++){
                
                if(x - 5 + i < 0 || y - 5 + u < 0 || x - 5 + i >= mainControleur.getCTRBinding().getTaille() || y - 5 + u >= mainControleur.getCTRBinding().getTaille()){
                    vueLoupe.setRectangleColor(i, u, Color.BLACK);
                }
                
                else vueLoupe.setRectangleColor(i, u, ((Color) mainControleur.getMainVue().getGrid().getRectangle(x - 5 + i, y - 5 + u).getFill()));
            }
        }
    }
    
    protected Stage getStage(){
        return stageLoupe;
    }
}
