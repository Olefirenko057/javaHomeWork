package lesson5.seaBattle;

import java.util.ArrayList;
import java.util.List;

public class Field {

    private char[][] field;
    private char emptyCell = '.';
    private char shipCell = 'O';
    private char destroyedShip = 'X';
    private char missedShotSell = '*';
    private List<Ship> ships = new ArrayList<>(10);

    public Field() {
        field = new char[10][10];
        init();
        settingShips();
    }

    private void init() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = emptyCell;
            }
        }

    }

    public void repaint() {
        for(char[] row : field) {
            for(char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    private void settingShips() {
        ships.add(new Ship(1));
        ships.add(new Ship(1));
        ships.add(new Ship(1));
        ships.add(new Ship(1));
        ships.add(new Ship(2));
        ships.add(new Ship(2));
        ships.add(new Ship(2));
        ships.add(new Ship(3));
        ships.add(new Ship(3));
        ships.add(new Ship(4));
    }

    public char[][] getField() {
        return field;
    }

    public void setField(char[][] field) {
        this.field = field;
    }

    public char getEmptyCell() {
        return emptyCell;
    }

    public char getShipCell() {
        return shipCell;
    }

    public char getDestroyedShip() {
        return destroyedShip;
    }

    public char getMissedShotSell() {
        return missedShotSell;
    }

    public List<Ship> getShips() {
        return ships;
    }
}
