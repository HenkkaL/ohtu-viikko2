package ohtu.verkkokauppa;

public class Kauppa {

    private VarastoRpinta varasto;
    private PankkiRpinta pankki;
    private Ostoskori ostoskori;
    private VgenRpinta viitegeneraattori;
    private String kaupanTili;

    public Kauppa(VarastoRpinta v, PankkiRpinta p, VgenRpinta vgen) {
        varasto = v;
        pankki = p;
        viitegeneraattori = vgen;
        kaupanTili = "33333-44455";
    }

    public void aloitaAsiointi() {
        ostoskori = new Ostoskori();
    }

    public void poistaKorista(int id) {        
        Tuote t = varasto.haeTuote(id);  
        ostoskori.poista(t);
        varasto.palautaVarastoon(t);
        
    }

    public void lisaaKoriin(int id) {
        if (varasto.saldo(id)>0) {
            Tuote t = varasto.haeTuote(id);             
            ostoskori.lisaa(t);
            varasto.otaVarastosta(t);
        }
    }

    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = viitegeneraattori.uusi();
        int summa = ostoskori.hinta();
        
        return pankki.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}
