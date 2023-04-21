/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package TestVue;

import Vue.InterfaceFourmiliere;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author 06sha
 */
public class TestInterfaceFourmiliere extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        InterfaceFourmiliere root = new InterfaceFourmiliere(10, 10);
        
        Scene scene = new Scene(root, 800, 350);
        
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
