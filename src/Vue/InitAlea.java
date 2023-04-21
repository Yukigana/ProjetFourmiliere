/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package Vue;

import Vue.BetterComponents.BetterTextField;
import javafx.application.Preloader;
import javafx.application.Preloader.ProgressNotification;
import javafx.application.Preloader.StateChangeNotification;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.beans.property.Property;
import javafx.geometry.Insets;

/**
 * Simple Preloader Using the ProgressBar Control
 *
 * @author 06sha
 */
public class InitAlea extends GridPane {
    private BetterTextField graine;
    private BetterTextField fourmi;
    private BetterTextField mur;
    
    InitAlea(){
        super();
        Insets cellPadding = new Insets(10);
        Label titre = new Label("Probabilités");
        
        graine = new BetterTextField("Graine", "0");
        fourmi = new BetterTextField("Fourmi", "0");
        mur = new BetterTextField("Mur", "0");
        
        this.add(titre, 1, 0);
        this.add(graine, 0, 1);
        this.add(fourmi, 1, 1);
        this.add(mur,2, 1);
        
        this.setMargin(fourmi, cellPadding);
        this.setMargin(graine, cellPadding);
        this.setMargin(mur, cellPadding);
    }
    
    public Property graineProperty(){
        return graine.textProperty();
    }
    
    public Property fourmiProperty(){
        return fourmi.textProperty();
    }
    
    public Property murProperty(){
        return mur.textProperty();
    }
    
}
