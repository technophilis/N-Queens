package com.devgator.chess.nqueens;

import com.devgator.chess.controller.ChessProblemSolver;
import com.devgator.chess.model.ChessBoard;
import com.devgator.chess.nqueens.NQueensBacktrackingSolver;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NQueensBacktrackingSolverTest {

    private final ChessProblemSolver solver = new NQueensBacktrackingSolver();

    @Test
    public void solverShouldThrowExceptionOnInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> solver.findMultipleSolutions(0));
    }

    @Test
    public void solverShouldReturnTheExactNumberOfSolutions() {
        assertEquals(1,  solver.findMultipleSolutions(1).size());
        assertEquals(0,  solver.findMultipleSolutions(2).size());
        assertEquals(0,  solver.findMultipleSolutions(3).size());
        assertEquals(2,  solver.findMultipleSolutions(4).size());
        assertEquals(0,  solver.findMultipleSolutions(5).size());
        assertEquals(0,  solver.findMultipleSolutions(6).size());
        assertEquals(0,  solver.findMultipleSolutions(7).size());
        assertEquals(8,  solver.findMultipleSolutions(8).size());
        assertEquals(32,  solver.findMultipleSolutions(9).size());
    }

    @Test
    public void solverShouldReturnValidSolutions() {
        String[] expectedSolutions = {"..Q.\nQ...\n...Q\n.Q..\n", ".Q..\n...Q\nQ...\n..Q.\n"};
        Arrays.sort(expectedSolutions);

        List<ChessBoard> solutionsList = solver.findMultipleSolutions(4);
        String[] solutions = solutionsList.stream().map(ChessBoard::toString).toArray(String[]::new);
        Arrays.sort(solutions);

        assertArrayEquals(expectedSolutions, solutions);
    }
}
