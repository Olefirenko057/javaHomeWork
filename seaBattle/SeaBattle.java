package lesson5.seaBattle;

public class SeaBattle {

    public static void main(String[] args) {

        Field field = new Field();
        field.repaint();
        System.out.println(field.getShips().get(1).getDecks());

        Game game = new Game();
        game.placingShips(field.getField());
    }
}
