package com.adrianschrader.pontoon;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Generates pseudorandom numbers from one to six. 
 * @author Adrian Schrader
 */
public class Dice {
    
    private final Random random;
    private final int faces;
    
    /**
     * Creates a six sided dice returning pseudorandom numbers
     */
    public Dice() {
        this.random = new Random();
        this.faces = 6;
    }
    
    /**
     * Creates a dice with a varying number of faces returning pseudorandom numbers
     * @param faces Upper Bound (inclusive)
     */
    public Dice(int faces) {
        this.random = new Random();
        this.faces = faces;
    }
    
    /**
     * Returns the number of faces. 
     * @return One greater than the upper faces
     */
    public int getFaces() {
        return this.faces;
    }
    
    /**
     * Returns all possible outcomes
     * @return Array of the values of the outcomes
     */
    public int[] getOutcomes() {
        int outcomes[] = new int[this.faces];
        for (int outcome = 0; outcome < this.faces; outcome++) {
            outcomes[outcome] = outcome + 1;
        }
        return outcomes;
    }
    
    /**
     * @return Expected value of the dice
     */
    public double getMean() {
        return IntStream.of(this.getOutcomes()).average().orElse(0);
    }
    
    /**
     * @return Pseudorandom integer from 1 to the upper faces
     */
    public int roll() {
        return (this.random.nextInt(faces) + 1);
    }
}
