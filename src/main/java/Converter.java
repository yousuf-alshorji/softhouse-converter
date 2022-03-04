import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Converter {
    public void convert(File source, String outputPath) throws FileNotFoundException {
        Map<String, List<String>> linesByPerson;
        Scanner scanner = new Scanner(source);
        linesByPerson = getLinesByPerson(scanner);
        scanner.close();
        PeopleRegister peopleRegister = parsePeopleRegister(linesByPerson);

        jaxbObjectToXML(peopleRegister, outputPath);

    }

    public PeopleRegister parsePeopleRegister(Map<String, List<String>> linesByPerson) {
        PeopleRegister peopleRegister = new PeopleRegister();
        linesByPerson.forEach((key, value) -> peopleRegister.getPeople().add(Parser.parse(key, value)));
        return peopleRegister;
    }

    public Map<String, List<String>> getLinesByPerson(Scanner scanner) {
        Map<String, List<String>> linesByPerson = new HashMap<>();
        String previousPerson = null;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.startsWith("P")) {
                previousPerson = String.valueOf(UUID.randomUUID());
                linesByPerson.put(previousPerson, Collections.singletonList(line));
            } else {
                if (linesByPerson.containsKey(previousPerson)) {
                    List<String> personsLines = new ArrayList<>(linesByPerson.get(previousPerson));
                    personsLines.add(line);
                    linesByPerson.put(previousPerson, personsLines);
                }
            }
        }
        return linesByPerson;
    }

    public void jaxbObjectToXML(PeopleRegister peopleRegister, String outputPath) {
        try {
            //Create JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(PeopleRegister.class);

            //Create Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            //Required formatting
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Store XML to File
            File file = new File(outputPath);

            //Writes XML file to file-system
            jaxbMarshaller.marshal(peopleRegister, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

