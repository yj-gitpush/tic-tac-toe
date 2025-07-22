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
    private int x;
    private int y;
    private Player player;

    public boolean apply(final BoardManagerInt boardManager){
        if(!isValid(boardManager)){
            return false;
        }
        boardManager.mark(this);
        return true;
    }

    public boolean isValid(final BoardManagerInt boardManager){
        return true;
    }
}
