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
public class Peli {

    private Pelityyppi peli;
    private IO io;

    public static Peli luoKaksinpeli(IO io) {
        return new Peli(io, new Kaksinpeli(io));
    }

    public static Peli luoTekoalypeli(IO io) {
        return new Peli(io, new Tekoaly());
    }

    public static Peli luoParempiTekoalypeli(IO io) {
        return new Peli(io, new TekoalyParannettu(20));
    }

    protected Peli(IO io, Pelityyppi pelityyppi) {
        this.peli = pelityyppi;
        this.io = io;
    }

    public void pelaa() {
        Tuomari tuomari = new Tuomari();
        this.io = io;
        System.out.println("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = io.read();
        String tokanSiirto = this.peli.annaSiirto();

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println("");

            System.out.println("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = io.read();

            tokanSiirto = this.peli.annaSiirto();
            this.peli.asetaSiirto(ekanSiirto);

        }
        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
