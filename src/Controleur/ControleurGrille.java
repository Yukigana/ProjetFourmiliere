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
    
    ControleurGrille(Fourmiliere f){//, GrilleFourmiliere vf){
        fourmiliere = f;
        //vueFourmiliere = vf;
    }
    
    public void setWall(double x, double y){
        int coordX = (int) x / 12;
        int coordY = (int) y / 12;
         
        boolean b = fourmiliere.getMur(coordX+1, coordY+1);
         
        fourmiliere.setMur(coordX+1, coordY+1, !b);
        vueFourmiliere.setWallCase(coordX, coordY, !b);
    }
     
    public void setFourmi(double x, double y){
        int coordX = (int) x / 12;
        int coordY = (int) y / 12;
        
        fourmiliere.ajouteFourmi(coordX+1, coordY+1);
        vueFourmiliere.setFourmiCase(coordX, coordY, false);
    }
    
    public void setSeedAmount(double x, double y, double value){
        int coordX = (int) x / 12;
        int coordY = (int) y / 12;
        
        
        int QMax = fourmiliere.getQMax();
        int caseValue = fourmiliere.getQteGraines(coordX+1, coordY+1) + (int) value/20;
        
        if(QMax < caseValue){
            fourmiliere.setQteGraines(coordX+1, coordY+1, QMax);
            vueFourmiliere.setQteGraines(coordX, coordY, 0);
        }
        else if(0 > caseValue){
            fourmiliere.setQteGraines(coordX+1, coordY+1, 0);
            vueFourmiliere.setQteGraines(coordX, coordY, 255);
        }
        else{
            fourmiliere.setQteGraines(coordX+1, coordY+1, caseValue);
            vueFourmiliere.setQteGraines(coordX, coordY, 255-((255/QMax)*caseValue));
        }
    }
    
    public void setVueFourmiliere(GrilleFourmiliere vueF){
        vueFourmiliere = vueF;
    }
}
