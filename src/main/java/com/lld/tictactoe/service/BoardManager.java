package com.lld.tictactoe.service;

import com.lld.tictactoe.model.Board;
import com.lld.tictactoe.model.MoveInt;
import com.lld.tictactoe.model.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BoardManager implements BoardManagerInt{
    private Board board;


    @Override
    public Integer getSize() {
        return board.getSize();
    }

    @Override
    public boolean mark(MoveInt move) {
        board.getCells().get(move.getX()).get(move.getY()).setPlayer(move.getPlayer());
        return true;
    }

    @Override
    public boolean unmark(MoveInt move) {
        final int x = move.getX();
        final int y = move.getY();
        board.getCells().get(x).get(y).unmark();
        return true;
    }

    public String printBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                Player player = board.getCells().get(i).get(j).getPlayer();
                if (player != null) {
                    sb.append(player.getId()); // Print the player's ID
                } else {
                    sb.append("-");
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
