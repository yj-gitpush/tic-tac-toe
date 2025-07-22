package com.lld.tictactoe.model;

public interface GameInt {
    public boolean start();
    public boolean terminate();
    public boolean addPlayer(final Player player);
    public boolean removePlayer(final Player player);
    public boolean makeMove(final MoveInt move);
    public boolean undoMove();
    public boolean isCompleted();
    public Player getWinner();
    public Player getNextTurnPlayer();
}
