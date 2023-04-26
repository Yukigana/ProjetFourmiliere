/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package Vue;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;




public class ActionsFourmiliere extends HBox {
    // Différents boutons
    private Button loupe;
    private Button play;
    private Button pause;
    
    ActionsFourmiliere(){
        super();
        
        loupe = new Button("Loupe");
        play = new Button("Play");
        pause = new Button("Pause");
        
        this.getChildren().addAll(loupe, play, pause);
    }
    
    public Button getLoupe(){
        return loupe;
    }
    
    public Button getPlay(){
        return play;
    }
    
    public Button getPause(){
        return pause;
    }
}
