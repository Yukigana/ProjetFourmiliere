/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package Controleur;


import javafx.concurrent.Service;

import javafx.concurrent.Task;
import javafx.util.Duration;
import javafx.concurrent.ScheduledService;




public class ControleurThread {
    // Différents services (évolution fourmilère, loupe)
    private ScheduledService<Void> service;
    private ScheduledService<Void> serviceLoupe;
    
    // Accès contrôleur principal
    private MainControleur mainControleur;
    
    ControleurThread(MainControleur c){
        mainControleur = c;
    }
    
    // Crée un service qui a pour but l'évolution de la fourmilière
    public void createNewService(){
        service = new ScheduledService<Void>(){
            @Override
            protected Task<Void> createTask(){
                return new Task<>(){
                    @Override
                    protected Void call() {
                        mainControleur.getFourmiliere().evolue(); // On fait évoluer la fourmilière
                        return null;
                    }
                    
                    @Override
                    protected void succeeded() {
                        mainControleur.getCTRBinding().updateNbIteration(); // Augmente d'un le compteur d'itérations 
                        mainControleur.getCTRGrid().initVueFourmiliere(); // On met à jour la vue
                    }
                    
                    @Override
                    protected void failed(){
                        mainControleur.getCTRBinding().updateNbIteration(); // Augmente d'un le compteur d'itérations 
                        mainControleur.getCTRGrid().initVueFourmiliere(); // On met à jour la vue
                    }
                };
            }
        };
        // La vitesse représente le nombre d'actions par seconde
        service.setPeriod(Duration.seconds(1. / mainControleur.getCTRBinding().getSpeed().get()));
        service.setRestartOnFailure(true);
    }
    
    // Crée un service qui a pour but la mise à jour de la loupe en fonction de la position de la souris
    public void createNewServiceLoupe(){
        serviceLoupe = new ScheduledService<Void>(){
            @Override
            protected Task<Void> createTask(){
                return new Task<>(){
                    @Override
                    protected Void call() {
                        // On met à jour la loupe à partir des coordonnées de la souris sur la grille principale
                        mainControleur.getCTRLoupe().setLoupe((int) mainControleur.mouseX / 10, (int) mainControleur.mouseY / 10);
                        return null;
                    }
                    
                    @Override
                    protected void succeeded() {
                    }
                };
            }
        };
        // 30 images par seconde
        serviceLoupe.setPeriod(Duration.seconds(0.03));
    }
    
    public Service<Void> getService(){
        return service;
    }
    
    public Service<Void> getServiceLoupe(){
        return serviceLoupe;
    }
}
