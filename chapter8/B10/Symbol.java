// Класс Символ: один символ текста
public class Symbol {
    private char value;

    public Symbol(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return value == ((Symbol) o).value;
    }

    public int hashCode() {
        return value;
    }

    public String toString() {
        return String.valueOf(value);
    }
}
