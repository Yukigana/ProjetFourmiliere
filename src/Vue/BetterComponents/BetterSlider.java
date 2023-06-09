/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package Vue.BetterComponents;

import javafx.application.Preloader;
import javafx.application.Preloader.ProgressNotification;
import javafx.application.Preloader.StateChangeNotification;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Slider;
import javafx.beans.property.DoubleProperty;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import java.text.NumberFormat;
/**
 * Simple Preloader Using the ProgressBar Control
 *
 * @author 06sha
 */
public class BetterSlider extends HBox {
    private Slider slider;
    public BetterSlider(String sLabel, double min, double max, double valeur){
        super();
        Label l = new Label(sLabel);
        TextField tfValue = new TextField();
        this.slider = new Slider(min, max, valeur);
        this.slider.setSnapToTicks(true); // décale sur la valeur d'un tick
        this.slider.setShowTickMarks(true); // affiche les marques
        this.slider.setShowTickLabels(true); // indique la valeur des grandes marques
        this.slider.setMajorTickUnit(5); // intervalle des grandes marques
        this.slider.setMinorTickCount(4); // nombre de petites marques entre deux grandes
        
        tfValue.textProperty().bindBidirectional(slider.valueProperty(), NumberFormat.getNumberInstance());
        
        
        this.getChildren().addAll(l, tfValue, this.slider);
    }
    
    public double getSliderValue(){
        return this.slider.getValue();
    }
    
    public double getSliderMinValue(){
        return this.slider.getMin();
    }
    
    
    public double getSliderMaxValue(){
        return this.slider.getMax();
    }
    
    public DoubleProperty valueProperty(){
        return slider.valueProperty();
    }
}
