// Дом. Специальные методы: гараж и сад
public class House extends Building {
    private boolean garage;     // есть ли гараж
    private double gardenArea;  // площадь сада

    public House(String name, double area, int rooms, double totalPrice) {
        super(name, area, rooms, totalPrice);
    }

    public void addGarage() {
        garage = true;
        System.out.println("К дому '" + getName() + "' пристроен гараж");
    }

    public void plantGarden(double gardenArea) {
        this.gardenArea = gardenArea;
        System.out.println("Рядом с домом разбит сад " + gardenArea + " кв. м");
    }

    public String getType() {
        return "Дом";
    }

    public String toString() {
        return super.toString() + ", гараж: " + (garage ? "есть" : "нет") + ", сад: " + gardenArea + " кв. м";
    }
}
