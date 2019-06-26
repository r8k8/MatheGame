import javafx.scene.layout.Pane;
public abstract class Aufgabe
{
    // Attribute
    protected int punkte;   
    protected Controller c;

    // Methoden
    public abstract void richtigeLoesungAnzeigen();

    public abstract boolean loesungUeberpruefen(String typ);

    public abstract Pane darstellungErstellen();
    
    public abstract void neu();
    
    public abstract String getTyp();

    public int getPunkte()
    {
        return punkte;
    }
       public void setController(Controller c_)
    {
        c = c_;
    }

}
