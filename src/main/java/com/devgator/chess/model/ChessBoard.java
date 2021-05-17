package com.devgator.chess.model;

import java.util.Arrays;

/**
 * Abstract representation of a chess board.
 * The board is internally implemented using a 0-based 2-D array of ChessPiece.
 * Each cell of the array represents a square in the chess board.
 * If a square is occupied, the corresponding array cell will contain a ChessPiece. Otherwise, the cell will be null.
 */
public class ChessBoard {

    private final ChessPiece[][] squares;

    /**
     * Creates a new chess board of size NxN
     * @param N chess board size
     */
    public ChessBoard(int N) {
        squares = new ChessPiece[N][N];
    }

    /**
     * Create a deep copy of the given object
     * @param board object to copy
     */
    public ChessBoard(ChessBoard board) {
        this.squares = Arrays.stream(board.squares).map(ChessPiece[]::clone).toArray(ChessPiece[][]::new);
    }

    /**
     * Places the given piece in the given 0-based row and column of the 2-D representation of the chess board
     * @param row row index
     * @param col column index
     * @param piece piece to place
     */
    public void placePiece(int row, int col, ChessPiece piece) {
        squares[row][col] = piece;
    }

    /**
     * Removes the piece from the given 0-based row and column of the 2-D representation of the chess board
     * @param row row index
     * @param col column index
     */
    public void removePiece(int row, int col) {
        squares[row][col] = null;
    }

    /**
     * Returns the piece in the given 0-based row and column of the 2-D representation of the chess board
     * @param row row index
     * @param col column index
     * @return piece at the given position
     */
    public ChessPiece getPieceAt(int row, int col) {
        return  squares[row][col];
    }

    /**
     * Returns the size of the chess board
     * @return chess board size
     */
    public int size() {
        return squares.length;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ChessBoard)) {
            return false;
        }

        return Arrays.deepEquals(squares, ((ChessBoard) other).squares);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (ChessPiece[] row : squares) {
            for (ChessPiece piece : row) {
                if (piece != null) {
                    stringBuilder.append(piece.toString());
                } else {
                    stringBuilder.append(".");
                }
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
