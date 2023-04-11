package seminar1;

import java.util.Random;
import java.util.Scanner;

public class FirstHomework {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        homework();
    }


    // Собираем ДЗ
    static void homework() {
        String menu = "\n\n#############################\n" +
                "1 - Задание 1. Разность элементов целочисленных массивов\n" +
                "2 - Задание 2. Деление элементов целочисленных массивов\n" +
                "0 - Выход\n\n" +
                "Выберите пункт меню: ";
        while (true) {
            System.out.println(menu);
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice == 1)
                    Task1();
                else if (choice == 2)
                    Task2();
                else if (choice == 0) {
                    System.out.println("Всего доброго! :)");
                    return;
                } else
                    System.out.println("Пожалуйста, введите нужный пункт меню.");
            } else {
                System.out.println("Ошибка ввода данных.\nПопробуйте снова.");
                scanner.nextLine();
            }
        }
    }

    /*
    Task 1
    Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
    и возвращающий новый массив, каждый элемент которого равен разности элементов
    двух входящих массивов в той же ячейке.
    Если длины массивов не равны, необходимо как-то оповестить пользователя.
    */

    // Собираем первое задание
    static void Task1() {
        while (true) {
            System.out.print("Введите желаемое количество итераций: ");
            if (scanner.hasNextInt()) {
                int iterationCount = scanner.nextInt();
                for (int i = 1; i <= iterationCount; i++) {
                    System.out.printf("\n####################\n*** Итерация %d ***\n####################\n\n", i);
                    int[] array1 = generateArray();
                    int[] array2 = generateArray();
                    try {
                        showArray("Уменьшаемый массив:", array1);
                        showArray("Вычитаемый массив:", array2);
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    try {
                        showArray("Итоговый массив:", arraysDifference(array1, array2));
                    } catch (DifferentSizeArraysException e) {
                        System.out.println(e.getMessage());
                        System.out.printf("Размер уменьшаемого массива: %d\nРазмер вычитаемого массива: %d\n",
                                e.firstArrayLength, e.secondArrayLength);
                    }
                }
                return;
            } else {
                System.out.println("Ошибка ввода данных.\nПопробуйте снова.");
                scanner.nextLine();
            }
        }
    }

    /*
    Task 2
    Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
    и возвращающий новый массив, каждый элемент которого равен частному элементов
    двух входящих массивов в той же ячейке.
    Если длины массивов не равны, необходимо как-то оповестить пользователя.
    */

    // Собираем второе задание
    static void Task2() {
        while (true) {
            System.out.print("Введите желаемое количество итераций: ");
            if (scanner.hasNextInt()) {
                int iterationCount = scanner.nextInt();
                for (int i = 1; i <= iterationCount; i++) {
                    System.out.printf("\n####################\n*** Итерация %d ***\n####################\n\n", i);
                    int[] array1 = generateArray();
                    int[] array2 = generateArray();
                    try {
                        showArray("Делимый массив:", array1);
                        showArray("Массив-делитель:", array2);
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    try {
                        showArray("Итоговый массив:", arraysDivision(array1, array2));
                    } catch (DifferentSizeArraysException e) {
                        System.out.println(e.getMessage());
                        System.out.printf("Размер уменьшаемого массива: %d\nРазмер вычитаемого массива: %d\n",
                                e.firstArrayLength, e.secondArrayLength);
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }
                }
                return;
            } else {
                System.out.println("Ошибка ввода данных.\nПопробуйте снова.");
                scanner.nextLine();
            }
        }
    }

    /**
     * Метод генерации массива целых чисел
     *
     * @return Одномерный массив (size: 7-8; values: 0-10)
     */
    static int[] generateArray() {
        int[] array = new int[random.nextInt(2) + 7];
        if (random.nextInt(10) == array.length)
            return null;
        for (int i = 0; i < array.length; i++)
            array[i] = random.nextInt(0, 11);
        return array;
    }

    /**
     * Метод вывода массива в консоль
     *
     * @param title Строка-заголовок
     * @param array Целочисленный одномерный массив
     */
    static void showArray(String title, int[] array) {
        if (array == null)
            throw new NullPointerException(String.format("Массива с заголовком '%s' не существует.", title));
        else {
            String text = String.format("%s\n", title);
            for (int value : array)
                text += value + " ";
            System.out.println(text);
            System.out.println();
        }
    }

    /**
     * Метод получения разности элементов двух целочисленных массивов
     *
     * @param array1 Массив-уменьшаемое
     * @param array2 Массив-вычитаемое
     * @return Массив-разность array1 и array2
     */
    static int[] arraysDifference(int[] array1, int[] array2) {
        if (array1 == null && array2 == null)
            throw new NullPointerException("Ни один из входящих массивов не существует.");
        if (array1 == null)
            throw new NullPointerException("Уменьшаемый массив не существует.");
        if (array2 == null)
            throw new NullPointerException("Вычитаемый массив не существует.");
        if (array1.length != array2.length)
            throw new DifferentSizeArraysException("Для корректной работы размеры массивов должны быть равными",
                    array1, array2);
        int[] resultArray = new int[array1.length];
        for (int i = 0; i < array1.length; i++)
            resultArray[i] = array1[i] - array2[i];
        return resultArray;
    }

    /**
     * Метод деления элементов двух целочисленных массивов
     *
     * @param array1 Массив-делимое
     * @param array2 Массив-делитель
     * @return Массив, результат деления array1 на array2
     */
    static int[] arraysDivision(int[] array1, int[] array2) {
        if (array1 == null && array2 == null)
            throw new NullPointerException("Ни один из входящих массивов не существует.");
        if (array1 == null)
            throw new NullPointerException("Массив-делимое не существует.");
        if (array2 == null)
            throw new NullPointerException("Массив-делитель не существует.");
        if (array1.length != array2.length)
            throw new DifferentSizeArraysException("Для корректной работы размеры массивов должны быть равными",
                    array1, array2);
        int[] resultArray = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            if (array2[i] == 0)
                throw new ArithmeticException(String.format("Элемент #%d второго массива равен нулю.\n" +
                        "На ноль делить можно, но в другой раз :)", i + 1));
            resultArray[i] = array1[i] / array2[i];
        }
        return resultArray;
    }

}


class DifferentSizeArraysException extends RuntimeException {

    int firstArrayLength;
    int secondArrayLength;

    public int getFirstLength() {
        return firstArrayLength;
    }

    public int getSecondLength() {
        return secondArrayLength;
    }

    public DifferentSizeArraysException(String errorMessage, int[] array1, int[] array2) {
        super(errorMessage);
        this.firstArrayLength = array1.length;
        this.secondArrayLength = array2.length;
    }
}