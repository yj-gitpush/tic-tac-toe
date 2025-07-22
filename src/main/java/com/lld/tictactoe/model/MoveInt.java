package com.lld.tictactoe.model;

import com.lld.tictactoe.service.BoardManager;
import com.lld.tictactoe.service.BoardManagerInt;

public interface MoveInt {
    public boolean apply(final BoardManagerInt boardManager);
    public boolean isValid(final BoardManagerInt boardManager);
    public Integer getX();
    public Integer getY();

}
