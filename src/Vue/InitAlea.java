/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package Vue;

import Vue.BetterComponents.BetterTextField;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;




public class InitAlea extends GridPane {
    
    private BetterTextField graine;
    private BetterTextField fourmi;
    private BetterTextField mur;
    
    InitAlea(){
        super();
        Insets cellPadding = new Insets(10);
        Label titre = new Label("Probabilités");
        
        graine = new BetterTextField("Graine", "30");
        fourmi = new BetterTextField("Fourmi", "20");
        mur = new BetterTextField("Mur", "50");
        
        this.add(titre, 1, 0);
        this.add(graine, 0, 1);
        this.add(fourmi, 1, 1);
        this.add(mur,2, 1);
        
        this.setMargin(fourmi, cellPadding);
        this.setMargin(graine, cellPadding);
        this.setMargin(mur, cellPadding);
    }
    
    //récupération des différents property
    public StringProperty graineProperty(){
        return graine.textProperty();
    }
    
    public StringProperty fourmiProperty(){
        return fourmi.textProperty();
    }
    
    public StringProperty murProperty(){
        return mur.textProperty();
    }
    
}
