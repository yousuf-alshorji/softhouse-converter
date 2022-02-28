import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Parser {
    public static Person parse(String lineId, List<String> personInfo) {
        List<String> linesToRemove = new ArrayList<>();
        Person person = new Person();

        AtomicBoolean ongoing = new AtomicBoolean(true);
        personInfo.stream().takeWhile(t -> ongoing.get()).forEach(line -> {
            person.setId(lineId);
            if (line.startsWith("P")) {
                person.parseName(line);
            } else if (line.startsWith("A")) {
                person.setAddress(Address.parse(line));
                linesToRemove.add(line);
            } else if (line.startsWith("T")) {
                person.setContact(Contact.parse(line));
                linesToRemove.add(line);
            } else {
                ongoing.set(false);
            }
        });
        personInfo.removeAll(linesToRemove);

        handleFamilyMembers(personInfo, person);

        return person;
    }

    private static void handleFamilyMembers(List<String> personInfo, Person person) {
        var ref = new Object() {
            Family family = null;
        };
        personInfo.forEach(line -> {
            if (line.startsWith("F")) {
                ref.family = new Family();
                ref.family.setId(line);
                ref.family.parseFamilyMemberNameAndBirthYear(line);
                person.getFamily().add(ref.family);
            } else if (line.startsWith("A")) {
                ref.family.setAddress(Address.parse(line));
            } else if (line.startsWith("T")) {
                ref.family.setContact(Contact.parse(line));
            }
        });
    }
}
