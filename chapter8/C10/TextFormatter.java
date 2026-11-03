import java.util.ArrayList;

// Форматирование текста по ширине (выравнивание по обоим краям).
// Между словами добавляются дополнительные пробелы так, чтобы
// каждая строка (кроме последней) имела длину ровно width символов.
public class TextFormatter {
    private int width; // ширина строки

    public TextFormatter(int width) {
        this.width = width;
    }

    // сначала заменяем табуляции и несколько пробелов подряд одним пробелом
    private String normalize(String text) {
        return text.replaceAll("\\s+", " ").trim();
    }

    // главный метод: возвращает список готовых строк
    public ArrayList<String> format(String text) {
        String[] words = normalize(text).split(" ");
        ArrayList<String> result = new ArrayList<String>();

        int i = 0;
        while (i < words.length) {
            // набираем слова в строку, пока она помещается в width
            int lineLength = words[i].length();
            int j = i + 1;
            while (j < words.length && lineLength + 1 + words[j].length() <= width) {
                lineLength = lineLength + 1 + words[j].length(); // +1 - обычный пробел
                j++;
            }
            // в строку попали слова с i по j-1
            boolean lastLine = (j == words.length);
            result.add(makeLine(words, i, j, lastLine));
            i = j;
        }
        return result;
    }

    // собираем одну строку из слов words[from..to-1]
    private String makeLine(String[] words, int from, int to, boolean lastLine) {
        int count = to - from; // сколько слов в строке

        // последняя строка и строка из одного слова - без выравнивания
        if (lastLine || count == 1) {
            String line = words[from];
            for (int k = from + 1; k < to; k++) {
                line = line + " " + words[k];
            }
            return line;
        }

        // считаем, сколько всего символов в самих словах
        int lettersCount = 0;
        for (int k = from; k < to; k++) {
            lettersCount = lettersCount + words[k].length();
        }

        int gaps = count - 1;                  // промежутков между словами
        int spaces = width - lettersCount;     // сколько пробелов нужно распределить
        int each = spaces / gaps;              // минимум пробелов в каждом промежутке
        int extra = spaces % gaps;             // остаток - раздаем по одному слева направо

        String line = "";
        for (int k = from; k < to; k++) {
            line = line + words[k];
            if (k < to - 1) {
                int n = each;
                if (k - from < extra) {
                    n++; // лишний пробел достался этому промежутку
                }
                for (int s = 0; s < n; s++) {
                    line = line + " ";
                }
            }
        }
        return line;
    }
}
