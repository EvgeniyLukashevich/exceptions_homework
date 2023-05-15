package seminar3.MVP;

import seminar3.OwnExceptions.*;

import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Дочерний класс интерфейса ModelBase
 */
public class ModelFirst implements ModelBase {

    public static void main(String[] args) {
        ModelFirst model = new ModelFirst();
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);

                System.out.print("DATE: ");
                String date = sc.nextLine();
                String date1 = model.dateCheck(date);
                System.out.println("Ваша дата рождения: " + date1);

                System.out.print("GENDER: ");
                String gender = sc.nextLine();
                char gender1 = model.genderCheck(gender);
                System.out.println("Ваш пол: " + gender1);

                System.out.print("NUMBER: ");
                String n = sc.nextLine();
                Long n1 = model.phoneNumberCheck(n);
                System.out.println("Ваш номер: " + n1);

                System.out.print("NAME: ");
                String name = sc.nextLine();
                String name1 = model.anyNameCheck(name);
                System.out.println("Вашу имя: " + name1);


                return;

            } catch (DateFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Формат введенной даты некорректен: " + e.getUserDate());
            } catch (GenderFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Формат введенного пола некорректен: " + e.getUserGender());
            } catch (PhoneFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Формат введенного номера некорректен: " + e.getPhoneNumber());
            } catch (NameFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Формат введенного имени некорректен: " + e.getAnyName());
            }
        }

    }

    @Override
    public String[] lineCheck(String userLine) throws LineSizeException {
        // Делим строку (пробел - разделитель) и записываем в массив
        String[] data = userLine.split(" ");
        // Проверка на количество данных
        if (data.length != 6)
            throw new LineSizeException("Количество данных не соответствует необходимому количеству", String.join(" ", userLine));
        return data;
    }

    @Override
    public String dateCheck(String dateOfBirth) throws DateFormatException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setLenient(false);
        // Пытаемся распарсить дату, в случае успехе -
        // возвращаем дату в формате строки
        try {
            dateFormat.parse(dateOfBirth);
            return dateOfBirth;
            // В случае неудачи - бросаем соответствующее исключение
        } catch (Exception e) {
            throw new DateFormatException(
                    "Корректный формат даты: 'dd.mm.yyyy'.",
                    dateOfBirth);
        }
    }

    @Override
    public char genderCheck(String gender) throws GenderFormatException {
        // Если введена подходящая буква, возвращаем её в формате char
        if (gender.equals("m") || gender.equals("M"))
            return 'm';
        else if (gender.equals("f") || gender.equals("F"))
            return 'f';
            // В противном случае бросаем исключение
        else
            throw new GenderFormatException(
                    "Необходимо ввести: m (мужской пол) или f (женский пол).",
                    gender);
    }

    @Override
    public Long phoneNumberCheck(String phoneNumber) throws PhoneFormatException {
        // Проверка на верное количество цифр в номере
        if (phoneNumber.length() != 10)
            throw new PhoneLengthException(
                    "Номер телефона должен состоять из десяти цифр (без пробелов).",
                    phoneNumber);
        // Проверка на наличие запрещенных символов в номере
        for (char symbol : phoneNumber.toCharArray())
            if (!Character.isDigit(symbol))
                throw new PhoneSymbolException(
                        "В номере телефона не должно содержаться других символов, кроме цифр.",
                        phoneNumber);
        // Возвращаем номер в целочисленном формате Long
        return Long.parseLong(phoneNumber);
    }

    @Override
    public String anyNameCheck(String anyName) throws NameFormatException {
        // Проверяем, чтобы в Ф/И/О не было ненужных символов
        if (!anyName.matches("^[a-zA-Zа-яА-Я\\-]+$"))
            throw new NameFormatException(
                    "Фамилия/Имя/Отчество может содержать только буквы, либо дефис.",
                    anyName);
        // Делаем 1ую букву заглавной, остальные - строчными и возвращаем готовую строку
        return anyName.substring(0, 1).toUpperCase() + anyName.substring(1).toLowerCase();
    }

}
