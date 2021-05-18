package com.devgator.chess.view;

import com.devgator.chess.model.ChessBoard;

/**
 * A command line interface implementation of the user interface to solve a chess problem.
 * It uses System.out to display content to the user.
 */
public class ChessProblemCommandLineUserInterface implements ChessProblemUserInterface {

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showChessBoard(ChessBoard chessBoard) {
        System.out.print(chessBoard.toString());
    }
}
