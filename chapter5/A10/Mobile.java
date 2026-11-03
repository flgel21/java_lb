import java.util.ArrayList;

// Класс Mobile - производитель (бренд) мобильных телефонов.
// Внутри него есть внутренний класс Model, объекты которого хранят
// информацию о конкретных моделях телефонов и их свойствах.
public class Mobile {
    private String brand;                                  // название бренда
    private ArrayList<Model> models = new ArrayList<Model>(); // список моделей этого бренда

    public Mobile(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    // Внутренний класс Model. Он не static, поэтому каждая модель
    // принадлежит конкретному объекту Mobile (знает, чей это телефон)
    public class Model {
        private String name;      // название модели
        private double price;     // цена
        private double screen;    // диагональ экрана, дюймы
        private int memory;       // память, ГБ
        private String color;     // цвет

        public Model(String name, double price, double screen, int memory, String color) {
            this.name = name;
            this.price = price;
            this.screen = screen;
            this.memory = memory;
            this.color = color;
        }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public double getPrice() { return price; }
        public void setPrice(double price) { this.price = price; }

        public double getScreen() { return screen; }
        public void setScreen(double screen) { this.screen = screen; }

        public int getMemory() { return memory; }
        public void setMemory(int memory) { this.memory = memory; }

        public String getColor() { return color; }
        public void setColor(String color) { this.color = color; }

        // из внутреннего класса можно обратиться к полю внешнего (brand)
        public String toString() {
            return brand + " " + name + ": цена " + price + " руб., экран "
                    + screen + "\", память " + memory + " ГБ, цвет " + color;
        }
    }

    // добавить новую модель (объект внутреннего класса создаем внутри Mobile)
    public void addModel(String name, double price, double screen, int memory, String color) {
        models.add(new Model(name, price, screen, memory, color));
    }

    // добавить уже созданную модель
    public void addModel(Model model) {
        models.add(model);
    }

    // найти модель по названию, если нет - вернем null
    public Model findModel(String name) {
        for (int i = 0; i < models.size(); i++) {
            if (models.get(i).getName().equals(name)) {
                return models.get(i);
            }
        }
        return null;
    }

    // вывести все модели
    public void printModels() {
        System.out.println("Модели бренда " + brand + ":");
        for (int i = 0; i < models.size(); i++) {
            System.out.println((i + 1) + ". " + models.get(i));
        }
    }
}
