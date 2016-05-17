/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrianschrader.pontoon;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

/**
 *
 * @author adrian
 */
public class DiceTest {
    
    public DiceTest() {
    }

    /**
     * Test of getFaces method, of class Dice.
     */
    @org.junit.Test
    public void testGetFaces() {
        Dice dice = new Dice(8);
        assertThat(dice.getFaces()).isEqualTo(8);
    }
    
    /**
     * Test of getOutcomes method, of class Dice.
     */
    @org.junit.Test
    public void testGetOutcomes() {
        Dice dice = new Dice(4);
        assertThat(dice.getOutcomes()).isEqualTo(new int[] { 1, 2, 3, 4 });
    }
    
    /**
     * Test of getMean method, of class Dice.
     */
    @org.junit.Test
    public void testGetMean() {
        Dice dice = new Dice(6);
        assertThat(dice.getMean()).isEqualTo(3.5);
    }

    /**
     * Test of roll method, of class Dice.
     */
    @org.junit.Test
    public void testRoll() {
        Dice dice = new Dice(6);

        int result = 0,
            sampleSize = 10000;
        double uncertanty = 0.1d,
               mean = dice.getMean();
        
        // Throw the dice several times, average the result and expect it to be
        // in an uncertanty range
        for (int i = 0; i < sampleSize; i++) {
            result += dice.roll();
        }
        assertThat((double)result / sampleSize).isBetween(mean - uncertanty, mean + uncertanty);
    }
    
}
