import java.io.InputStream;
import java.util.Scanner;

public class ConsoleShootStrategy implements ShootStrategy {
    private InputStream inputStream;
    private Scanner scanner;

    public ConsoleShootStrategy() {
        this(System.in);
    }

    public ConsoleShootStrategy(InputStream inputStream) {
        this.inputStream = inputStream;
        scanner = new Scanner(inputStream);
    }

    @Override
    public Point getShootPoint() {
        while (true) {
            String s = scanner.nextLine();
            String[] split = s.split(" ");
            if (Integer.valueOf(split[0]) > 2 || Integer.valueOf(split[0]) < 0 || Integer.valueOf(split[1]) > 2 || Integer.valueOf(split[1]) < 0) {
                System.out.println("The cell is not exist, put number from 0 to 2 with space");
                continue;
            }
            return new Point(Integer.valueOf(split[0]), Integer.valueOf(split[1]));
        }

    }
}
