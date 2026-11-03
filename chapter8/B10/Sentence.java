import java.util.ArrayList;

// Класс Предложение: слова и знаки препинания
public class Sentence {
    private ArrayList<Word> words = new ArrayList<Word>();
    private ArrayList<Punctuation> marks = new ArrayList<Punctuation>();
    private String text = ""; // исходный текст предложения

    public void addWord(Word word) {
        words.add(word);
    }

    public void addMark(Punctuation mark) {
        marks.add(mark);
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<Word> getWords() {
        return words;
    }

    // сколько раз слово встречается в этом предложении
    public int countWord(String target) {
        int count = 0;
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).sameAs(target)) {
                count++;
            }
        }
        return count;
    }

    public String toString() {
        return text;
    }
}
