package seminar3.Models;

/**
 * Класс, содержащий в себе такие данные человека, как:
 * Фамилия(String); Имя(String); Отчество(String);
 * дата рождения(String); номер телефона(Integer); пол(char).
 * Для заполнения полей и "сборки" класса реализован статический подкласс Builder
 */
public class Person {
    private String lastName;
    private String firstName;
    private String middleName;
    private String dateOfBirth;
    private long phoneNumber;
    private char gender;

    private Person() {
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public Long getPhoneNumber() {
        return this.phoneNumber;
    }

    public char getGender() {
        return this.gender;
    }

    /**
     * Класс, позволяющий удобно заполнить поля и "построить" класс Person,
     * что даёт возможность сделать конструктор класса Person приватным
     * (в данной работе, последнее - не очень важно. Но иногда бывает полезно :)
     */
    public static class Builder {
        private String lastName = "Неизвестно";
        private String firstName = "Неизвестно";
        private String middleName = "Неизвестно";
        private String dateOfBirth = "-1.-1.-1";
        private Long phoneNumber = (long) -1;
        private char gender = '-';

        public Person build() {
            Person person = new Person();
            person.lastName = this.lastName;
            person.firstName = this.firstName;
            person.middleName = this.middleName;
            person.dateOfBirth = this.dateOfBirth;
            person.phoneNumber = this.phoneNumber;
            person.gender = this.gender;
            return person;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder setPhoneNumber(Long phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setGender(char gender) {
            this.gender = gender;
            return this;
        }
    }
}
