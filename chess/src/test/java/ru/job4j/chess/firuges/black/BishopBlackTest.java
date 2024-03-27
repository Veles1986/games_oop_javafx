package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;

class BishopBlackTest {

    @Test
    void whenPositionA4True() {
        Cell position = Cell.A4;
        BishopBlack bishopBlack = new BishopBlack(position);
        assertThat(position).isEqualTo(bishopBlack.position());
    }

    @Test
    void whenCopyFromA2ToA5True() {
        Cell destination = Cell.A5;
        Figure bishopBlack = new BishopBlack(Cell.A2);
        assertThat(destination).isEqualTo(bishopBlack.copy(destination).position());
    }

    @SuppressWarnings("checkstyle:LineLength")
    @Test
    void wayFromH6ToD2() {
        Cell[] expected = new Cell[] {
                Cell.findBy(6, 3),
                Cell.findBy(5, 4),
                Cell.findBy(4, 5),
                Cell.findBy(3, 6)
        };
        Cell position = Cell.H6;
        Cell destination = Cell.D2;
        BishopBlack bishopBlack = new BishopBlack(position);
        Cell[] result = bishopBlack.way(destination);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void wayFromA7ToG1() {
        Cell[] expected = new Cell[] {
                Cell.findBy(1, 2),
                Cell.findBy(2, 3),
                Cell.findBy(3, 4),
                Cell.findBy(4, 5),
                Cell.findBy(5, 6),
                Cell.findBy(6, 7)
        };
        Cell position = Cell.A7;
        Cell destination = Cell.G1;
        BishopBlack bishopBlack = new BishopBlack(position);
        Cell[] result = bishopBlack.way(destination);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void fromC3ToF6isDiagonalTrue() {
        Cell position = Cell.C3;
        Cell destination = Cell.F6;
        BishopBlack bishopBlack = new BishopBlack(position);
        assertThat(bishopBlack.isDiagonal(bishopBlack.position(), destination)).isEqualTo(true);
    }

    @Test
    void fromD6ToF2isDiagonalFalse() {
        Cell position = Cell.D6;
        Cell destination = Cell.F2;
        BishopBlack bishopBlack = new BishopBlack(position);
        assertThat(bishopBlack.isDiagonal(bishopBlack.position(), destination)).isEqualTo(false);
    }
}