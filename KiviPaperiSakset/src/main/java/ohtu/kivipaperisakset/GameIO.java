/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.Scanner;
/**
 *
 * @author mlyra
 */

public class GameIO implements IO {
    
    private static Scanner scanner;
    
    public GameIO() {
        scanner = new Scanner(System.in);
    }
    
    @Override
    public String read() {
        return scanner.nextLine();
    }

    
}
