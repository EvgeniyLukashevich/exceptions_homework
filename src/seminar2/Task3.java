package seminar2;

public class Task3 {

    // Исходный код задания
    /*
    public static void main(String[] args) throws Exception {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        }
    }
    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
    }
    */


    /**
     * # Мне кажется, что нет смысла пробрасывать Exception на уровень выше,
     * т.к. не оч понимаю куда можно выше мэйна пробросить. Поэтому убрал throws Exception.
     * -------
     * # Переместил блок catch, отлавливающий Throwable, на последнее место, чтобы была возможность
     * отловить более частные исключения
     * -------
     * # Добавил блок catch, отлавливающий арифметические исключения, т.к. есть вероятность деленя на ноль,
     * если программа будет подразумевать изменение переменных
     * -------
     * # Подправил метод сложения целых чисел
     * -------
     * # Не знаю, что имелось в виду, но подправил инициализацию массива и присвоение элементам массива значений.
     * Значения, которые желали присвоить, будут присвоены, при этом третий элемент массива
     * (элемент с индексом 2) останется равным нулю.
     * -------
     * Конечно, не понимая замысла, сложно делать вывод о полезности программы :) Хотелось бы, например,
     * чтобы массив как-то использовался. Но, так как, задача была подправить, а не переписать -
     * показалось неуместным кардинально что-то менять.
     * -------
     */
    public static void main(String[] args) {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = new int[4];
            abc[0] = 1;
            abc[1] = 2;
            abc[3] = 9;
        } catch (ArithmeticException e) {
            System.out.println("Не стоит делить на ноль");
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    /**
     * Метод складывающий два входящих целых числа
     * После исправления будет выбрасывать исключение, если одно из чисел не существует
     *
     * @param a Целое число 1
     * @param b Целое число 2
     */
    public static void printSum(Integer a, Integer b) {
        if (a == null || b == null)
            throw new NullPointerException("Оба числа должны существовать.");
        System.out.println(a + b);
    }

}

