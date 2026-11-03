// Глава 1, вариант B, задание 10
// Ввод n целых чисел с консоли. Вывод чисел-палиндромов
// (число одинаково читается слева направо и справа налево)

import java.util.Scanner;

public class Main {
    // проверка, является ли число палиндромом
    static boolean isPalindrome(int number) {
        int original = number;
        int reversed = 0;
        // собираем число задом наперед по цифрам
        while (number > 0) {
            reversed = reversed * 10 + number % 10;
            number = number / 10;
        }
        return original == reversed;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Сколько чисел будете вводить? ");
        int n = scanner.nextInt();

        int[] numbers = new int[n];
        System.out.println("Вводите числа:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println("Числа-палиндромы:");
        for (int i = 0; i < n; i++) {
            // отрицательные числа не считаем палиндромами
            if (numbers[i] >= 0 && isPalindrome(numbers[i])) {
                System.out.println(numbers[i]);
            }
        }
    }
}
