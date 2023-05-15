package seminar3.OwnExceptions;

/**
 * Исключение некорректного формата пола
 */
public class GenderFormatException extends Exception {
    private final String userGender;

    public String getUserGender() {
        return userGender;
    }

    /**
     * Исключение некорректного формата пола
     *
     * @param message    сообщение, указывающее на ошибку
     * @param userGender введенный пользователем пол неверного формата
     */
    public GenderFormatException(String message, String userGender) {
        super(message);
        this.userGender = userGender;
    }
}
