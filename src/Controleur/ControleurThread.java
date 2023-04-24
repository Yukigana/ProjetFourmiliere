/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package Controleur;


import javafx.concurrent.Service;

import javafx.concurrent.Task;
import javafx.util.Duration;
import javafx.concurrent.ScheduledService;

/**
 * Simple Preloader Using the ProgressBar Control
 *
 * @author 06sha
 */
public class ControleurThread {
    
    private ScheduledService<Void> service;
    
    private MainControleur mainControleur;
    
    ControleurThread(MainControleur c){
        mainControleur = c;
        
        
    }
    
    public void createNewService(){
        service = new ScheduledService<Void>(){
            @Override
            protected Task<Void> createTask(){
                return new Task<>(){
                    @Override
                    protected Void call() {
                        mainControleur.getFourmiliere().evolue();
                        return null;
                    }
                    
                    @Override
                    protected void succeeded() {
                        mainControleur.getCTRBinding().updateNbIteration();
                        mainControleur.getCTRGrid().initVueFourmiliere();
                    }
                            
                    @Override
                    protected void failed() {
                        mainControleur.getMainVue().getActions().getPlay().setDisable(false);
                    }
                };
            }
        };
        service.setPeriod(Duration.seconds(1 / (double)mainControleur.getCTRBinding().getSpeed()));
    }
    
    public Service<Void> getService(){
        return service;
    }
}
