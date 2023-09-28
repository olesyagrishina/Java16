package game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testWhenPlayer1Win() {
        Player max = new Player(1, "Макс", 10);
        Player stas = new Player(2, "Стас", 9);
        Game game = new Game();
        game.register(stas);
        game.register(max);
        int expected = 1;
        int actual = game.round("Макс", "Стас");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenPlayer2Win() {
        Player max = new Player(1, "Макс", 1);
        Player stas = new Player(2, "Стас", 9);
        Game game = new Game();
        game.register(stas);
        game.register(max);
        int expected = 2;
        int actual = game.round("Макс", "Стас");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenDrawnGame() {
        Player max = new Player(1, "Макс", 1);
        Player stas = new Player(2, "Стас", 1);
        Game game = new Game();
        game.register(stas);
        game.register(max);
        int expected = 0;
        int actual = game.round("Макс", "Стас");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenPlayer1NotExist() {
        Player max = new Player(1, "Макс", 1);
        Player stas = new Player(2, "Стас", 1);
        Game game = new Game();
        game.register(stas);
        game.register(max);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Вася", "Стас"));
    }

    @Test
    public void testWhenPlayer2NotExist() {
        Player max = new Player(1, "Макс", 1);
        Player stas = new Player(2, "Стас", 1);
        Game game = new Game();
        game.register(stas);
        game.register(max);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Макс", "Вася"));
    }
}
