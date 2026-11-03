/**
 * Глава 2, вариант B, задание 9
 * Ввод числа от 1 до 12 и вывод названия месяца.
 * Есть проверка корректности ввода.
 */
import java.util.Scanner;

public class Main {
    /** Главный метод программы */
    public static void main(String[] args) {
        /** Названия месяцев: индекс 0 - январь, 11 - декабрь */
        String[] months = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
                "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число от 1 до 12: ");

        /** Проверяем, что ввели именно целое число, а не текст */
        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка: нужно ввести целое число");
        } else {
            int number = scanner.nextInt();
            /** Проверяем диапазон */
            if (number < 1 || number > 12) {
                System.out.println("Ошибка: число должно быть от 1 до 12");
            } else {
                // номер месяца на 1 больше индекса в массиве
                System.out.println("Это " + months[number - 1]);
            }
        }

        /** Данные разработчика (ВПИШИТЕ свои) */
        System.out.println();
        System.out.println("Разработчик: Лоскутников");
        System.out.println("Задание получено: 29.10.2026 12:00");
        System.out.println("Задание сдано: 03.11.2026 ");
    }
}
