package seminar2;

import java.util.Random;


public class Task2 {

    // Исходный код задания
    /*
     try {
        int d = 0;
        double catchedRes1 = intArray[8] / d;
        System.out.println("catchedRes1 = " + catchedRes1);
     } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
     }

     */

    /**
     * # Добавил метод генерации массива, и записал результат метода в intArray
     * -------
     * # Добавил блок catch, отлавливающий исключения выхода за пределы размера массива на случай,
     * если размер массива будет менее 9
     * -------
     * # Привел элемент массива, учавствующий в делении к типу double, т.к. ожидается результат этого типа.
     * При этом перестанет выбрасываться исключение деления на ноль, но результат деления всегда будет одинаков
     * (при делении double на ноль) - бесконечность.
     * То есть, если планируется использовать переменную catchedRes1 далее, нужно иметь это в виду.
     * -------
     */
    public static void main(String[] args) {
        int[] intArray = generateArray();
        try {
            int d = 0;
            System.out.println("d = " + d);
            double catchedRes1 = (double) intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index is out of range.");
        } catch (Exception e) {
            System.out.println("Something wrong.");
        }
    }

    /**
     * Метод генерации массива
     * для проверки кода
     *
     * @return Целочисленный массив
     */
    static int[] generateArray() {
        Random random = new Random();
        int[] array = new int[random.nextInt(5) + 7];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
            System.out.print(array[i] + String.format("[%d]", i) + " ");
        }
        System.out.println();
        return array;
    }

}
