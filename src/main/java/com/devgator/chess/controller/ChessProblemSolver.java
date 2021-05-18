package com.devgator.chess.controller;

import com.devgator.chess.model.ChessBoard;

import java.util.List;

/**
 * An object that provides an algorithm to solve a chess problem.
 * A chess problem is defined by the following: for a given chess board of size N find all chess board states
 * that satisfy a set of constraints.
 * A state is a given chess board with a specific placement of pieces on it.
 */
public interface ChessProblemSolver {

    /**
     * Finds the list of solutions for a given chess problem.
     * @param N chess board size
     * @return a list of solutions
     * @throws IllegalArgumentException if N doesn't satisfy the problem requirements
     */
    List<ChessBoard> findMultipleSolutions(int N) throws IllegalArgumentException;

    /**
     * Returns name of the problem solver
     * @return problem solver name
     */
    String getSolverName();
}
