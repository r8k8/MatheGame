
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.input.KeyCode;
import java.util.Random;
import java.io.IOException;
import javax.swing.Timer;

import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;
public class Controller
{
    // Anzeige der erreichten Punkte
    @FXML 
    private Label lblPunkte; 

    // Der Button Prüfen oder Weiter
    @FXML
    private Button button;

    // Anzeige der Aufgabe
    @FXML
    private StackPane inhalt;

    @FXML
    private Label timer2;

    // Aufgabe, die gerade angezeigt wird
    private Aufgabe a;
    private Random random;
    // Anzeige, ob die Lösung richtig war
    @FXML
    private Label lblErgebnis;

    // Anzahl der Gesamtpunktzahl
    private int punkte;

    // Zustand
    int zustand; // 0: Aufgabe gestellt / 1: Antwort getippt

    
    //private Timer timer;
    

   
    /*
     * Wenn auf den Button geklickt wurde, wird diese Methode aufgerufen
     * Je nach Zustand wird etwas anderes auf dem Button angezeigt und tut
     * der Button auch etwas anderes
     */

    @FXML
    void buttonGeklickt(ActionEvent event) {
        check();
    }

    public void check(){
        switch (zustand)
        {
            case 0: { // Zustand Aufgabe gestellt

                // Es wird überprüft, ob die richtige Lösung eingegeben wurde

                boolean ergebnis = a.loesungUeberpruefen(a.getTyp());

                if (ergebnis)
                {
                    // Richtig
                    lblErgebnis.setText("Super!");
                    punkte = punkte + a.getPunkte();
                    lblPunkte.setText("" + punkte);

                }
                else
                {
                    // Falsch
                    lblErgebnis.setText("Leider falsch");
                }
                // Der Zustand wird auf Antwort getippt gesetzt
                zustand = 1;
                button.setText("Weiter");

            } break;

            case 1: {  // Zustand Antwort getippt               
                a.neu(); // Eine neue Aufgabe wird angezeigt
                button.setText("Prüfen!"); 
                lblErgebnis.setText("");
                zustand = 0; // Zustand wird wieder auf Aufgabe gestellt gesetzt
            } break;

        }   

        
    }
    @FXML
    void keyPressed(KeyEvent event) {
        System.out.println("abc");
        if (event.getCode() == KeyCode.ENTER){
            check();   
        }
    }

    /*
     * Diese Methode wird aufgerufen, wenn alle Label und Button vom Loader erstellt worden sind
     */

    @FXML 
    void initialize() {      
        // Erstellt eine neue Einfache Aufgabe
        a = new EinfacheAufgabe();
        a.setController(this); 
        // fügt die Darstellung der einfachen Aufgabe in die Oberfläche ein
        inhalt.getChildren().add(a.darstellungErstellen());
        // Punktstand am Anfang ist 0
        punkte = 0;
        // Die Anwendung befindet sich im Zustand Aufgabe gestellt
        zustand = 0;
        lblErgebnis.setText("");
      
    }

    public int getPunkte(){
        return punkte;
    }
}
