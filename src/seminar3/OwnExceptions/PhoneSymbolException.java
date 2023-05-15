package seminar3.OwnExceptions;

/**
 * Исключение некорректных символов в телефонном номере
 */
public class PhoneSymbolException extends PhoneFormatException {
    public PhoneSymbolException(String message, String phoneNumber) {
        super(message, phoneNumber);
    }
}
