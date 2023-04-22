/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package Controleur;

import Modele.Fourmiliere;
import Vue.GrilleFourmiliere;
import Vue.ParametreFourmiliere;
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
    private GrilleFourmiliere grilleFourmiliere;
    private ParametreFourmiliere parametreFourmiliere;
    
    private ControleurBindings ctrBinding;
    
    ControleurGrille(Fourmiliere f){
        fourmiliere = f;
    }
    
    public void initStartFourmiliere(){
        
    }
    
    public void initVueFourmiliere(){
        int XMax, YMax;
        XMax = fourmiliere.getLargeur();
        YMax = fourmiliere.getHauteur();
        for(int x = 0; x < XMax; x++){
            for(int y = 0; y < YMax; y++){
                boolean bMur = fourmiliere.getMur(x+1, y+1);
                boolean bFourmi = fourmiliere.contientFourmi(x+1, y+1);
                if(bMur)grilleFourmiliere.setWallCase(x, y, bMur);
                else{
                    if(bFourmi)grilleFourmiliere.setFourmiCase(x, y, false);
                    
                    int QMax = fourmiliere.getQMax();
                    int caseValue = fourmiliere.getQteGraines(x+1, y+1);
                    
                    grilleFourmiliere.setQteGraines(x, y, 255-((255/QMax)*caseValue));
                }
                
            }
        }
    }
    
    public void setWall(double x, double y){
        int coordX = (int) x / 12;
        int coordY = (int) y / 12;
         
        boolean b = fourmiliere.getMur(coordX+1, coordY+1);
         
        fourmiliere.setMur(coordX+1, coordY+1, !b);
        grilleFourmiliere.setWallCase(coordX, coordY, !b);
    }
     
    public void setFourmi(double x, double y){
        int coordX = (int) x / 12;
        int coordY = (int) y / 12;
        
        fourmiliere.ajouteFourmi(coordX+1, coordY+1);
        grilleFourmiliere.setFourmiCase(coordX, coordY, false);
        
        ctrBinding.updateNbFourmi(fourmiliere.getNbFourmis());
    }
    
    public void setSeedAmount(double x, double y, double value){
        int coordX = (int) x / 12;
        int coordY = (int) y / 12;
        
        
        int QMax = fourmiliere.getQMax();
        int caseValue = fourmiliere.getQteGraines(coordX+1, coordY+1) + (int) value/20;
        
        if(QMax < caseValue){
            fourmiliere.setQteGraines(coordX+1, coordY+1, QMax);
            grilleFourmiliere.setQteGraines(coordX, coordY, 0);
        }
        else if(0 > caseValue){
            fourmiliere.setQteGraines(coordX+1, coordY+1, 0);
            grilleFourmiliere.setQteGraines(coordX, coordY, 255);
        }
        else{
            fourmiliere.setQteGraines(coordX+1, coordY+1, caseValue);
            grilleFourmiliere.setQteGraines(coordX, coordY, 255-((255/QMax)*caseValue));
        }
        
        ctrBinding.updateNbGraine(fourmiliere.getNbGraines());
    }
    
    public void setGrilleFourmiliere(GrilleFourmiliere grilleF){
        grilleFourmiliere = grilleF;
    }
    public void setParametreFourmiliere(ParametreFourmiliere parametreF){
        parametreFourmiliere = parametreF;
    }
    public void setControleurBindings(ControleurBindings ctr){
        ctrBinding = ctr;
    }
}
