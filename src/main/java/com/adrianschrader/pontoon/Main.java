/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrianschrader.pontoon;

import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author adrian
 */
public class Main {
    public static void main(String[] args) {
        try {
            // Initalize the GameMaster with all possible Player classes
            GameMaster master = new GameMaster(new Dice(6), new Class<?>[] {
                BalancedPlayer.class,
                AnxiousPlayer.class,
                DumbPlayer.class,
                StatisticianPlayer.class
            });
            
            // Start the game and give responses to the result
            Result result = master.playRound(21);
            if (result.isTie()) {
                System.out.println("Es steht unendschieden!");
            } else {
                System.out.println(result.getWinner().getName() + " hat mit " + result.getWinner().getScore() + " Punkten gewonnen!");
            }
            
        } catch(IllegalAccessException | InstantiationException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException ex) {
            // After unforseen changes to the reflective invocations, a handled error occurs
            System.err.println(ex.toString());
        }
    }
}
