package com.lld.tictactoe.model;

import com.lld.tictactoe.service.BoardManagerInt;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MarkingMove implements MoveInt{
    private Integer x;
    private Integer y;
    private Player player;

    public boolean apply(final BoardManagerInt boardManager){
        if(!this.isValid(boardManager)){
            return false;
        }
        boardManager.mark(this);
        return true;
    }

    @Override
    public boolean undo(BoardManagerInt boardManager) {
        boardManager.unmark(this);
        return true;
    }

    public boolean isValid(final BoardManagerInt boardManager){
        return true;
    }
}
