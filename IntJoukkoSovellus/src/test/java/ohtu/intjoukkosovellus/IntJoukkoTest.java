package ohtu.intjoukkosovellus;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IntJoukkoTest {

    IntJoukko joukko;

    @Before
    public void setUp() {
        joukko = new IntJoukko();
        joukko.lisaa(10);
        joukko.lisaa(3);
    }

    @Test
    public void lukujaLisattyMaara() {
        joukko.lisaa(4);
        assertEquals(3, joukko.mahtavuus());
    }

    @Test
    public void samaLukuMeneeJoukkoonVaanKerran() {
        joukko.lisaa(10);
        joukko.lisaa(3);
        assertEquals(2, joukko.mahtavuus());
    }

    @Test
    public void vainLisatytLuvutLoytyvat() {
        assertTrue(joukko.etsiAlkio(10));
        assertFalse(joukko.etsiAlkio(5));
        assertTrue(joukko.etsiAlkio(3));
    }

    @Test
    public void poistettuEiOleEnaaJoukossa() {
        joukko.poista(3);
        assertFalse(joukko.etsiAlkio(3));
        assertEquals(1, joukko.mahtavuus());
    }
    
        @Test
    public void poistettuEiOleJoukossa() {
        joukko.poista(2);
        assertTrue(joukko.etsiAlkio(3));
        assertEquals(2, joukko.mahtavuus());
    }

    @Test
    public void palautetaanOikeaTaulukko() {
        int[] odotettu = {3, 55, 99};

        joukko.lisaa(55);
        joukko.poista(10);
        joukko.lisaa(99);

        int[] vastaus = joukko.toIntArray();
        Arrays.sort(vastaus);
        assertArrayEquals(odotettu, vastaus);
    }

    @Test
    public void toimiiKasvatuksenJalkeen() {
        int[] lisattavat = {1, 2, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14};
        for (int luku : lisattavat) {
            joukko.lisaa(luku);
        }
        assertEquals(14, joukko.mahtavuus());
        assertTrue(joukko.etsiAlkio(11));
        joukko.poista(11);
        assertFalse(joukko.etsiAlkio(11));
        assertEquals(13, joukko.mahtavuus());
    }

    @Test
    public void toStringToimii() {
        assertEquals("{10, 3}", joukko.toString());
    }

    @Test
    public void toStringToimiiYhdenKokoiselleJoukolla() {
        joukko = new IntJoukko();
        joukko.lisaa(1);
        assertEquals("{1}", joukko.toString());
    }

    @Test
    public void toStringToimiiTyhjallaJoukolla() {
        joukko = new IntJoukko();
        assertEquals("{}", joukko.toString());
    }

    @Test
    public void leikkausTesti() {
        IntJoukko apujoukko = new IntJoukko();
        apujoukko.lisaa(3);
        joukko = joukko.leikkaus(apujoukko);
        assertEquals("{3}", joukko.toString());
    }

    @Test
    public void erotusTesti() {
        IntJoukko apujoukko = new IntJoukko();
        apujoukko.lisaa(3);
        joukko = joukko.erotus(apujoukko);
        assertEquals("{10}", joukko.toString());
    }

    @Test
    public void yhdisteTesti() {
        IntJoukko apujoukko = new IntJoukko();
        apujoukko.lisaa(7);
        joukko = joukko.yhdiste(apujoukko);
        assertEquals("{10, 3, 7}", joukko.toString());
    }
}
