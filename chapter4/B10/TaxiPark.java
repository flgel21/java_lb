import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

// Класс Таксопарк. Хранит список автомобилей и умеет с ним работать:
// считать стоимость, сортировать, искать по скорости.
// Эти методы здесь, а не в Car, потому что они работают сразу со всем парком.
public class TaxiPark {
    private String name;
    private ArrayList<Car> cars = new ArrayList<Car>();

    public TaxiPark(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public ArrayList<Car> getCars() { return cars; }

    // добавить автомобиль в парк
    public void addCar(Car car) {
        cars.add(car);
    }

    // стоимость всего автопарка - сумма цен всех машин
    public double totalCost() {
        double sum = 0;
        for (int i = 0; i < cars.size(); i++) {
            sum = sum + cars.get(i).getPrice();
        }
        return sum;
    }

    // сортировка по расходу топлива (от меньшего к большему)
    public void sortByFuel() {
        Collections.sort(cars, new Comparator<Car>() {
            public int compare(Car a, Car b) {
                return Double.compare(a.getFuelConsumption(), b.getFuelConsumption());
            }
        });
    }

    // поиск автомобилей, у которых скорость в диапазоне [min, max]
    public ArrayList<Car> findBySpeed(int min, int max) {
        ArrayList<Car> result = new ArrayList<Car>();
        for (int i = 0; i < cars.size(); i++) {
            int speed = cars.get(i).getMaxSpeed();
            if (speed >= min && speed <= max) {
                result.add(cars.get(i));
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxiPark that = (TaxiPark) o;
        return Objects.equals(name, that.name) && Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cars);
    }

    @Override
    public String toString() {
        return "Таксопарк '" + name + "', машин: " + cars.size();
    }
}
