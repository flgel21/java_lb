// Глава 1, вариант A, задание 2
// Вывод аргументов командной строки в обратном порядке

public class Main {
    public static void main(String[] args) {
        // идем по массиву args с конца к началу
        for (int i = args.length - 1; i >= 0; i--) {
            System.out.println(args[i]);
        }
    }
}
