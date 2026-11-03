import java.util.ArrayList;

// Класс Абзац: набор предложений
public class Paragraph {
    private ArrayList<Sentence> sentences = new ArrayList<Sentence>();

    public void addSentence(Sentence sentence) {
        sentences.add(sentence);
    }

    public ArrayList<Sentence> getSentences() {
        return sentences;
    }
}
