package seminar3.MVP;

import seminar3.OwnExceptions.*;

/**
 * Базовый интерфейс модели, содержащий абстрактные методы.
 * Создан, чтобы не переписывать код готовой модели
 * и относительно быстро создать новую модель,
 * в случае необходимости изменения логики методов
 */
interface ModelBase {
    /**
     * Метод провеки строки на предмет корректного количества данных
     *
     * @param userLine введенная пользователем строка
     * @return Массив строк, полученный путём разделения входящей строки по пробелу
     * @throws LineSizeException в случае некорректного количества данных в строке
     */
    abstract String[] lineCheck(String userLine) throws LineSizeException;

    /**
     * Метод проверки корректности формата даты
     *
     * @param dateOfBirth введенная пользователем дата
     * @return Дата корректного формата
     * @throws DateFormatException в случае неверного формата введенной даты
     */
    abstract String dateCheck(String dateOfBirth) throws DateFormatException;

    /**
     * Метод проверки корректности формата введенного пола
     *
     * @param gender введенный пользователем пол
     * @return Пол корректного формата, преобразованный в тип char
     * @throws GenderFormatException в случае неверного формата введенного пола
     */
    abstract char genderCheck(String gender) throws GenderFormatException;

    /**
     * Метод проверки корректности формата введенного номера телефона
     *
     * @param phoneNumber введенный пользователем номер телефона
     * @return Номер телефона корректного формата, преобразованный в тип Long
     * @throws PhoneFormatException в случае неверного формата введенного номера телефона
     *                              (отличная от 10ти длина номера или наличие иных символов, помимо цифр)
     */
    abstract Long phoneNumberCheck(String phoneNumber) throws PhoneFormatException;

    /**
     * Метод проверки корректности формата введенных Фамилии, Имени или Отчества
     *
     * @param anyName введенная пользователем Фамилия, Имя или Отчество
     * @return Строка Фамилии, Имени или Отчества корректного формата
     * @throws NameFormatException в случае неверного формта введенной Фамилии, Имени или Отчества
     */
    abstract String anyNameCheck(String anyName) throws NameFormatException;
}
