package ru.job4j.chess;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogicTest {

    @Test
    public void whenMoveBishopBlackFromC5ToF2ThenOccupiedCellException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        Figure bishopBlack = new BishopBlack(Cell.C5);
        Figure pawnBlack = new PawnBlack(Cell.E3);
        logic.add(bishopBlack);
        logic.add(pawnBlack);
        OccupiedCellException exception = assertThrows(OccupiedCellException.class, () -> {
            logic.move(Cell.C5, Cell.F2);
        });
        assertThat(exception.getMessage()).isEqualTo("The cell is occupied");
    }

    @Test
    public void whenMoveBishopBlackFromD8ToH4ThenOccupiedCellException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        Figure bishopBlack = new BishopBlack(Cell.D8);
        Figure pawnBlack = new PawnBlack(Cell.G5);
        logic.add(bishopBlack);
        logic.add(pawnBlack);
        OccupiedCellException exception = assertThrows(OccupiedCellException.class, () -> {
            logic.move(Cell.D8, Cell.H4);
        });
        assertThat(exception.getMessage()).isEqualTo("The cell is occupied");
    }

    @Test
    public void when2MoveBishopBlackFromD8ToH4ThenOccupiedCellException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        Figure bishopBlack = new BishopBlack(Cell.F8);
        Figure pawnBlack = new PawnBlack(Cell.H5);
        logic.add(bishopBlack);
        logic.add(pawnBlack);
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class, () -> {
            logic.move(Cell.D8, Cell.H4);
        });
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    public void when3MoveBishopBlackFromD8ToH4ThenOccupiedCellException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        Figure bishopBlack = new BishopBlack(Cell.D8);
        Figure pawnBlack = new PawnBlack(Cell.H5);
        logic.add(bishopBlack);
        logic.add(pawnBlack);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            logic.move(Cell.D8, Cell.H5);
        });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from D8 to H5");
    }
}