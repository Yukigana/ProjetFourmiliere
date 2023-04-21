/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package Vue;

import Controleur.ControleurGrille;
import javafx.application.Preloader;
import javafx.application.Preloader.ProgressNotification;
import javafx.application.Preloader.StateChangeNotification;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;

/**
 * Simple Preloader Using the ProgressBar Control
 *
 * @author 06sha
 */
public class GrilleFourmiliere extends GridPane {
    Rectangle[][] grid;
    
    private ControleurGrille c;
    
    public GrilleFourmiliere(int x, int y, ControleurGrille cg){
        super();
        
        c = cg;
        
        Insets cellPadding = new Insets(1);
        this.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        this.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(5), Insets.EMPTY)));
        this.grid = new Rectangle[x][y];
        for(int i = 0; i < x; i++){
            for(int u = 0; u < y; u++){
                this.grid[i][u] = new Rectangle(0, 0, 10, 10);
                this.grid[i][u].setFill(Color.WHITE);
                this.setMargin(this.grid[i][u], cellPadding);
                this.add(this.grid[i][u], i, u);
            }
        }
        
        this.setOnMouseClicked(event -> {
            if(event.isShiftDown()){
                c.setFourmi(event.getX(), event.getY());
            }
            else c.setWall(event.getX(), event.getY());
        });
        
    }
    
    public void setFourmiCase(int x, int y, boolean seed){
        if(seed)grid[x][y].setFill(Color.GREEN);
        else grid[x][y].setFill(Color.BLUE);
    }
    
    public void setWallCase(int x, int y, boolean yes){
        if(yes)grid[x][y].setFill(Color.BLACK);
        else grid[x][y].setFill(Color.WHITE);
    }
    
    public void setSeedCase(int x, int y, int redValue){
        grid[x][y].setFill(Color.rgb(redValue, 0, 0));
    }
    
}
