/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JTextField;

/**
 *
 * @author mlyra
 */
public class Nollaa implements Komento {
    
    private int edellinen;
    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    
    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        try {
            edellinen = Integer.parseInt(tuloskentta.getText());
        } catch (Exception e) {
        }
        this.sovellus.nollaa();        
        this.tuloskentta.setText("" + this.sovellus.tulos());  
        this.syotekentta.setText("");
    }

    @Override
    public void peru() {
        this.tuloskentta.setText("" + this.edellinen);
        this.syotekentta.setText("");
        sovellus.aseta(edellinen);
    }
    
}
