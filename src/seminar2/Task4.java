package seminar2;

import java.util.Scanner;

/**
 * Task 4
 * Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
 * Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
 */
public class Task4 {
    public static void main(String[] args) {
        task();
    }

    /**
     * Собираем задание.
     * Обработка исключений, возникающих при использовании метода ввода данных
     */
    static void task() {
        while (true) {
            try {
                System.out.println("Вы ввели: " + notEmptyInput() +
                        "\nРабота программы успешно завершена.");
                return;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Пустую строку вводить нельзя.\n");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Что-то пошло не так.\n");
            }
        }
    }

    /**
     * Метод, запрашивающий у пользователя ввести что-либо.
     * При отсутствии вводимых данных бросит исключение.
     * В противном случае вернёт введенные данные в формате строки
     *
     * @return Введенные пользователем данные
     */
    static String notEmptyInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Пожалуйста, введите что-нибудь: ");
        String userInput = scanner.nextLine();
        if (userInput.isEmpty())
            throw new RuntimeException("Отсутствуют входящие данные.");
        return userInput;
    }


}
