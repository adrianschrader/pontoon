/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrianschrader.pontoon;

/**
 *
 * @author adrian
 */
public class BalancedPlayer extends Player {
    
    public BalancedPlayer(String name) {
        super(name);
    }
    
    @Override
    public void play(Dice dice, int goalScore) {
        this.rollDice(dice);
        if (this.getScore() < goalScore - Math.floor(dice.getMeanValue())) {
            play(dice, goalScore);
        }
    }
}
