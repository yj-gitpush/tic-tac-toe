package com.lld.tictactoe.model;

import com.lld.tictactoe.enums.GameState;
import com.lld.tictactoe.service.BoardManager;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Game implements GameInt{
    private BoardManager boardManager;
    private Player winner;
    private List<MoveInt> moveHistory = new ArrayList<>();
    private List<Player> players = new ArrayList<>();
    private GameState gameState = GameState.NOT_STARTED;

    public boolean start(){
        this.setGameState(GameState.IN_PROGRESS);
        return true;
    }

    public boolean terminate(){
        this.setGameState(GameState.COMPLETED);
        return true;
    }

    public boolean addPlayer(final Player player){
        for(Player p: this.getPlayers()){
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

    @Override
    public boolean makeMove(final MoveInt move){
        move.apply(this.getBoardManager());
        this.getMoveHistory().add(move);
        System.out.println(this.printGame());
        return true;
    }

    public String printGame(){
        System.out.println("printing the current game state:");
        return this.getBoardManager().printBoard();
    }

    public boolean undoMove(){
        if(moveHistory.size() == 0) return false;
        final MoveInt lastMove = moveHistory.getLast();
        if(lastMove == null)    return false;
        if(lastMove.getPlayer() != null){
            System.out.println("undoing the last move done by player: " + lastMove.getPlayer().getName());
        }
        lastMove.undo(this.getBoardManager());
        System.out.println(this.printGame());
        return true;
    }

    public boolean isCompleted(){
        return gameState == GameState.COMPLETED;
    }

    @Override
    public Player getNextTurnPlayer() {
        // using round-robin fashion, can scale this better using nextTurnStrategy
        if(players.size() < 2)  return null;
        if(moveHistory.isEmpty()) return this.getPlayers().get(0);
        final MoveInt latestMove = moveHistory.getLast();
        int playerIdx = 0;
        for(int i=0; i<this.getPlayers().size(); i++){
            if(this.getPlayers().get(i) == latestMove.getPlayer()){
                playerIdx = i;
                break;
            }
        }
        int numOfPlayers = this.getPlayers().size();
        System.out.println("playerIdx: " + playerIdx);
        return this.getPlayers().get((playerIdx+1)%numOfPlayers);
    }

}
