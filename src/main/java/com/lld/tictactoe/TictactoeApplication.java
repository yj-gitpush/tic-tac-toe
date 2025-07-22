package com.lld.tictactoe;

import com.lld.tictactoe.model.*;
import com.lld.tictactoe.service.BoardManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TictactoeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TictactoeApplication.class, args);

		System.out.println("starting the game");

		Game game = new Game();
		game.addPlayer(new Player(1L, "yash"));
		game.addPlayer(new Player(2L, "p"));

		Board board = new Board(3);
		BoardManager boardManager = new BoardManager(board);
		game.setBoardManager(boardManager);

		game.start();
		Player p1 = game.getNextTurnPlayer();
		MoveInt move = new MarkingMove(1, 1, p1);
		game.makeMove(move);

		Player p = game.getNextTurnPlayer();
		move = new MarkingMove(1,2,p);
		game.makeMove(move);

		p = game.getNextTurnPlayer();
		move = new MarkingMove(0, 1, p);
		game.makeMove(move);

		game.undoMove();

		game.terminate();
	}

}
