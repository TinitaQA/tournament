import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void secondPlayerIsNotRegistered() { // второй игрок не зарегистрирован
        Game game = new Game();

        Player player1 = new Player(1, "Тинита", 5_000);

        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Тинита", "Лина");
        });
    }

    @Test
    public void firstPlayerIsNotRegistered() { // первый игрок не зарегистрирован
        Game game = new Game();

        Player player2 = new Player(2, "Лина", 7_000);

        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Тинита", "Лина");
        });
    }

    @Test
    public void noOneIsRegistered() {  // никто не зарегистрирован
        Game game = new Game();

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Тинита", "Лина");
        });
    }

    @Test
    public void firstPlayerWins() { // // первый игрок выиграл
        Game game = new Game();

        Player player1 = new Player(1, "Тинита", 7_000);
        Player player2 = new Player(2, "Лина", 5_000);

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Тинита", "Лина");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondPlayerWins() { // второй игрок выиграл
        Game game = new Game();

        Player player1 = new Player(1, "Тинита", 5_000);
        Player player2 = new Player(2, "Лина", 7_000);

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Тинита", "Лина");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void drawBetweenThePlayers() { // ничья
        Game game = new Game();

        Player player1 = new Player(1, "Тинита", 7_000);
        Player player2 = new Player(2, "Лина", 7_000);

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Тинита", "Лина");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPlayerGetId() { // геттер
        Player player = new Player(1, "Player 1", 10);

        int expected = 1;
        int actual = player.getId();

        Assertions.assertEquals(expected, actual);
    }
}
