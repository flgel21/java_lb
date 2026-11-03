// Глава 1, вариант A, задание 4
// Ввод пароля из командной строки и сравнение со строкой-образцом

public class Main {
    public static void main(String[] args) {
        String password = "qwerty123"; // строка-образец

        if (args.length == 0) {
            System.out.println("Введите пароль: java Main пароль");
            return;
        }
        // строки сравниваем через equals, а не через ==
        if (password.equals(args[0])) {
            System.out.println("Пароль верный");
        } else {
            System.out.println("Пароль неверный");
        }
    }
}
