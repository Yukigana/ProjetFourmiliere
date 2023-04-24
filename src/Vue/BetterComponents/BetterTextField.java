/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package Vue.BetterComponents;

import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
/**
 * Simple Preloader Using the ProgressBar Control
 *
 * @author 06sha
 */
public class BetterTextField extends HBox {
    private Label label;
    private TextField txt;
    
    public BetterTextField(String nom, String value){
        super();
        
        label = new Label(nom + " :");
        txt = new TextField(value);
        this.getChildren().addAll(label, txt);
        
    }
    
    public StringProperty textProperty(){
        return txt.textProperty();
    }
}
