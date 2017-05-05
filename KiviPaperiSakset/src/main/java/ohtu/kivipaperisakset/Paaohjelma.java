package ohtu.kivipaperisakset;

public class Paaohjelma {

    private static IO io;
    private static Pelitehdas pelitehdas;
    
    public static void main(String[] args) {
        io = new GameIO();
        pelitehdas = new Pelitehdas(io);

        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = io.read();            
                
            if (pelitehdas.peliExist(vastaus)) {
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                Peli peli = pelitehdas.getPeli(vastaus);
                peli.pelaa();
            } else {
                break;
            }

        }

    }
}
