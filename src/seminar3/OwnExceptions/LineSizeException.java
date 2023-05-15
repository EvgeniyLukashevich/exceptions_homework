package seminar3.OwnExceptions;

/**
 * Исключение неверного количества данных в введенной строке
 */
public class LineSizeException extends Exception {
    String userLine;

    public String getUserLine() {
        return userLine;
    }

    public LineSizeException(String message, String userLine) {
        super(message);
        this.userLine = userLine;
    }
}
