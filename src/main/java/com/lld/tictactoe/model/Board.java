package com.lld.tictactoe.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Board {
    private List<List<Cell>> board;
}
