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
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getFaces method, of class Dice.
     */
    @org.junit.Test
    public void testGetFaces() {
        System.out.println("getFaces");
        Dice instance = new Dice(8);
        int expResult = 8;
        int result = instance.getFaces();
        assertThat(result).isEqualTo(expResult);
    }
    
    /**
     * Test of getOutcomes method, of class Dice.
     */
    @org.junit.Test
    public void testGetOutcomes() {
        System.out.println("getOutcomes");
        Dice instance = new Dice(4);
        int[] expResult = new int[] { 1, 2, 3, 4 };
        int[] result = instance.getOutcomes();
        assertThat(result).isEqualTo(expResult);
    }

    /**
     * Test of roll method, of class Dice.
     */
    @org.junit.Test
    public void testRoll() {
        System.out.println("roll");
        Dice instance = new Dice();
        int result = 0;
        for (int i = 0; i < 1000; i++) {
            result += instance.roll();
        }
        assertThat(result / 1000.0).isBetween(3.4d, 3.6d);
    }
    
}
