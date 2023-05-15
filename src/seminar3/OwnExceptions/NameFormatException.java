package seminar3.OwnExceptions;

/**
 * Исключение некорректного формата Фамилии, Имени или Отчества
 */
public class NameFormatException extends Exception {
    String anyName;

    public String getAnyName() {
        return anyName;
    }

    public NameFormatException(String message, String anyName) {
        super(message);
        this.anyName = anyName;
    }
}
