
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javax.swing.Timer;
import java.util.Date;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;
import java.util.TimerTask;
public class EinfacheAufgabeController {

    @FXML
    private Label aufgabentext;

    @FXML
    private TextField antwort;

    private Controller c;

    private String typ = "";

    private Timer timer;
    
    protected TimerTask task;
    /*
     * Setzt den Aufgabentext
     */
    public void neueAufgabe(int zahl1, int zahl2, String s)
    {
        
        typ = s;
        aufgabentext.setText(zahl1 + " " + s + " " + zahl2 + " = ");
        antwort.setText("");
        //timer.schedule( task, 10000, 10000);
    }

    @FXML
    void keyPressed(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER){

        }
    }

    /*
     * Holt die eingegebene Antwort
     */
    public int getAntwort()
    {
        int s = 999999;
        try {
            s = Integer.parseInt(antwort.getText());  
        } catch (Exception e) {

        }

         
        return s;
    }
}
