
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
                                                // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        ljono = new int[KAPASITEETTI];
        alusta(ljono);
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        ljono = new int[kapasiteetti];
        alusta(ljono);
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;

    }
    
       
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) {
            return;
        }
        ljono = new int[kapasiteetti];
        alusta(ljono);
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaa(int luku) {
        if (!etsiAlkio(luku)) {
            ljono[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm == ljono.length)  {
                ljono = kasvataTaulukko(ljono, kasvatuskoko);  
                return true;
            }
        }
        return false;
    }
    
    public boolean etsiAlkio(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        int indeksi = etsiIndeksi(luku, ljono, alkioidenLkm);
        if (indeksi == -1)
            return false;
        siirra(indeksi, ljono, alkioidenLkm);
        alkioidenLkm--;
        return true;
    }
    
        private static int etsiIndeksi(int luku, int[] taulukko, int alkioita) {
        for (int i = 0; i < alkioita; i++) {
            if (luku == taulukko[i]) {
                return i;
            }
        }
        return -1;
    }   

    public int mahtavuus() {
        return alkioidenLkm;
    }    

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = ljono[i];
        }
        return taulu;
    }   

    public IntJoukko yhdiste(IntJoukko b) {
        int[] aputaulu = b.toIntArray();
        for (int i = 0; i < aputaulu.length; i++) {
            this.lisaa(aputaulu[i]);
        }
        return this;
    }

    public IntJoukko leikkaus(IntJoukko b) {
        int[] bTaulu = b.toIntArray();
        IntJoukko apujoukko = new IntJoukko();
        for (int i = 0; i < bTaulu.length; i++) {
            if (this.etsiAlkio(bTaulu[i]))
                apujoukko.lisaa(bTaulu[i]);
        }
        return apujoukko;

    }
    
    public IntJoukko erotus ( IntJoukko b) {
        int[] bTaulu = b.toIntArray();        
        for (int i = 0; i < bTaulu.length; i++) {
            if (this.etsiAlkio(bTaulu[i]))
                this.poista(bTaulu[i]);
        } 
        return this;
    }
    
    private static void alusta(int[] taulukko) {
        for (int i = 0; i < taulukko.length; i++) {
            taulukko[i] = 0;
        }
    }
    
     private static int[] kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        } 
        return uusi;

    }
    
    private static void siirra(int alku, int[] taulukko, int alkioita) {        
        int apu;
        for (int i = alku; i < alkioita - 1; i++) {
            apu = taulukko[i];
            taulukko[i] = taulukko[i + 1];
            taulukko[i + 1] = apu;                
        } 
    }
    
    private static int[] kasvataTaulukko(int[] taulukko, int kasvatuskoko) {
                int[] uusiTaulukko = new int[taulukko.length + kasvatuskoko]; 
                alusta(uusiTaulukko);
                kopioiTaulukko(taulukko, uusiTaulukko);
                return uusiTaulukko;
    }
    
    


        
    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + ljono[0] + "}";
        } else {
            String tuotos = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tuotos += ljono[i];
                tuotos += ", ";
            }
            tuotos += ljono[alkioidenLkm - 1];
            tuotos += "}";
            return tuotos;
        }
    }
}