// Глава 1, вариант A, задание 3
// Вывод заданного количества случайных чисел
// сначала с переходом на новую строку, потом без перехода

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Введите количество чисел: java Main 5");
            return;
        }
        int n = Integer.parseInt(args[0]); // сколько чисел нужно вывести
        Random random = new Random();

        // println - после каждого числа новая строка
        System.out.println("С переходом на новую строку:");
        for (int i = 0; i < n; i++) {
            System.out.println(random.nextInt(100));
        }

        // print - все числа в одной строке через пробел
        System.out.println("Без перехода на новую строку:");
        for (int i = 0; i < n; i++) {
            System.out.print(random.nextInt(100) + " ");
        }
        System.out.println();
    }
}
