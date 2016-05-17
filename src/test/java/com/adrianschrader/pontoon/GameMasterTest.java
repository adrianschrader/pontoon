/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrianschrader.pontoon;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

/**
 *
 * @author adrian
 */
public class GameMasterTest {
    
    public GameMasterTest() {
    }
    
    private GameMaster generateGameMaster()  {
        try {
        return new GameMaster(new Dice(6), new Class<?>[] {
            BalancedPlayer.class,
            AnxiousPlayer.class
        });
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException ex) {
            fail("Could not generate GameMaster object from classtypes");
            return null;
        }        
    }

    /**
     * Test of playRound method, of class GameMaster.
     */
    @Test
    public void testPlayRound() {
        GameMaster master = this.generateGameMaster();
        
        for (int i = 0; i < 100; i++) {
            Result result = master.playRound(21);

            if (result.isTie()) {
                if (result.getWinner().getScore() > 21)
                    // It's a tie because both players lost
                    assertThat(result.getRunnerup().getScore()).isGreaterThan(21);
                else if (result.getRunnerup().getScore() > 21)
                    // It's a tie because both players lost
                    assertThat(result.getWinner().getScore()).isGreaterThan(21);
                else
                    // It's a tie because both players have the same score
                    assertThat(result.getWinner().getScore()).isEqualTo(result.getRunnerup().getScore());
            } else {
                // A winning player can never have more than 21 points
                assertThat(result.getWinner().getScore()).isLessThanOrEqualTo(21);
                
                // A winning player has more points than the runner-up when he wins by comparison
                if (result.getRunnerup().getScore() <= 21)
                    assertThat(result.getWinner().getScore()).isGreaterThan(result.getRunnerup().getScore());
            }
        }
    }

    /**
     * Test of resetResults method, of class GameMaster.
     */
    @Test
    public void testResetResults() {
        GameMaster master = this.generateGameMaster();
        
        // Play one round
        master.playRound(21);
        master.playRound(21);
        
        // Reset results
        master.resetResults();
        assertThat(master.getResults()).hasSize(0);
    }

    /**
     * Test of getLastResult method, of class GameMaster.
     */
    @Test
    public void testGetLastResult() {
        GameMaster master = this.generateGameMaster();
        
        // Play two rounds
        Result res1 = master.playRound(21),
               res2 = master.playRound(21);
        
        assertThat(master.getResults()).contains(master.getLastResult());
        assertThat(master.getLastResult()).isNotEqualTo(res1);
        assertThat(master.getLastResult()).isEqualTo(res2);
    }

    /**
     * Test of getResults method, of class GameMaster.
     */
    @Test
    public void testGetResults() {
        GameMaster master = this.generateGameMaster();
        
        Result res1 = master.playRound(21),
               res2 = master.playRound(21);
        
        assertThat(master.getResults()).containsExactly(res1, res2);
    }

    /**
     * Test of getPlayers method, of class GameMaster.
     */
    @Test
    public void testGetPlayers() {
        // Test players from generator
        ArrayList<Player> players = new ArrayList<>();
        players.add(new BalancedPlayer(""));
        players.add(new DumbPlayer(""));
        GameMaster master = new GameMaster(new Dice(6), players);
        
        assertThat(master.getPlayers()).isSameAs(players);
    }
    
}
