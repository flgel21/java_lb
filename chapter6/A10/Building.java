// Абстрактный класс Здание. Реализует все три интерфейса, потому что
// эти действия одинаковы для дома, офиса и торгового центра.
// Объект Building создать нельзя - это общая часть для трех видов зданий.
public abstract class Building implements Buildable, Rentable, Repairable {
    private String name;       // название
    private double area;       // площадь, кв. м
    private int rooms;         // число комнат
    private double totalPrice; // общая стоимость
    private boolean built;     // построено или нет
    private String tenant;     // арендатор (null, если не сдано)
    private boolean[] repaired; // в каких комнатах сделан ремонт

    public Building(String name, double area, int rooms, double totalPrice) {
        this.name = name;
        this.area = area;
        this.rooms = rooms;
        this.totalPrice = totalPrice;
        this.repaired = new boolean[rooms];
    }

    public String getName() { return name; }
    public double getArea() { return area; }
    public boolean isBuilt() { return built; }

    // Buildable
    public void build() {
        if (built) {
            System.out.println(name + " уже построен");
        } else {
            built = true;
            System.out.println(name + " построен");
        }
    }

    public double pricePerSquareMeter() {
        return totalPrice / area;
    }

    public int getRoomsCount() {
        return rooms;
    }

    public void increaseArea(double extra) {
        if (extra <= 0) {
            System.out.println("Площадь можно только увеличить");
            return;
        }
        double price = pricePerSquareMeter(); // цена за метр не меняется
        area = area + extra;
        totalPrice = price * area;
        System.out.println(name + ": площадь увеличена до " + area + " кв. м");
    }

    // метод для потомков: добавить комнаты (массив ремонта тоже увеличиваем)
    protected void addRooms(int count) {
        boolean[] newArray = new boolean[rooms + count];
        for (int i = 0; i < rooms; i++) {
            newArray[i] = repaired[i];
        }
        repaired = newArray;
        rooms = rooms + count;
    }

    // Rentable
    public void rent(String tenant) {
        if (!built) {
            System.out.println("Нельзя сдать: " + name + " еще не построен");
        } else if (this.tenant != null) {
            System.out.println("Уже сдано: " + this.tenant);
        } else {
            this.tenant = tenant;
            System.out.println(name + " сдан в аренду: " + tenant);
        }
    }

    public void stopRent() {
        tenant = null;
        System.out.println("Аренда " + name + " закончена");
    }

    public boolean isRented() {
        return tenant != null;
    }

    // Repairable
    public void repair(int room) {
        if (room < 1 || room > rooms) {
            System.out.println("Нет комнаты с номером " + room);
        } else {
            repaired[room - 1] = true;
            System.out.println("В комнате " + room + " сделан ремонт");
        }
    }

    // у каждого вида здания свое название типа
    public abstract String getType();

    public String toString() {
        return getType() + " '" + name + "': " + area + " кв. м, комнат: " + rooms
                + ", построен: " + (built ? "да" : "нет")
                + ", в аренде: " + (isRented() ? "да" : "нет");
    }
}
