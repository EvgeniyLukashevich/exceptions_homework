package seminar3.OwnExceptions;

import java.text.ParseException;

/**
 * Исключение некорректного формата даты
 */
public class DateFormatException extends ParseException {
    private final String userDate;

    public String getUserDate() {
        return userDate;
    }

    /**
     * Исключение некорректного формата даты
     *
     * @param message  сообщение, указывающее на ошибку
     * @param userDate введенная пользователем дата неверного формата
     */
    public DateFormatException(String message, String userDate) {
        super(message, 0);
        this.userDate = userDate;
    }

}
