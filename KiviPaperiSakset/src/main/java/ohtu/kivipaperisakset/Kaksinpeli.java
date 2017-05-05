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
public class Kaksinpeli implements Pelityyppi {

    IO io;

    public Kaksinpeli(IO io) {
        this.io = io;
    }

    @Override
    public String annaSiirto() {
        System.out.println("Toisen pelaajan siirto: ");
        return io.read();
    }

    @Override
    public void asetaSiirto(String siirto) {
        // ei tehdä mitään
    }

}
