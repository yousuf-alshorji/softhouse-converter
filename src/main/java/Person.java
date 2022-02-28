import jakarta.xml.bind.annotation.XmlTransient;

import java.util.ArrayList;
import java.util.List;

public class Person extends Line {
    private String id;
    private String firstname;
    private String lastname;
    private Phone phone;
    private Address address;
    private List<Family> family = new ArrayList<>();

    public Person() {

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Family> getFamily() {
        return family;
    }

    public void setFamily(List<Family> family) {
        this.family = family;
    }

    @XmlTransient
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void parseName(String line) {
        String[] splitName = line.split("\\|");
        switch (getNumberOfParts(line)) {
            case 2:
                setFirstname(splitName[1]);
                break;
            case 3:
                setFirstname(splitName[1]);
                setLastname(splitName[2]);
                break;
        }

    }

    @Override
    public String toString() {
        return "Person{" + "id='" + id + '\'' + ", firstname='" + firstname + '\'' + ", lastname='" + lastname + '\'' + ", phone='" + phone + '\'' + ", address=" + address + ", family=" + family + '}';
    }
}
