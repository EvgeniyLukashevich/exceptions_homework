package seminar2;

import java.util.Random;
import java.util.Scanner;

/**
 * Task 1
 * Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
 * и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
 * вместо этого, необходимо повторно запросить у пользователя ввод данных.
 */
public class Task1 {
    public static void main(String[] args) {
        task();
    }


    /**
     * Пробуем применить метод запроса и возврата вещественного числа.
     * При этом обрабатываем исключение, выбрасываемое методом при вводе невалидных данных.
     * Также, добавил ещё один блок catch, обрабатывающий всевозможные исключения.
     * Им тут взяться особо неоткуда, но, если это правила хорошего тона, то почему бы и нет :)
     */
    static void task() {
        while (true) {
            try {
                System.out.println("Вещественное число принято: "
                        + takeGiveFloatNumber());
                return;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Попробуйте снова.\n");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Что-то пошло не так.\n");
            }
        }
    }

    /**
     * Метод запрашивает у пользователя ввод вещественного числа.
     * В случае валидности вводимых данных возвращает число.
     * В противном случае бросает исключение
     *
     * @return Вещественное число типа float
     */
    public static float takeGiveFloatNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите вещественное число: ");
        if (!scanner.hasNextFloat()) {
            throw new NumberFormatException("Неверный формат вводимых данных.");
        } else {
            return scanner.nextFloat();
        }
    }

}
