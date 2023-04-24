/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package Controleur;

import Modele.Fourmiliere;
import Vue.GrilleFourmiliere;
import Vue.ParametreFourmiliere;

import java.util.Random;
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
    private MainControleur mainControleur;
    
    ControleurGrille(MainControleur c){
        
        mainControleur = c;
    }
    
    // Crée la fourmiliere de base à partir c'est paramètres indiqués par défaut dans les paramètres
    public void initStartFourmiliere(){
        Fourmiliere fourmiliere = mainControleur.getFourmiliere();
        
        int tailleFourmiliere = mainControleur.getCTRBinding().getTaille();
        int capacite = mainControleur.getCTRBinding().getCapacite();
        
        fourmiliere.resetFourmiliere(tailleFourmiliere, capacite);
        
        mainControleur.getMainVue().setNewGrid(tailleFourmiliere);
        
        
        int probaGraine = mainControleur.getCTRBinding().getProbaGraine();
        int probaFourmi = mainControleur.getCTRBinding().getProbaFourmi();
        int probaMur = mainControleur.getCTRBinding().getProbaMur();
        
        int total = probaGraine + probaFourmi + probaMur + 50;
        
        Random rand = new Random();
        
        int value;
        
        for(int x = 0; x < tailleFourmiliere; x++){
            for(int y = 0; y < tailleFourmiliere; y++){
                value = rand.nextInt(total);
                
                if(value < probaMur) setWall(x, y);
                else if(value < probaMur + probaFourmi) setFourmi(x, y);
                else if(value < probaMur + probaFourmi + probaGraine){
                    setSeedAmount(x, y, rand.nextInt(capacite));
                }
            }
        }
        
    }
    
    // Affiche sur la vue le contenu de la fourmiliere
    public void initVueFourmiliere(){
        Fourmiliere fourmiliere = mainControleur.getFourmiliere();
        GrilleFourmiliere grilleFourmiliere = mainControleur.getMainVue().getGrid();
        
        int XMax, YMax;
        XMax = fourmiliere.getLargeur();
        YMax = fourmiliere.getHauteur();
        
        fourmiliere.setQMax(mainControleur.getCTRBinding().getCapacite());
        
        for(int x = 0; x < XMax; x++){
            for(int y = 0; y < YMax; y++){
                boolean bMur = fourmiliere.getMur(x+1, y+1);
                boolean bFourmi = fourmiliere.contientFourmi(x+1, y+1);
                
                if(bMur) grilleFourmiliere.setWallCase(x, y, bMur);
                else if (bFourmi){
                    mainControleur.getMainVue().getGrid().setFourmiCase(x, y, fourmiliere.fourmiPorte(x+1, y+1));
                }
                else{
                    
                    int QMax = fourmiliere.getQMax();
                    int caseValue = fourmiliere.getQteGraines(x+1, y+1);
                    
                    this.setSeedAmount(x, y, caseValue);
                }
            }
        }
    }
    
    public void addGrainesMolette(double x, double y, double value){
        Fourmiliere fourmiliere = mainControleur.getFourmiliere();
        
        int coordX = (int) x;
        int coordY = (int) y;
        
        int caseValue = fourmiliere.getQteGraines(coordX+1, coordY+1) + (int) value;
        
        setSeedAmount(x, y, caseValue);
    }
    
    public void setWall(int x, int y){
        Fourmiliere fourmiliere = mainControleur.getFourmiliere();
        GrilleFourmiliere grilleFourmiliere = mainControleur.getMainVue().getGrid();
        
        int coordX = (int) x;
        int coordY = (int) y;
         
        boolean b = fourmiliere.getMur(coordX+1, coordY+1);
         
        fourmiliere.setMur(coordX+1, coordY+1, !b);
        grilleFourmiliere.setWallCase(coordX, coordY, !b);
    }
     
    public void setFourmi(double x, double y){
        Fourmiliere fourmiliere = mainControleur.getFourmiliere();
        GrilleFourmiliere grilleFourmiliere = mainControleur.getMainVue().getGrid();
        
        int coordX = (int) x;
        int coordY = (int) y;
        
        fourmiliere.ajouteFourmi(coordX+1, coordY+1);
        
        grilleFourmiliere.setFourmiCase(coordX, coordY, false);
        
        mainControleur.getCTRBinding().updateNbFourmi(fourmiliere.getNbFourmis());
    }
    
    public void setSeedAmount(double x, double y, double value){
        Fourmiliere fourmiliere = mainControleur.getFourmiliere();
        GrilleFourmiliere grilleFourmiliere = mainControleur.getMainVue().getGrid();
        
        int coordX = (int) x;
        int coordY = (int) y;
        
        
        int QMax = fourmiliere.getQMax();
        int caseValue = (int)value;
        
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
        
        mainControleur.getCTRBinding().updateNbGraine(fourmiliere.getNbGraines());
    }
    
}
