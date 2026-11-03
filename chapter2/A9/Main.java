/**
 * Глава 2, вариант A, задание 9
 * Нахождение корней квадратного уравнения ax^2 + bx + c = 0.
 * Коэффициенты a, b, c передаются через командную строку.
 */ 
public class Main {
    /** Главный метод программы */
    public static void main(String[] args) {
        // нужно ровно три коэффициента
        if (args.length != 3) {
            System.out.println("Введите a, b, c: java Main 1 -3 2");
            return;
        }

        /** Коэффициенты уравнения */
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);

        if (a == 0) {
            /** Если a = 0, то уравнение линейное: bx + c = 0 */
            if (b == 0) {
                System.out.println("Это не уравнение");
            } else {
                System.out.println("x = " + (-c / b));
            }
        } else {
            /** Дискриминант D = b^2 - 4ac */
            double d = b * b - 4 * a * c;

            if (d > 0) {
                /** Два разных корня */
                double x1 = (-b + Math.sqrt(d)) / (2 * a);
                double x2 = (-b - Math.sqrt(d)) / (2 * a);
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
            } else if (d == 0) {
                /** Один корень */
                System.out.println("x = " + (-b / (2 * a)));
            } else {
                /** Дискриминант отрицательный - корней нет */
                System.out.println("Действительных корней нет");
            }
        }

        /** Данные разработчика (ВПИШИТЕ свои) */
        System.out.println();
        System.out.println("Разработчик: Лоскутников");
        System.out.println("Задание получено: 29.10.2026 12:00");
        System.out.println("Задание сдано: 03.11.2026 ");
    }
}
