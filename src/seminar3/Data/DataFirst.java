package seminar3.Data;

import seminar3.Models.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Дочерний от BaseData класс, реализующий логику записи/чтения файлов
 */
public class DataFirst implements BaseData {
    String dataPath = "src/seminar3/database/";
    char delimiter = '_';

    @Override
    public void dataIn(Person person) throws IOException {
        String filePath = dataPath + person.getLastName() + ".txt";
        try {
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(person.getLastName() + delimiter +
                    person.getFirstName() + delimiter +
                    person.getMiddleName() + delimiter +
                    person.getDateOfBirth() + delimiter +
                    person.getPhoneNumber() + delimiter +
                    person.getGender() + "\n");
            writer.close();
        } catch (IOException e) {
            throw new IOException(
                    "В методе dataIn класса DataFirst произошла ошибка записи данных в файл " + filePath
            );
        }
    }

    @Override
    public Person[] dataOut() throws IOException {
        List<Person> personList = new ArrayList<>();
        File dir = new File(dataPath);
        File[] files = dir.listFiles();
        for (File file : files) {
            try (BufferedReader read = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = read.readLine()) != null) {
                    String[] data = line.split(String.valueOf(delimiter));
                    Person person = new Person.Builder().setLastName(data[0])
                            .setFirstName(data[1]).setMiddleName(data[2])
                            .setDateOfBirth(data[3]).setPhoneNumber(Long.parseLong(data[4]))
                            .setGender(data[5].charAt(0)).build();
                    personList.add(person);
                }
            } catch (Exception e) {
                throw new IOException(
                        "В методе dataOut класса DataFirst произошла ошибка чтения данных из файла "
                                + dataPath + file.getName()
                );
            }
        }
        return personList.toArray(new Person[personList.size()]);
    }
}
