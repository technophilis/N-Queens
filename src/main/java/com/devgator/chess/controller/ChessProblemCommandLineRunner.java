package com.devgator.chess.controller;

import com.devgator.chess.view.ChessProblemCommandLineUserInterface;

import java.util.Scanner;

/**
 * A command line interface implementation of a chess problem solver.
 * It uses System.in to get input from the user and System.out to display output.
 */
public class ChessProblemCommandLineRunner extends ChessProblemRunner {

    private final Scanner scanner;

    /**
     * Creates a new chess problem runner that uses the command line to interact with the user.
     * @param solver solver to be used to solve the chess problem
     */
    public ChessProblemCommandLineRunner(ChessProblemSolver solver) {
        super(solver, new ChessProblemCommandLineUserInterface());
        scanner = new Scanner(System.in);
    }

    @Override
    public int getUserInputAsInt(String message) {
        System.out.print(message);
        return scanner.nextInt();
    }

    @Override
    public char getUserInputAsChar(String message) {
        System.out.print(message);
        return scanner.next().charAt(0);
    }

}
