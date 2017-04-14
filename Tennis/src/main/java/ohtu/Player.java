/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

/**
 *
 * @author mlyra
 */
public class Player {

    private String playerName;
    private int PlayerScore;

    public Player(String playerName) {
        this.playerName = playerName;
        this.PlayerScore = 0;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public int getPlayerScore() {
        return this.PlayerScore;
    }

    public void addPoit() {
        this.PlayerScore++;
    }

}
