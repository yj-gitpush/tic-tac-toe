package com.lld.tictactoe.model;

import com.lld.tictactoe.enums.GameState;
import com.lld.tictactoe.service.BoardManager;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Game implements GameInt{
    private BoardManager boardManager;
    private Player winner;
    private List<MarkingMove> markingMoveHistory;
    private List<Player> players;
    private GameState gameState;

    public boolean start(){
        return true;
    }

    public boolean terminate(){
        return true;
    }

    public boolean addPlayer(final Player player){
        for(Player p: players){
            if( p == player ){
                return false;
            }
        }
        players.add(player);
        return true;
    }

    public boolean removePlayer(final Player player){
        return players.remove(player);
    }

    public boolean makeMove(final MarkingMove markingMove){
        return true;
    }

    public boolean undoMove(){
        return true;
    }

    public boolean isCompleted(){
        return gameState == GameState.COMPLETED;
    }

    public Player getWinner(){
        return new Player();
    }

}
