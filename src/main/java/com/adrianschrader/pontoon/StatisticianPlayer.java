/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrianschrader.pontoon;

import java.util.stream.IntStream;

/**
 *
 * @author adrian
 */
public class StatisticianPlayer extends Player {
    public StatisticianPlayer(String name) {
        super(name);
    }
    
    @Override
    public void play(Dice dice, int goalScore) {
        double risk = 2;
        for (int i = 0; i < Math.round(dice.getMeanValue() + risk); i++) {
            this.rollDice(dice);
        }
    }
}
