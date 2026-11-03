// Глава 8, вариант A, задание 10
// В тексте найти и напечатать n символов (и их количество),
// которые встречаются чаще всего

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст:");
        String text = scanner.nextLine();
        System.out.print("Сколько самых частых символов вывести? ");
        int n = scanner.nextInt();

        // counts[код символа] - сколько раз символ встретился
        int[] counts = new int[65536];
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            // пробелы и другие пробельные символы не считаем
            if (!Character.isWhitespace(c)) {
                counts[c]++;
            }
        }

        // n раз находим символ с наибольшим счетчиком
        for (int k = 0; k < n; k++) {
            int best = 0;
            for (int i = 1; i < counts.length; i++) {
                if (counts[i] > counts[best]) {
                    best = i;
                }
            }
            if (counts[best] == 0) {
                break; // символы закончились
            }
            System.out.println("'" + (char) best + "' - " + counts[best] + " раз(а)");
            counts[best] = 0; // обнуляем, чтобы в следующий раз найти другой
        }
    }
}
