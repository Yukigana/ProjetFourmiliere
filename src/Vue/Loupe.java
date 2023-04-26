/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package Vue;

import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;




public class Loupe extends BorderPane {
    
    private GrilleFourmiliere grille;
    public Loupe(){
        super();
        
        grille = new GrilleFourmiliere(11, 11, 30);
        this.setCenter(grille);
    }
    
    public GrilleFourmiliere getGrille(){
        return grille;
    }
    
    public void setRectangleColor(int x, int y, Color c){
        grille.setRectangle(x, y, c);
    }
}
