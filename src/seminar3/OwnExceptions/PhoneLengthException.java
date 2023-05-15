package seminar3.OwnExceptions;

/**
 * Исключение некорректной длины телефонного номера
 */
public class PhoneLengthException extends PhoneFormatException {
    public PhoneLengthException(String message, String phoneNumber) {
        super(message, phoneNumber);
    }
}
