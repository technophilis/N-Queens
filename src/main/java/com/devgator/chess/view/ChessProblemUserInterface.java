package com.devgator.chess.view;

import com.devgator.chess.model.ChessBoard;

/**
 * An object that provides a user interface to display content to the user.
 */
public interface ChessProblemUserInterface {

    /**
     * Displays a message to the user
     * @param message message to display
     */
    void showMessage(String message);

    /**
     * Displays the given chess board to the user
     * @param chessBoard chess board to display
     */
    void showChessBoard(ChessBoard chessBoard);

}
