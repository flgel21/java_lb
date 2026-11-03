// Глава 5, вариант A, задание 10
// Класс Mobile с внутренним классом Model

public class Main {
    public static void main(String[] args) {
        Mobile samsung = new Mobile("Samsung");

        // добавляем модели через метод внешнего класса
        samsung.addModel("Galaxy S23", 69990, 6.1, 256, "черный");
        samsung.addModel("Galaxy A54", 36990, 6.4, 128, "синий");

        // объект внутреннего класса можно создать и снаружи,
        // но только через объект внешнего класса
        Mobile.Model model = samsung.new Model("Galaxy Z Flip5", 89990, 6.7, 512, "лавандовый");
        samsung.addModel(model);

        samsung.printModels();

        // поиск модели и изменение ее свойства
        Mobile.Model found = samsung.findModel("Galaxy A54");
        if (found != null) {
            found.setPrice(33990);
            System.out.println();
            System.out.println("После снижения цены: " + found);
        }
    }
}
