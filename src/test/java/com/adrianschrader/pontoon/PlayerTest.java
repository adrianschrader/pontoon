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
public class PlayerTest {
    
    public PlayerTest() {
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
     * Test of rollDice method, of class Player.
     */
    @Test
    public void testRollDice() {
        System.out.println("rollDice");
        Dice dice = new Dice(6);
        Player instance = (Player)(new BalancedPlayer("George"));
        instance.rollDice(dice);
        assertThat(instance.getScore()).isBetween(1, 6);
    }

    /**
     * Test of getName method, of class Player.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "George";
        Player instance = (Player)(new BalancedPlayer(expResult));
        String result = instance.getName();
        assertThat(result).isEqualTo(expResult);
    }

    /**
     * Test of resetScore method, of class Player.
     */
    @Test
    public void testResetScore() {
        System.out.println("resetScore");
        Player instance = (Player)(new PlayerImpl());
        Dice dice = new Dice(6);
        instance.rollDice(dice);
        instance.resetScore();
        assertThat(instance.getScore()).isEqualTo(0);
    }

    public class PlayerImpl extends Player {

        public PlayerImpl() {
            super("");
        }
    }
    
}
