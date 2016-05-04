package com.adrianschrader.pontoon;

/**
 * 
 * @author adrian
 */
public abstract class Player {
    
    private final String name;
    private int score;
    
    public Player(String name) {
        this.name = name;
        this.score = 0;
    }
    
    protected final void rollDice(Dice dice) {
        this.score += dice.roll();
    }
    
    /**
     * Supposed to be overridden with the actual playing algorithm
     * @param dice Used Dice by the GameMaster for inspection
     * @param goalScore The maximum score to win
     */
    public void play(Dice dice, int goalScore) {
        this.rollDice(dice);
    }
    
    /**
     * @return Name of the player, specified in the constructor
     */
    public final String getName() {
        return name;
    }
    
    /**
     * @return Score of the game, should be less than, but near 21
     */
    public final int getScore() {
        return score;
    }
    
    /**
     * Reset score after every round
     */
    public final void resetScore() {
        this.score = 0;
    }
}
