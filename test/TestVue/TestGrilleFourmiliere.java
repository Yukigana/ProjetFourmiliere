/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package TestVue;

import Vue.GrilleFourmiliere;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author 06sha
 */
public class TestGrilleFourmiliere extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GrilleFourmiliere g = new GrilleFourmiliere(10, 10);
        
        g.setWallCase(9, 9);
        
        Pane root = new Pane();
        root.getChildren().add(g);
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
