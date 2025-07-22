package com.lld.tictactoe.service;

import com.lld.tictactoe.model.MoveInt;

public interface BoardManagerInt {
    public Integer getSize();
    public boolean mark(final MoveInt move);
    public boolean unmark(final MoveInt move);
}
