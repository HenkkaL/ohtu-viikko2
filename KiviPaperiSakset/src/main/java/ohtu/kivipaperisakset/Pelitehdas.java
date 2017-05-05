/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.HashMap;

/**
 *
 * @author mlyra
 */
public class Pelitehdas {
    
    private HashMap<String, Peli> pelit;
    
    public Pelitehdas(IO io) {
        pelit = new HashMap<String, Peli>();
        pelit.put("a", Peli.luoKaksinpeli(io));
        pelit.put("b", Peli.luoTekoalypeli(io));
        pelit.put("c", Peli.luoParempiTekoalypeli(io));
    }
    
    public boolean peliExist(String pelityyppi) {
        return pelit.containsKey(pelityyppi);
    }
    
    public Peli getPeli(String pelityyppi) {
        Peli peli = pelit.get(pelityyppi);
        if (peli == null) {
            System.out.println("Väärä pelityyppi");
        }
        return peli;
    }
    
}
