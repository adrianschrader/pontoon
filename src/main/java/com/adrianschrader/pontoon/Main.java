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
public class Main {
    public static void main(String[] args) {
        try {
            GameMaster master = new GameMaster(6, new Class<?>[] {
                BalancedPlayer.class,
                AnxiousPlayer.class,
                DumbPlayer.class,
                StatisticianPlayer.class
            });
            
            master.begin(21, 10);
        } catch(Exception ex) {
        }
        
        
        /**NaivePlayer player = new NaivePlayer("George");
        Dice dice = new Dice(6);
        ((Player)player).play(dice);
        
        System.out.println(player.getScore());**/
    }
}
