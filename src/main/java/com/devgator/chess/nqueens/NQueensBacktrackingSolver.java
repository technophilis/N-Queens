package com.devgator.chess.nqueens;

import com.devgator.chess.controller.ChessProblemSolver;
import com.devgator.chess.model.ChessBoard;

import java.util.ArrayList;
import java.util.List;

import static com.devgator.chess.model.ChessPiece.QUEEN;

/**
 * Solves the N-Queens problem for a chess board of size N.
 * Each queen should be placed on the board with no other queens attacking it.
 * No 3 queens should form a straight line at any angle.
 */
public class NQueensBacktrackingSolver implements ChessProblemSolver {

    private List<ChessBoard> solutions;

    private ChessBoard board;

    @Override
    public List<ChessBoard> findMultipleSolutions(int N) {
        if (N < 1) {
            throw new IllegalArgumentException("Board size should be greater or equal to 1");
        }

        board = new ChessBoard(N);
        solutions = new ArrayList<>();
        runDepthFirstSearch( 0);
        return solutions;
    }

    /**
     * Runs a depth first search algorithm to find all possible solutions to the N-Queens problem.
     * The algorithm gradually places queens in each column before moving to the next.
     * For each column, if it finds a solution or doesn't find any valid row placements, it backtracks to the previous
     * state.
     * @param colIndex the current column index to place a piece in
     */
    private void runDepthFirstSearch(int colIndex) {
        if (colIndex == board.size()) {
            solutions.add(new ChessBoard(board));
            return;
        }

        for (int rowIndex = 0; rowIndex < board.size(); rowIndex++) {
            if (isPositionValid(rowIndex, colIndex)) {
                board.placePiece(rowIndex, colIndex, QUEEN);
                runDepthFirstSearch(colIndex + 1);
                board.removePiece(rowIndex, colIndex);
            }
        }
    }

    /**
     * Checks whether the given 0-based row and column indexes are a valid placement
     * @param x1 row index
     * @param y1 column index
     * @return whether the given position is valid
     */
    private boolean isPositionValid(int x1, int y1) {
        // loop through all previous valid positions (x2, y2)
        for (int x2 = 0; x2 < board.size(); x2++) {
            for (int y2 = 0; y2 < y1; y2++) {
                if (board.getPieceAt(x2, y2) == QUEEN) {
                    // check if the queen found at (x2, y2) attacks a queen if placed at (x1, y1)
                    if (x1 + y2 == y1 + x2 || x1 + y1 == x2 + y2 || x1 == x2) {
                        return false;
                    }

                    // checks if there is a 3rd queen in a straight line with the 1st and 2nd queens
                    if (isAnyQueenInLine(x1, y1, x2, y2)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Checks whether there is a queen forming a straight line with the queens in the given positions.
     * All indices are 0-based positions in a chess board starting from the top left.
     * @param x1 row index of the 1st queen
     * @param y1 column index of the 1st queen
     * @param x2 row index of the second queen
     * @param y2 column index of the second queen
     * @return whether a 3rd queen forms a straight line with the queens in the given positions
     */
    private boolean isAnyQueenInLine(int x1, int y1, int x2, int y2) {
        // distance increment used to check for a possible queen in line with the 1st and 2nd
        int gcd = getGcd(Math.abs(x2 - x1), Math.abs(y2 - y1));
        int dx = (x2 - x1) / gcd;
        int dy = (y2 - y1) / gcd;

        // loop through all positions in the same line as the 1st and 2nd queens using row and column increments
        int k = 0;
        while (true) {
            k++;
            int x3 = x1 + k * dx;
            int y3 = y1 + k * dy;
            if (x3 < 0 || x3 >= board.size() || y3 < 0 || y3 >= board.size()) {
                break;
            }
            if (board.getPieceAt(x3, y3) == QUEEN && x3 != x2 && y3 != y2) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns the greatest common divisor of the given integer
     * @param x first integer
     * @param y second integer
     * @return greatest common divisor
     */
    private int getGcd(int x, int y) {
        while (y != 0) {
            int t = y;
            y = x % y;
            x = t;
        }
        return x;
    }

    @Override
    public String getSolverName() {
        return "N-Queens Problem Solver";
    }
}
