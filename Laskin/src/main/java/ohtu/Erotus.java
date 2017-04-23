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
public class Erotus implements Komento {
    
    private int luku;
    private int edellinen;
    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    
    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        
    }

    @Override
    public void suorita() {
        luku = 0;
        try {
            luku = Integer.parseInt(syotekentta.getText());
            edellinen = Integer.parseInt(tuloskentta.getText());
        } catch (Exception e) {
        }
        this.sovellus.miinus(this.luku);
        this.luku = sovellus.tulos();
        this.syotekentta.setText("");
        this.tuloskentta.setText("" + luku);
        
    }

    @Override
    public void peru() {
        this.tuloskentta.setText("" + this.edellinen);
        this.syotekentta.setText("");
        sovellus.aseta(edellinen);
    }
}
