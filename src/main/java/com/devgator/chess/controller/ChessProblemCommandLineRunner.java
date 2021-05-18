package com.devgator.chess.controller;

import com.devgator.chess.view.ChessProblemCommandLineUserInterface;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A command line interface implementation of a chess problem solver.
 * It uses System.in to get input from the user and System.out to display messages.
 */
public class ChessProblemCommandLineRunner extends ChessProblemRunner {

    /**
     * Creates a new chess problem runner that uses the command line to interact with the user.
     * @param solver solver to be used to solve the chess problem
     */
    public ChessProblemCommandLineRunner(ChessProblemSolver solver) {
        super(solver, new ChessProblemCommandLineUserInterface());
    }

    @Override
    public int getUserInputAsInt(String message) {
        do {
            try {
                System.out.print(message);
                Scanner scanner = new Scanner(System.in);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number.");
            }
        } while (true);
    }

    @Override
    public char getUserInputAsChar(String message) {
        do {
            try {
                System.out.print(message);
                Scanner scanner = new Scanner(System.in);
                return scanner.next().charAt(0);
            } catch (InputMismatchException e) {
                System.out.println("Please enter a character.");
            }
        } while (true);
    }

}
