// Глава 1, вариант A, задание 1
// Приветствие пользователя по имени, которое вводится в командной строке

public class Main {
    public static void main(String[] args) {
        // если имя не передали, просим его ввести
        if (args.length == 0) {
            System.out.println("Введите имя: java Main Имя");
            return;
        }
        // имя - это первый аргумент командной строки
        System.out.println("Привет, " + args[0] + "!");
    }
}
