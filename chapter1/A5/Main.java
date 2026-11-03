// Глава 1, вариант A, задание 5
// Целые числа вводятся как аргументы командной строки.
// Считаем их сумму и произведение

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Введите числа: java Main 1 2 3");
            return;
        }
        long sum = 0;     // сумма
        long product = 1; // произведение (начинаем с 1, а не с 0)

        for (int i = 0; i < args.length; i++) {
            int number = Integer.parseInt(args[i]); // переводим строку в число
            sum = sum + number;
            product = product * number;
        }
        System.out.println("Сумма: " + sum);
        System.out.println("Произведение: " + product);
    }
}
