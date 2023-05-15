package seminar3.OwnExceptions;

/**
 * Абстрактный класс, являющийся родительским для
 * PhoneSymbolException и PhoneLengthException
 */
public abstract class PhoneFormatException extends Exception {
    String phoneNumber;

    public PhoneFormatException(String message, String phoneNumber) {
        super(message);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }
}

