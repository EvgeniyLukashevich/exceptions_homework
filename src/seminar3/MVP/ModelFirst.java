package seminar3.MVP;

import seminar3.OwnExceptions.*;

import java.text.SimpleDateFormat;


/**
 * Дочерний класс интерфейса ModelBase
 */
public class ModelFirst implements ModelBase {

    @Override
    public String[] lineCheck(String userLine) throws LineSizeException {
        // Делим строку (пробел - разделитель) и записываем в массив
        String[] data = userLine.split(" ");
        // Проверка на количество данных
        if (data.length != 6)
            throw new LineSizeException(
                    "Количество данных не соответствует необходимому количеству",
                    String.join(" ", userLine)
            );
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
