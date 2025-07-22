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
        return 0;
    }

    @Override
    public boolean mark(MoveInt move) {
        final Player player = board.getCells().get(move.getX()).get(move.getY()).getPlayer();
    }

    @Override
    public boolean unmark(MoveInt move) {
        return false;
    }
}
