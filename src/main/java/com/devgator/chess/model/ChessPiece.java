package com.devgator.chess.model;

/**
 * Abstract representation of a chess piece.
 */
public enum ChessPiece {

    KING("K"),
    QUEEN("Q"),
    ROOK("R"),
    KNIGHT("T"),
    BISHOP("B"),
    PAWN("P");

    private final String shape;

    /**
     * Creates a new chess piece
     * @param shape string representation of the chess piece
     */
    ChessPiece(String shape) {
        this.shape = shape;
    }

    /**
     * Returns the string representation of the chess piece
     * @return string representation of the chess piece
     */
    public String toString() {
        return this.shape;
    }
}
