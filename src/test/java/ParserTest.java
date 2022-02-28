import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    private final Converter converter = new Converter();

    @Test
    public void parsePeopleRegister() throws FileNotFoundException {
        // given
        File file = readFile("happyPath");
        Map<String, List<String>> informationByPerson = converter.getInformationByPerson(new Scanner(file));

        // when
        PeopleRegister peopleRegister = converter.parsePeopleRegister(informationByPerson);

        // then
        assertEquals(3, peopleRegister.getPeople().size());
    }

    @Test
    public void parsePeopleRegisterWithDuplicateNamesParseAsDifferentPersons() throws FileNotFoundException {
        // given
        File file = readFile("duplicateNames");
        Map<String, List<String>> informationByPerson = converter.getInformationByPerson(new Scanner(file));

        // when
        PeopleRegister peopleRegister = converter.parsePeopleRegister(informationByPerson);

        // then
        assertEquals(3, peopleRegister.getPeople().size());
    }

    @Test
    public void parsePeopleRegisterWithWrongPersonNameShouldStillParseValidData() throws FileNotFoundException {
        // given
        File file = readFile("wrongPersonName");
        Map<String, List<String>> informationByPerson = converter.getInformationByPerson(new Scanner(file));

        // when
        PeopleRegister peopleRegister = converter.parsePeopleRegister(informationByPerson);

        // then
        assertEquals(2, peopleRegister.getPeople().size());
    }

    @Test(expected = FileNotFoundException.class)
    public void fileNotFoundThrowsException() throws FileNotFoundException {
        // when
        converter.convert(new File("test"));
    }

    @Test
    public void convertHappyPath() throws FileNotFoundException {
        // given
        File file = readFile("happyPath");

        // when
        converter.convert(file);
    }

    @Test
    public void convertFileContainingInformationWithoutPersonLine() throws FileNotFoundException {
        // given
        File file = readFile("fileWithoutPerson");

        // when
        converter.convert(file);
    }


    public File readFile(String fileName) {
        String pathString = "src/test/resources";
        File file = new File(pathString);
        String absolutePath = file.getAbsolutePath();
        Path path = Path.of(absolutePath + "/" + fileName + ".txt");
        return path.toFile();
    }
}