import java.util.ArrayList;

// Разбор текста на абзацы, предложения, слова и знаки препинания
public class TextParser {

    // замена табуляций и последовательностей пробелов одним пробелом
    public static String normalize(String line) {
        return line.replaceAll("[ \\t]+", " ").trim();
    }

    // разбор всего текста на абзацы (абзацы разделены переводом строки)
    public static ArrayList<Paragraph> parse(String text) {
        ArrayList<Paragraph> paragraphs = new ArrayList<Paragraph>();
        String[] lines = text.split("\n");

        for (int i = 0; i < lines.length; i++) {
            String line = normalize(lines[i]);
            if (line.length() == 0) {
                continue; // пустую строку пропускаем
            }
            paragraphs.add(parseParagraph(line));
        }
        return paragraphs;
    }

    // разбор одного абзаца на предложения
    private static Paragraph parseParagraph(String line) {
        Paragraph paragraph = new Paragraph();
        Sentence sentence = new Sentence();
        String word = "";         // слово, которое сейчас собираем
        String sentenceText = ""; // текст предложения

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            sentenceText = sentenceText + c;

            if (Character.isLetterOrDigit(c)) {
                word = word + c; // буква или цифра - продолжаем слово
            } else {
                // любой другой символ завершает слово
                if (word.length() > 0) {
                    sentence.addWord(new Word(word));
                    word = "";
                }
                // пробел - не знак препинания, остальное - знак
                if (c != ' ') {
                    sentence.addMark(new Punctuation(c));
                }
                // . ! ? заканчивают предложение
                if (c == '.' || c == '!' || c == '?') {
                    sentence.setText(sentenceText.trim());
                    paragraph.addSentence(sentence);
                    sentence = new Sentence();
                    sentenceText = "";
                }
            }
        }
        // если текст закончился без точки
        if (word.length() > 0) {
            sentence.addWord(new Word(word));
        }
        if (sentenceText.trim().length() > 0) {
            sentence.setText(sentenceText.trim());
            paragraph.addSentence(sentence);
        }
        return paragraph;
    }
}
