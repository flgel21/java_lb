import java.util.ArrayList;

// Глава 8, вариант C, задание 10
// Форматирование текста с выравниванием по обоим краям

public class Main {
    public static void main(String[] args) {
        // исходный текст (с табуляцией и лишними пробелами)
        String text = "Java -   это объектно-ориентированный язык программирования.\t"
                + "Программа на Java состоит из классов, а классы описывают объекты и их поведение.  "
                + "Выравнивание по ширине делает текст аккуратным: слева и справа строки заканчиваются ровно.";

        int width = 40; // ширина строки в символах
        TextFormatter formatter = new TextFormatter(width);
        ArrayList<String> lines = formatter.format(text);

        // знаки | показывают границы строки
        System.out.println("Ширина строки: " + width);
        for (int i = 0; i < lines.size(); i++) {
            System.out.println("|" + lines.get(i) + "|");
        }
    }
}
