package seminar3.MVP;

import seminar3.Models.Person;

import java.util.Scanner;

/**
 * Дочерний класс интерфейса ViewBase, ориентированный на работу в консоли
 */
public class ViewConsole implements ViewBase {
    private String mainMenu =
            "\n# # # # # # # # # # # # # # # # # # # # # # # # #\n" +
                    "1 - Ввести данные\n" +
                    "2 - Вывести данные\n" +
                    "Any other key - Выход\n" +
                    "Выберите нужный пункт меню: ";
    private String addPersonFirst =
            "\nФормат данных: Фамилия Имя Отчество датаРождения номерТелефона пол\n" +
                    "Пример ввода: Иванов Иван Иванович 12.12.1990 8800123456 m\n" +
                    "Введите данные: ";
    private String addPersonFinal =
            "Данные успешно записаны!\n\n";
    private String anotherTry = "Попробуйте снова.";
    private String exitMessage = "\n\nВсего доброго!";

    @Override
    public String userInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    @Override
    public void showMainMenu() {
        System.out.println(this.mainMenu);
    }

    @Override
    public void showAddPersonFirst() {
        System.out.println(this.addPersonFirst);
    }

    @Override
    public void showAddPersonFinal() {
        System.out.println(this.addPersonFinal);
    }

    @Override
    public void showPersonList(Person[] personList) {
        String text = "\n";
        for (Person person : personList) {
            text += "Фамилия: " + person.getLastName()
                    + "\nИмя: " + person.getFirstName()
                    + "\nОтчество: " + person.getMiddleName()
                    + "\nДата рождения: " + person.getDateOfBirth()
                    + "\nНомер телефона: " + person.getPhoneNumber()
                    + "\nПол: " + person.getGender() + "\n\n";
        }
        System.out.println(text);
    }

    @Override
    public void showErrorMessage(Exception e, String messageToUser, String userInput) {
        System.out.println(e.getMessage());
        System.out.println(messageToUser + userInput);
    }

    @Override
    public void showAnotherTry() {
        System.out.println(this.anotherTry);
    }

    @Override
    public void showExitMessage() {
        System.out.println(this.exitMessage);
    }
}
