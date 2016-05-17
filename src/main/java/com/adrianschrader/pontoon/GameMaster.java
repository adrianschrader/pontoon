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
    private       ArrayList<Result> results;
    
    public GameMaster(Dice dice, Class<?> playerTypes[]) throws IllegalAccessException, InstantiationException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        this.results = new ArrayList<>();
        this.players = new ArrayList<>();
        for (Class<?> playerType : playerTypes) {
            String newPlayerName = LABEL_NAME + players.size();
            Player newPlayer = (Player)(playerType.getConstructor(new Class<?>[] { String.class }).newInstance(newPlayerName));
            this.players.add(newPlayer);
        }
        this.dice = dice;
    }
    
    public GameMaster(Dice dice, ArrayList<Player> players) {
        this.results = new ArrayList<>();
        this.players = players;
        this.dice = dice;
    }
    
    public Result playRound(int goalScore) {
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
                return (distA > goalScore && distB > goalScore) ? 0 :
                        (distA > goalScore) ? 1 : -1;
            }
            
            // Sort the remaining players by the least distance to the goal
            return distA > distB ? -1 : distA == distB ? 0 : 1;
        });
        
        // Tie occurs when both players have the same score or both surpass
        // the maximum score
        Player winner = this.players.get(0);
        Player runnerup = this.players.get(1);
        boolean tie = (winner.getScore() > goalScore || winner.getScore() == runnerup.getScore());
        
        Result result = new Result(tie, winner, runnerup);
        this.results.add(result);
        return result;
        
        // Repeat with every round
        /*if (rounds - 1 > 0) {
            this.playRound(goalScore, rounds - 1);
        }*/
    }
    
    public void resetResults() {
        this.results = new ArrayList<Result>();
    }
    
    /**
     * @return the last element of the result list
     */
    public Result getLastResult() {
        return this.results.get(this.results.size() - 1);
    }
    
    /**
     * @return the results list
     */
    public ArrayList<Result> getResults() {
        return this.results;
    }

    /**
     * @return the players list
     */
    public ArrayList<Player> getPlayers() {
        return this.players;
    }
}
