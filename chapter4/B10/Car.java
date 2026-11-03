import java.util.Objects;

// Базовый класс Легковой автомобиль.
// Общие данные для всех машин таксопарка лежат здесь.
public class Car {
    private String brand;          // марка
    private String model;          // модель
    private double price;          // стоимость, руб.
    private double fuelConsumption; // расход топлива, л на 100 км
    private int maxSpeed;          // максимальная скорость, км/ч

    public Car(String brand, String model, double price, double fuelConsumption, int maxSpeed) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.fuelConsumption = fuelConsumption;
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public double getFuelConsumption() { return fuelConsumption; }
    public void setFuelConsumption(double fuelConsumption) { this.fuelConsumption = fuelConsumption; }

    public int getMaxSpeed() { return maxSpeed; }
    public void setMaxSpeed(int maxSpeed) { this.maxSpeed = maxSpeed; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(price, car.price) == 0
                && Double.compare(fuelConsumption, car.fuelConsumption) == 0
                && maxSpeed == car.maxSpeed
                && Objects.equals(brand, car.brand)
                && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, price, fuelConsumption, maxSpeed);
    }

    @Override
    public String toString() {
        return brand + " " + model + ", цена: " + price + " руб., расход: "
                + fuelConsumption + " л/100км, скорость: " + maxSpeed + " км/ч";
    }
}
