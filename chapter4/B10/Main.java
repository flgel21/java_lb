import java.util.ArrayList;

// Глава 4, вариант B, задание 10
// Таксопарк: стоимость парка, сортировка по расходу, поиск по скорости

public class Main {
    public static void main(String[] args) {
        TaxiPark park = new TaxiPark("Быстрое такси");

        park.addCar(new EconomyCar("Kia", "Rio", 1200000, 6.2, 190, 480));
        park.addCar(new EconomyCar("Hyundai", "Solaris", 1100000, 6.8, 185, 470));
        park.addCar(new EconomyCar("Lada", "Vesta", 1000000, 7.5, 175, 480));
        park.addCar(new BusinessCar("Toyota", "Camry", 3000000, 8.5, 210, true));
        park.addCar(new BusinessCar("Skoda", "Superb", 3200000, 7.9, 220, false));

        System.out.println(park);
        System.out.println("Стоимость автопарка: " + park.totalCost() + " руб.");

        // сортировка по расходу топлива
        park.sortByFuel();
        System.out.println();
        System.out.println("Автомобили по возрастанию расхода топлива:");
        for (int i = 0; i < park.getCars().size(); i++) {
            System.out.println(park.getCars().get(i));
        }

        // поиск по диапазону скорости
        int min = 180;
        int max = 200;
        ArrayList<Car> found = park.findBySpeed(min, max);
        System.out.println();
        System.out.println("Автомобили со скоростью от " + min + " до " + max + " км/ч:");
        if (found.isEmpty()) {
            System.out.println("Таких автомобилей нет");
        }
        for (int i = 0; i < found.size(); i++) {
            System.out.println(found.get(i));
        }
    }
}
