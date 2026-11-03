import java.util.Objects;

// Класс Собака наследуется от Животного (собака - это животное).
// Здесь то, что есть именно у собаки: порода и умение кусать.
public class Dog extends Animal {
    private String breed; // порода

    public Dog(String name, String breed) {
        super(name); // имя храним в родителе
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    // у собаки свой голос - переопределяем метод родителя
    @Override
    public void voice() {
        System.out.println(getName() + " говорит: Гав!");
    }

    // кусать умеют собаки (а не все животные), поэтому метод именно здесь
    public void bite() {
        System.out.println(getName() + " кусает");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false; // проверяем класс и имя
        Dog dog = (Dog) o;
        return Objects.equals(breed, dog.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), breed);
    }

    @Override
    public String toString() {
        return "Dog{name='" + getName() + "', breed='" + breed + "'}";
    }
}
