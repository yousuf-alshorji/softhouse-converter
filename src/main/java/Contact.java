import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {
    private String mobile;
    private String landline;

    public Contact(String mobile, String landline) {
        this.mobile = mobile;
        this.landline = landline;
    }

    public Contact() {

    }

    public static Contact parse(String line) {
        Pattern pattern = Pattern.compile("([^|]+)");
        Matcher matcher = pattern.matcher(line);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        Contact contact;
        String[] splitContact = line.split("\\|");
        switch (count) {
            case 2 -> contact = new Contact(splitContact[1], null);
            case 3 -> contact = new Contact(splitContact[1], splitContact[1]);
            default -> contact = new Contact();
        }
        return contact;

    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    @Override
    public String toString() {
        return "Contact{" + "mobile='" + mobile + '\'' + ", landline='" + landline + '\'' + '}';
    }
}
