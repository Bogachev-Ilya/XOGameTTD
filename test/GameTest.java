import org.junit.*;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;

public class GameTest {

    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
        game.initCells();
    }

    @Test
    public void testArrayUs1() {
        assertEquals(Game.SIZE, game.getCells().length);
        assertEquals(Game.SIZE, game.getCells()[0].length);
    }

    @Test
    public void testInitUs2() {
        for (int i = 0; i < Game.SIZE; i++) {
            for (int j = 0; j < Game.SIZE; j++) {
                assertEquals('.', game.getCharAtPoint(new Point(i, j)));

            }
        }
    }

    @Test
    public void testIsWin_X_First_Row() {
        game.setShootPoint(new Point(0, 0), 'X');
        game.setShootPoint(new Point(1, 0), 'X');
        game.setShootPoint(new Point(2, 0), 'X');
        assertEquals(Game.Status.X_WIN, game.getGameStatus());
    }

    @Test
    public void testIsWin_Y_First_Row() {
        game.setShootPoint(new Point(0, 0), 'X');
        game.setShootPoint(new Point(0, 1), 'X');
        game.setShootPoint(new Point(0, 2), 'X');
        assertEquals(Game.Status.X_WIN, game.getGameStatus());
    }

    @Test
    public void testSetShootPoint() {
        Point point = new Point(1, 0);
        char x = 'X';
        game.setShootPoint(point, x);
        assertEquals(x, game.getCharAtPoint(point));
    }

    @Test
    public void testGetFieldForOutput() {
        String field = ". . .\n. . .\n. . .\n";
        assertEquals(field, game.getFieldForOutput());
    }

    @Test
    public void testGetFieldForOutputWithOneStep() {
        Point point = new Point(1, 0);
        char x = 'X';
        game.setShootPoint(point, x);
        String field = ". X .\n. . .\n. . .\n";
        assertEquals(field, game.getFieldForOutput());

    }

    @Test
    public void testShootOnlyOnEmptyCell() {
        Point point = new Point(1, 0);
        char x = 'X';
        boolean result;
        result = game.setShootPoint(point, x);
        assertTrue(result);
        result = game.setShootPoint(point, x);
        assertFalse(result);
    }

    @Test
    public void testDraw() {
        char[][] cells = {{'X', 'O', 'X'}, {'O', 'O', 'X'}, {'X', 'X', 'O'}};
        for (int i = 0; i < Game.SIZE; i++) {
            for (int j = 0; j < Game.SIZE; j++) {
                game.setShootPoint(new Point(j, i), cells[j][i]);
            }
        }
        assertEquals(Game.Status.DRAW, game.getGameStatus());


    }

    @Test
    public void testGameStart() throws UnsupportedEncodingException, FileNotFoundException {
        String mockInputForUser1 = "0 0\n1 0\n2 0\n";
        String mockInputForUser2 = "1 1\n1 2\n2 2\n";
        InputStream mockinputStream1 = new ByteArrayInputStream(mockInputForUser1.getBytes(StandardCharsets.UTF_8.name()));
        InputStream mockinputStream2 = new ByteArrayInputStream(mockInputForUser2.getBytes(StandardCharsets.UTF_8.name()));
        ConsoleShootStrategy consoleShootStrategy1 = new ConsoleShootStrategy(mockinputStream1);
        ConsoleShootStrategy consoleShootStrategy2 = new ConsoleShootStrategy(mockinputStream2);

        User user1 = new User(consoleShootStrategy1, 'X');
        User user2 = new User(consoleShootStrategy2, 'O');

        game.setUser1(user1);
        game.setUser2(user2);

        game.initCells();
        game.start();

        assertEquals(Game.Status.X_WIN, game.getGameStatus());
    }

}