import java.util.Objects;

// Класс Щенок наследуется от Собаки (щенок - это маленькая собака).
// Особенность щенка - возраст в месяцах, и все действия он делает по-детски.
public class Puppy extends Dog {
    private int ageMonths; // возраст в месяцах

    public Puppy(String name, String breed, int ageMonths) {
        super(name, breed);
        this.ageMonths = ageMonths;
    }

    public int getAgeMonths() {
        return ageMonths;
    }

    public void setAgeMonths(int ageMonths) {
        this.ageMonths = ageMonths;
    }

    // выводим имя на консоль
    public void printName() {
        System.out.println("Имя щенка: " + getName());
    }

    // у щенка голос тоньше, чем у взрослой собаки
    @Override
    public void voice() {
        System.out.println(getName() + " говорит: Тяф-тяф!");
    }

    // щенок бегает неуклюже
    @Override
    public void run() {
        System.out.println(getName() + " неуклюже бежит, смешно переваливаясь");
    }

    // и прыгает невысоко
    @Override
    public void jump() {
        System.out.println(getName() + " прыгает совсем невысоко");
    }

    // кусает щенок не больно, поэтому переопределяем метод собаки
    @Override
    public void bite() {
        System.out.println(getName() + " играючи кусает за палец, но совсем не больно");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false; // класс, имя и порода
        Puppy puppy = (Puppy) o;
        return ageMonths == puppy.ageMonths;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ageMonths);
    }

    @Override
    public String toString() {
        return "Puppy{name='" + getName() + "', breed='" + getBreed()
                + "', ageMonths=" + ageMonths + "}";
    }
}
