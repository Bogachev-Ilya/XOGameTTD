import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;

public class UserTest {

    private User user;


    @Test
    public void testGetShootPoint() {
        user = new User(new MockShootStrategy(), 'X');
        assertEquals(new Point(0, 0), user.getShootPoint());
    }

    @Test
    public void testConsoleInputStrategy() throws UnsupportedEncodingException {
        String mockInput = "0 0\n0 1\n0 2\n";
        InputStream mockinputStream = new ByteArrayInputStream(mockInput.getBytes(StandardCharsets.UTF_8.name()));
        ConsoleShootStrategy consoleShootStrategy = new ConsoleShootStrategy(mockinputStream);
        assertEquals(new Point(0, 0), consoleShootStrategy.getShootPoint());
        assertEquals(new Point(0, 1), consoleShootStrategy.getShootPoint());
        assertEquals(new Point(0, 2), consoleShootStrategy.getShootPoint());

    }
}