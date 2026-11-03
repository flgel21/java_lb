// Глава 7, вариант A, задание 10
// Три разных целых числа. Лямбда-выражение находит наибольшее из них

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // лямбда-выражение: берет три числа и возвращает наибольшее
        MaxOfThree max = (a, b, c) -> Math.max(a, Math.max(b, c));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите три разных целых числа:");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();

        // по условию числа должны быть разными
        if (x == y || y == z || x == z) {
            System.out.println("Ошибка: числа должны быть разными");
        } else {
            System.out.println("Наибольшее число: " + max.find(x, y, z));
        }
    }
}
