/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.*;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        // luodaan Staatistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @Test
    public void searchOkTest() {
        String pelaaja = stats.search("Kurri").getName();
        assertEquals("Kurri", pelaaja);
    }

    @Test
    public void searchMissTest() {
        Player pelaaja = stats.search("Jokumuu");
        assertEquals(null, pelaaja);
    }

    @Test
    public void topScorersTest() {
        List<Player> testilista = stats.topScorers(1);
        Player pelaaja = testilista.get(0);
        assertEquals("Gretzky", pelaaja.getName());
    }

    @Test
    public void TeamTest() {
        List<Player> testilista = stats.team("EDM");
        assertEquals(3, testilista.size());
    }
}
