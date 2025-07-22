package com.lld.tictactoe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private Integer size;
    private List<List<Cell>> cells;

    public Board(int size){
        this.size = size;
        this.cells = new ArrayList<>();
        for(int i=0; i<size; i++){
            List<Cell> row = new ArrayList<>();
            for(int j=0; j<size; j++){
                row.add(new Cell());
            }
            this.getCells().add(row);
        }
    }
}
