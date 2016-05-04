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
public class BalancedPlayerTest {
    
    public BalancedPlayerTest() {
    }

    /**
     * Test of play method, of class BalancedPlayer.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        Dice dice = new Dice(6);
        BalancedPlayer instance = new BalancedPlayer("George");
        instance.play(dice, 21);
        assertThat(instance.getScore()).isBetween(0, 27);
    }
    
}
