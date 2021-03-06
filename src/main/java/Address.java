import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "address")
@XmlAccessorType(XmlAccessType.FIELD)
public class Address extends Line {
    private String street;
    private String city;
    private String zip;

    public Address(String street, String city, String zip) {
        this.street = street;
        this.city = city;
        this.zip = zip;
    }

    public Address() {
    }

    public static Address parse(String line) {
        Address address;
        String[] splitAddress = line.split("\\|");
        switch (getNumberOfParts(line)) {
            case 2:
                address = new Address(splitAddress[1], null, null);
                break;
            case 3:
                address = new Address(splitAddress[1], splitAddress[2], null);
                break;
            case 4:
                address = new Address(splitAddress[1], splitAddress[2], splitAddress[3]);
                break;
            default:
                address = new Address();
                break;
        }
        return address;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Address{" + "street='" + street + '\'' + ", city='" + city + '\'' + ", zip='" + zip + '\'' + '}';
    }
}
