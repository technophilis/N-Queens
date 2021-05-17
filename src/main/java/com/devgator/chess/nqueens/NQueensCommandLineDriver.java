package com.devgator.chess.nqueens;

import com.devgator.chess.controller.ChessProblemCommandLineRunner;
import com.devgator.chess.controller.ChessProblemRunner;
import com.devgator.chess.controller.ChessProblemSolver;

public class NQueensCommandLineDriver {

    public static void main(String[] args) {
        ChessProblemSolver nQueensSolver = new NQueensBacktrackingSolver();
        ChessProblemRunner runner = new ChessProblemCommandLineRunner(nQueensSolver);
        while (true) {
            runner.run();
            char choice = runner.getUserInputAsChar("Enter 'C' to continue (anything else to quit): ");
            if (choice != 'C') {
                break;
            }
        }
    }

}