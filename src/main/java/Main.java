import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        new Converter().convert(new File(args[0]), args[1]);
    }
}
