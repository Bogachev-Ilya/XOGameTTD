import java.io.IOException;
import java.io.OutputStream;

public class ConsoleOutputStream extends OutputStream {
    private OutputStream outputStream;

    @Override
    public void write(int b) throws IOException {
        System.out.println(b);
    }

    @Override
    public void write(byte[] b, int off, int len) {

    }

    @Override
    public void write(byte[] b) {
        System.out.println(new String(b));
    }

    public String testOutPutStream(String s) {
        return s;
    }

    public ConsoleOutputStream(String s) {
        testOutPutStream(s);
    }
}
