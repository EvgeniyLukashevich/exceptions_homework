package seminar3.Data;

import seminar3.Models.Person;

import java.io.IOException;

/**
 * Базовый интерфейс, содержащий абстрактные методы записи/чтения файлов
 */
public interface BaseData {
    /**
     * Метод записи данных
     *
     * @param person экземпляр класса Person
     * @throws IOException в случае ошибки в процессе записи данных в файл
     */
    abstract void dataIn(Person person) throws IOException;

    /**
     * Метод чтения данных из файла
     *
     * @return массив экземпляров класса Person
     * @throws IOException в случае ошибки в процессе чтения данных из файла
     */
    abstract Person[] dataOut() throws IOException;
}
