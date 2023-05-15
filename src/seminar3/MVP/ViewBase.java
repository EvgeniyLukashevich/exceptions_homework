package seminar3.MVP;

import seminar3.Models.Person;

/**
 * Базовый интерфейс вью, содержащий абстрактные методы.
 * Создан, чтобы не переписывать код готового вью
 * и относительно быстро создать новый вью,
 * в случае необходимости изменения логики или содержания методов
 */
public interface ViewBase {

    /**
     * Метод приема вводимых пользователем данных.
     *
     * @return введенные данные в виде строки.
     */
    abstract String userInput();

    /**
     * Метод вывода главного меню.
     */
    abstract void showMainMenu();

    /**
     * Метод вывода первого сообщения пользователю при вводе данных.
     */
    abstract void showAddPersonFirst();

    /**
     * Метод вывода последнего сообщения пользователю при вводе данных.
     */
    abstract void showAddPersonFinal();

    /**
     * Метод вывода списка существующих данных.
     *
     * @param personList массив экземпляров класса Person.
     */
    abstract void showPersonList(Person[] personList);

    /**
     * Метод вывода сообщения о повторной попытке ввода
     */
    abstract void showAnotherTry();

    /**
     * Метод вывода сообщений об ошибке.
     *
     * @param e             экземпляр класса исключения.
     * @param messageToUser сообщение пользователю.
     * @param userInput     некорректные вводимые пользователем данные.
     */
    abstract void showErrorMessage(Exception e, String messageToUser, String userInput);

    abstract void showExitMessage();
}
