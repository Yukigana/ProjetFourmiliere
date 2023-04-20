/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package Vue;

import javafx.application.Preloader;
import javafx.application.Preloader.ProgressNotification;
import javafx.application.Preloader.StateChangeNotification;
import javafx.beans.property.Property;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
/**
 * Simple Preloader Using the ProgressBar Control
 *
 * @author 06sha
 */
public class BetterTextField extends HBox {
    private Label label;
    private TextField txt;
    
    public BetterTextField(String nom){
        super();
        
        label = new Label(nom + " :");
        txt = new TextField("10");
        this.getChildren().addAll(label, txt);
        
    }
    
    public String getValue(){
        return txt.getText();
    }
}
