package seminar3.MVP;

import seminar3.Data.BaseData;
import seminar3.Models.Person;
import seminar3.OwnExceptions.*;

import java.io.IOException;

/**
 * Презентер, принимающий в конструктор базовые классы model, view и data,
 * для того, чтобы в последующем иметь возможность
 * использовать любые дочерние классы model, view и data
 */
public class Presenter {
    ModelBase model;
    ViewBase view;
    BaseData data;

    public Presenter(ModelBase model, ViewBase view, BaseData data) {
        this.model = model;
        this.view = view;
        this.data = data;
    }

    /**
     * Собираем программу
     */
    public void start() {
        while (true) {
            view.showMainMenu();
            String userInput = view.userInput();
            // Принимаем строку от пользователя
            if (userInput.equals("1")) {
                view.showAddPersonFirst();
                String userLine = view.userInput();
                try {
                    String[] userData = model.lineCheck(userLine);
                    userData[0] = model.anyNameCheck(userData[0]);
                    userData[1] = model.anyNameCheck(userData[1]);
                    userData[2] = model.anyNameCheck(userData[2]);
                    userData[3] = model.dateCheck(userData[3]);
                    Long userPhone = model.phoneNumberCheck(userData[4]);
                    char userGender = model.genderCheck(userData[5]);
                    Person person = new Person.Builder().setLastName(userData[0])
                            .setFirstName(userData[1]).setMiddleName(userData[2])
                            .setDateOfBirth(userData[3]).setPhoneNumber(userPhone)
                            .setGender(userGender).build();
                    data.dataIn(person);
                    view.showAddPersonFinal();
                } catch (LineSizeException e) {
                    view.showErrorMessage(e, "Некорректный ввод: ", e.getUserLine());
                    view.showAnotherTry();
                } catch (NameFormatException e) {
                    view.showErrorMessage(e, "Некорректный ввод Ф/И/О: ", e.getAnyName());
                    view.showAnotherTry();
                } catch (DateFormatException e) {
                    view.showErrorMessage(e, "Некорректный ввод даты: ", e.getUserDate());
                    view.showAnotherTry();
                } catch (PhoneFormatException e) {
                    view.showErrorMessage(e, "Некорректный ввод номера телефона: ", e.getPhoneNumber());
                    view.showAnotherTry();
                } catch (GenderFormatException e) {
                    view.showErrorMessage(e, "Некорректный ввод пола: ", e.getUserGender());
                    view.showAnotherTry();
                } catch (IOException e) {
                    view.showErrorMessage(e, "Данные не были записаны. ",
                            "Необходимо повторить попытку.");
                    view.showAnotherTry();
                } catch (Exception e) {
                    view.showErrorMessage(e, "Непредвиденная ошибка. ",
                            "Произошло страшное.");
                    view.showAnotherTry();
                }
                // Выводим имеющиеся данные
            } else if (userInput.equals("2")) {
                try {
                    view.showPersonList(data.dataOut());
                } catch (IOException e) {
                    view.showErrorMessage(e, "Данные не были прочитаны. ",
                            "Необходимо повторить попытку.");
                    view.showAnotherTry();
                }
                // Выход
            } else {
                view.showExitMessage();
                return;
            }
        }
    }
}
