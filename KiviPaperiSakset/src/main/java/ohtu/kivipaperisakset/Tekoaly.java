package ohtu.kivipaperisakset;

public class Tekoaly extends KonePelaa {

    int siirto;

    public Tekoaly() {
        siirto = 0;
    }

    @Override
    public String koneSiirto() {
        siirto++;
        siirto = siirto % 3;
        String responce;

        if (siirto == 0) {
            return "k";
        } else if (siirto == 1) {
            return "p";
        } else {
            return "s";
        }
    }

    @Override
    public void asetaSiirto(String ekanSiirto) {
        // ei tehdä mitään 
    }

}
