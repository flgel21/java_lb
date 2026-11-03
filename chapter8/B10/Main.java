import java.util.ArrayList;

// Глава 8, вариант B, задание 10
// Есть текст и список слов. Для каждого слова из списка находим,
// сколько раз оно встречается в каждом предложении, и сортируем слова
// по убыванию общего количества вхождений.

public class Main {
    public static void main(String[] args) {
        // текст (специально с табуляцией и лишними пробелами)
        String text = "Java - это язык программирования.   Класс в Java описывает объект.\tОбъект создается из класса!\n"
                + "\n"
                + "Переменная хранит значение.  Каждый объект имеет класс, а класс описывает объект.";

        // список слов, которые ищем
        String[] list = {"java", "класс", "объект", "значение"};

        // разбираем текст и собираем все предложения в один список
        ArrayList<Paragraph> paragraphs = TextParser.parse(text);
        ArrayList<Sentence> sentences = new ArrayList<Sentence>();
        for (int i = 0; i < paragraphs.size(); i++) {
            sentences.addAll(paragraphs.get(i).getSentences());
        }

        System.out.println("Предложений в тексте: " + sentences.size());
        for (int i = 0; i < sentences.size(); i++) {
            System.out.println((i + 1) + ") " + sentences.get(i));
        }

        // counts[i][j] - сколько раз слово i встречается в предложении j
        int[][] counts = new int[list.length][sentences.size()];
        int[] total = new int[list.length]; // всего вхождений каждого слова
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < sentences.size(); j++) {
                counts[i][j] = sentences.get(j).countWord(list[i]);
                total[i] = total[i] + counts[i][j];
            }
        }

        // сортировка слов по убыванию общего количества (пузырьком)
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (total[j] < total[j + 1]) {
                    // меняем местами сразу слово, его счетчики и общую сумму
                    String tmpWord = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = tmpWord;

                    int[] tmpCounts = counts[j];
                    counts[j] = counts[j + 1];
                    counts[j + 1] = tmpCounts;

                    int tmpTotal = total[j];
                    total[j] = total[j + 1];
                    total[j + 1] = tmpTotal;
                }
            }
        }

        // вывод результата
        System.out.println();
        System.out.println("Результат (по убыванию общего количества):");
        for (int i = 0; i < list.length; i++) {
            System.out.print("'" + list[i] + "' - всего " + total[i] + ", по предложениям: ");
            for (int j = 0; j < sentences.size(); j++) {
                System.out.print(counts[i][j] + " ");
            }
            System.out.println();
        }
    }
}
