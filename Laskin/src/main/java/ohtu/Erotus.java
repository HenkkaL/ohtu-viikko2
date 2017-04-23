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
        try {
            this.luku = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        this.sovellus.miinus(this.luku);
        this.luku = sovellus.tulos();
        this.syotekentta.setText("");
        this.tuloskentta.setText("" + luku);
        
    }

    @Override
    public void peru() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
