// Глава 4, вариант A, задание 10
// Создаем объект класса Щенок и вызываем его методы

public class Main {
    public static void main(String[] args) {
        Puppy puppy = new Puppy("Шарик", "Лабрадор", 3);

        puppy.printName(); // вывести имя
        puppy.voice();     // подать голос
        puppy.jump();      // прыгать
        puppy.run();       // бегать
        puppy.bite();      // кусать

        System.out.println(puppy); // toString

        // проверка equals и hashCode
        Puppy same = new Puppy("Шарик", "Лабрадор", 3);
        Puppy other = new Puppy("Рекс", "Овчарка", 2);
        System.out.println("puppy равен same: " + puppy.equals(same));
        System.out.println("puppy равен other: " + puppy.equals(other));
        System.out.println("hashCode одинаковый у равных объектов: "
                + (puppy.hashCode() == same.hashCode()));
    }
}
