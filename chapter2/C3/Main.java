/**
 * Глава 2, вариант C, задание 3
 * Поиск наибольшего количества возрастающих и убывающих элементов
 * матрицы, идущих подряд (идем по строкам слева направо, сверху вниз).
 */
import java.util.Random;

public class Main {
    /** Главный метод программы */
    public static void main(String[] args) {
        int rows = 4;
        int cols = 5;
        int[][] matrix = new int[rows][cols];
        Random random = new Random();

        /** Заполняем матрицу случайными числами и выводим ее */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(10);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        /** Переписываем матрицу в одномерный массив, так проще считать цепочки */
        int[] line = new int[rows * cols];
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                line[k] = matrix[i][j];
                k++;
            }
        }

        int maxUp = 1;    // наибольшая возрастающая цепочка
        int maxDown = 1;  // наибольшая убывающая цепочка
        int up = 1;       // текущая возрастающая цепочка
        int down = 1;     // текущая убывающая цепочка

        for (int i = 1; i < line.length; i++) {
            /** Сравниваем текущий элемент с предыдущим */
            if (line[i] > line[i - 1]) {
                up++;
            } else {
                up = 1;
            }
            if (line[i] < line[i - 1]) {
                down++;
            } else {
                down = 1;
            }
            if (up > maxUp) maxUp = up;
            if (down > maxDown) maxDown = down;
        }

        System.out.println("Наибольшее число возрастающих подряд: " + maxUp);
        System.out.println("Наибольшее число убывающих подряд: " + maxDown);

        /** Данные разработчика (ВПИШИТЕ свои) */
        System.out.println();
        System.out.println("Разработчик: Лоскутников");
        System.out.println("Задание получено: 29.10.2026 12:00");
        System.out.println("Задание сдано: 03.11.2026 ");
    }
}
