/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrianschrader.pontoon;

import com.sun.istack.internal.Nullable;

/**
 *
 * @author adrian
 */
public class Result {
    private final boolean tie;
    private final Player winner;
    private final Player runnerup;

    public Result(boolean tie, Player winner, Player runnerup) {
        this.tie = tie;
        this.winner = winner;
        this.runnerup = runnerup;
    }
    
    /**
     * A tie occurs when both players have the same score or surpassed 
     * the goal score. 
     * @return Weather a winner could not be determined. 
     */
    public boolean isTie() {
        return tie;
    }

    /**
     * @return the winner
     */
    public Player getWinner() {
        return winner;
    }

    /**
     * @return the runner-up (second place)
     */
    public Player getRunnerup() {
        return runnerup;
    }
    
    @Nullable
    public Player getResult() {
        return tie ? null : winner;
    }
}
