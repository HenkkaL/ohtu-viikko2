/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

/**
 *
 * @author mlyra
 */
public abstract class KonePelaa implements Pelityyppi {

    private IO io;

    @Override
    public String annaSiirto() {
        String siirto = koneSiirto();
        System.out.println("Tietokone valitsi: " + siirto);
        return siirto;
    }

    @Override
    public void asetaSiirto(String siirto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    protected abstract String koneSiirto();

}
