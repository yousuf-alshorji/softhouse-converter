import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Line {

    public static int getNumberOfParts(String line) {
        Pattern pattern = Pattern.compile("([^|]+)");
        Matcher matcher = pattern.matcher(line);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
