// Класс Знак препинания
public class Punctuation {
    private char mark;

    public Punctuation(char mark) {
        this.mark = mark;
    }

    public char getMark() {
        return mark;
    }

    public String toString() {
        return String.valueOf(mark);
    }
}
