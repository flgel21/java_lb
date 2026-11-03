import java.util.ArrayList;

// Торговый центр. Специальные методы: открыть магазин, парковка
public class ShoppingCenter extends Building {
    private ArrayList<String> shops = new ArrayList<String>(); // магазины
    private int parkingPlaces;                                  // парковочные места

    public ShoppingCenter(String name, double area, int rooms, double totalPrice, int parkingPlaces) {
        super(name, area, rooms, totalPrice);
        this.parkingPlaces = parkingPlaces;
    }

    // открыть магазин можно, если есть свободные комнаты (помещения)
    public void openShop(String shopName) {
        if (shops.size() >= getRoomsCount()) {
            System.out.println("Нет свободных помещений для магазина " + shopName);
        } else {
            shops.add(shopName);
            System.out.println("Открыт магазин " + shopName);
        }
    }

    public int getShopsCount() {
        return shops.size();
    }

    public int getParkingPlaces() {
        return parkingPlaces;
    }

    public String getType() {
        return "Торговый центр";
    }

    public String toString() {
        return super.toString() + ", магазинов: " + shops.size() + ", парковка: " + parkingPlaces + " мест";
    }
}
