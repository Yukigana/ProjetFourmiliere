/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package Vue;

import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;




public class GrilleFourmiliere extends GridPane {
    // Grille de rectangle qui représentera la fourmilière
    Rectangle[][] grid;
    
    public GrilleFourmiliere(int x, int y, int sizeCase){
        super();
        
        // Initialisation de la grille uniquement en blanc (car au début il n'existe rien)
        this.grid = new Rectangle[x][y];
        for(int i = 0; i < x; i++){
            for(int u = 0; u < y; u++){
                this.grid[i][u] = new Rectangle(0, 0, sizeCase, sizeCase);
                this.grid[i][u].setFill(Color.WHITE);
                this.add(this.grid[i][u], i, u);
            }
        }
    }
    
    /*
        Méthodes permettant la modification de la grille
    */
    // Affiche une fourmi avec ou sans graine
    public void setFourmiCase(int x, int y, boolean seed){
        if(seed)grid[x][y].setFill(Color.GREEN);
        else grid[x][y].setFill(Color.BLUE);
    }
    
    // Affiche un mur
    public void setWallCase(int x, int y, boolean yes){
        if(yes)grid[x][y].setFill(Color.BLACK);
        else grid[x][y].setFill(Color.WHITE);
    }
    
    // Affiche une case +/- rouge en fonction de la quantité de graines 
    public void setQteGraines(int x, int y, int value){
        grid[x][y].setFill(Color.rgb(255, value, value));
    }
    
    // Affiche un rectangle à partir d'une couleur
    public void setRectangle(int x, int y, Color c){
        grid[x][y].setFill(c);
    }
    
    
    
    
    // récupère le rectangle de coordonnées (x, y) (a pour but la récupération de la couleur par la loupe)
    public Rectangle getRectangle(int x, int y){
        return grid[x][y];
    }
    
}
