import java.util.Objects;

// Класс Животное - самый общий класс.
// Здесь лежит то, что есть у любого животного: имя, голос, бег, прыжки.
public class Animal {
    private String name; // имя животного

    public Animal(String name) {
        this.name = name;
    }

    // имя есть у любого животного, поэтому геттер здесь
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // подать голос может любое животное, но у каждого он свой,
    // поэтому в потомках метод переопределяем
    public void voice() {
        System.out.println(name + " издает звук");
    }

    // бегать и прыгать умеют почти все животные, поэтому метод в общем классе
    public void run() {
        System.out.println(name + " бежит");
    }

    public void jump() {
        System.out.println(name + " прыгает");
    }

    // equals: животные равны, если совпадают класс и имя
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name);
    }

    // hashCode считаем по тем же полям, что и equals
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Animal{name='" + name + "'}";
    }
}
