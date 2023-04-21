/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package Controleur;

import Modele.Fourmiliere;
import Vue.GrilleFourmiliere;
import javafx.application.Preloader;
import javafx.application.Preloader.ProgressNotification;
import javafx.application.Preloader.StateChangeNotification;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Simple Preloader Using the ProgressBar Control
 *
 * @author 06sha
 */
public class ControleurGrille{
    private Fourmiliere fourmiliere;
    private GrilleFourmiliere vueFourmiliere;
    
    ControleurGrille(Fourmiliere f, GrilleFourmiliere vf){
        fourmiliere = f;
        vueFourmiliere = vf;
    }
    
    public void setWall(double x, double y){
        int coordX = (int) x / 11;
        int coordY = (int) y / 11;
         
        boolean b = fourmiliere.getMur(coordX, coordY);
         
        fourmiliere.setMur(coordX, coordY, !b);
        vueFourmiliere.setWallCase(coordX, coordY, !b);
    }
     
    public void setFourmi(double x, double y){
        int coordX = (int) x / 11;
        int coordY = (int) y / 11;
         
        if(fourmiliere.getMur(coordX, coordY)){
             
        }
    }
}
