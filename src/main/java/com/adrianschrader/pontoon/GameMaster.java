package com.adrianschrader.pontoon;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author adrian
 */
public class GameMaster {
    public static final String LABEL_NAME = "Spieler ";
    
    private final Dice dice;
    private final ArrayList<Player> players;
    
    public GameMaster(int diceFaces, Class<?> playerTypes[]) throws IllegalAccessException, InstantiationException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        this.players = new ArrayList<>();
        for (Class<?> playerType : playerTypes) {
            String newPlayerName = LABEL_NAME + players.size();
            Player newPlayer = (Player)(playerType.getConstructor(new Class<?>[] { String.class }).newInstance(newPlayerName));
            this.players.add(newPlayer);
        }
        this.dice = new Dice(diceFaces);
    }
    
    public GameMaster(int diceFaces, ArrayList<Player> players) {
        this.players = players;
        this.dice = new Dice(diceFaces);
    }
    
    public void begin(int goalScore, int rounds) {
        // Every player gets one turn
        for (Player player : this.players) {
            player.resetScore();
            player.play(this.dice, goalScore);
        }
        
        // Sorting the players by their resulting score
        this.players.sort((Player a, Player b) -> {
            // Distance between the goal and the score
            int distA = a.getScore();
            int distB = b.getScore();
            
            // If the distance is negative, players get dismissed
            if (distA > goalScore || distB > goalScore) {
                int val = (distA > goalScore && distB > goalScore) ? 0 :
                        (distA > goalScore) ? 1 : -1;
                return val;
            }
            
            // Sort the remaining players by the least distance to the goal
            int val = distA > distB ? -1 : distA == distB ? 0 : 1;
            return val;
        });
        
        Player winner = this.players.get(0);
        if (this.players.get(0).getScore() <= goalScore) {
            if (this.players.get(0).getScore() > this.players.get(1).getScore()) {
                System.out.println(winner.getName() + " hat mit " + winner.getScore() + " Punkten gewonnen. ");
            } else {
                System.out.println("Es steht unendschieden. ");
            }
        } else {
            System.out.println("Upps... Ich habe falsch sortiert. ");
        }
        
        
        // Repeat with every round
        if (rounds - 1 > 0) {
            this.begin(goalScore, rounds - 1);
        }
    }
    
    public Player getWinner() {
        return this.players.get(0);
    }

    /**
     * @return the players
     */
    public List<Player> getPlayers() {
        return this.players;
    }
}
