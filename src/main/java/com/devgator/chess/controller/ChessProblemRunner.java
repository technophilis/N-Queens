package com.devgator.chess.controller;

import com.devgator.chess.model.ChessBoard;
import com.devgator.chess.view.ChessProblemUserInterface;

import java.util.List;

/**
 * An object that manages the lifecycle of a chess problem. It is responsible for user interactions,
 * running the problem solver and displaying the solutions.
 */
public abstract class ChessProblemRunner {

    private final ChessProblemSolver solver;

    private final ChessProblemUserInterface visualizer;

    /**
     * Makes a new problem runner
     * @param solver the chess problem solver to run
     * @param visualizer the visualizer to use to display output to the user
     */
    public ChessProblemRunner(ChessProblemSolver solver, ChessProblemUserInterface visualizer) {
        this.solver = solver;
        this.visualizer = visualizer;
    }

    /**
     * Shows the given message to the user and returns the input entered as an int
     * @param message to display to the user
     * @return user input
     */
    public abstract int getUserInputAsInt(String message);

    /**
     * Shows the given message to the user and returns the input entered as a char
     * @param message to display to the user
     * @return user input
     */
    public abstract char getUserInputAsChar(String message);

    /**
     * Runs the steps to solve a chess problem
     */
    public void run() {
        int N = getUserInputAsInt("Enter board size: ");
        visualizer.showMessage(String.format("Using %s on a board of size %d ...", solver.getSolverName(), N));
        List<ChessBoard> solutions = solver.findMultipleSolutions(N);
        visualizer.showMessage(String.format("Found %d solutions.", solutions.size()));
        for (ChessBoard board : solutions) {
            char choice = getUserInputAsChar("Enter 'N' to show the next solution (anything else to stop): ");
            if (choice != 'N') {
                break;
            }
            visualizer.showChessBoard(board);
        }
    }

}
