package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Komento {

    protected Sovelluslogiikka sovellus;
    protected TextField tuloskentta;
    protected TextField syotekentta;
    protected Button nollaa;
    protected Button undo;
    protected int edellinenTulos;
    
    public Komento(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa= nollaa;
        this.undo=undo;
    }

    public abstract void suorita();

    public void update() {
        
        try {
            this.edellinenTulos = Integer.parseInt(tuloskentta.getText());
        } catch (Exception e) {
        }
        
        int laskunTulos = sovellus.tulos();
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
        
        

        if (laskunTulos == 0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);

    }

    void peru() {


        sovellus.plus(edellinenTulos-sovellus.tulos());
        update();
        
        
    }
    

}
