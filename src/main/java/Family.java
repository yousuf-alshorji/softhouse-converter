import jakarta.xml.bind.annotation.XmlTransient;

public class Family extends Line {
    private String id;
    private String name;
    private int birthYear;
    private Phone phone;
    private Address address;

    public Family() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @XmlTransient
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public void parseFamilyMemberNameAndBirthYear(String line) {
        String[] splitFamilyName = line.split("\\|");
        switch (getNumberOfParts(line)) {
            case 2:
                setName(splitFamilyName[1]);
                break;
            case 3:
                setName(splitFamilyName[1]);
                setBirthYear(Integer.parseInt(splitFamilyName[2]));
                break;
        }
    }

    @Override
    public String toString() {
        return "Family{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", birthYear=" + birthYear + ", address=" + address + '}';
    }

}
