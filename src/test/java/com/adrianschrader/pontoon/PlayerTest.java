/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrianschrader.pontoon;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

/**
 *
 * @author adrian
 */
public class PlayerTest {
    
    public PlayerTest() {
    }

    /**
     * Test of rollDice method, of class Player.
     */
    @Test
    public void testRollDice() {
        PlayerImpl instance = new PlayerImpl();
        instance.rollDice();
        assertThat(instance.getScore()).isBetween(1, 6);
    }

    /**
     * Test of getName method, of class Player.
     */
    @Test
    public void testGetName() {
        PlayerImpl instance = new PlayerImpl();
        assertThat(instance.getName()).isEqualTo("George");
    }

    /**
     * Test of resetScore method, of class Player.
     */
    @Test
    public void testResetScore() {
        PlayerImpl instance = new PlayerImpl();
        instance.rollDice();
        instance.resetScore();
        assertThat(instance.getScore()).isEqualTo(0);
    }

    public class PlayerImpl extends Player {

        public PlayerImpl() {
            super("George");
        }
        
        @Override
        public void play(Dice dice, int goalScore) {
            
        }
        
        public void rollDice() {
            this.rollDice(new Dice(6));
        }
    }
    
}
