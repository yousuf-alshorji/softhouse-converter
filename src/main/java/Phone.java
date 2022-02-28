public class Phone extends Line {
    private String mobile;
    private String landline;

    public Phone(String mobile, String landline) {
        this.mobile = mobile;
        this.landline = landline;
    }

    public Phone() {

    }

    public static Phone parse(String line) {
        Phone phone;
        String[] splitContact = line.split("\\|");
        switch (getNumberOfParts(line)) {
            case 2:
                phone = new Phone(splitContact[1], null);
                break;
            case 3:
                phone = new Phone(splitContact[1], splitContact[1]);
                break;
            default:
                phone = new Phone();
                break;
        }
        return phone;

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
