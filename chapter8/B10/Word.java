import java.util.ArrayList;

// Класс Слово: слово состоит из символов
public class Word {
    private ArrayList<Symbol> symbols = new ArrayList<Symbol>();

    public Word(String text) {
        for (int i = 0; i < text.length(); i++) {
            symbols.add(new Symbol(text.charAt(i)));
        }
    }

    // собираем слово обратно в строку
    public String getText() {
        String result = "";
        for (int i = 0; i < symbols.size(); i++) {
            result = result + symbols.get(i).getValue();
        }
        return result;
    }

    // совпадает ли слово с другим, регистр букв не важен
    public boolean sameAs(String other) {
        return getText().equalsIgnoreCase(other);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return symbols.equals(((Word) o).symbols);
    }

    public int hashCode() {
        return symbols.hashCode();
    }

    public String toString() {
        return getText();
    }
}
