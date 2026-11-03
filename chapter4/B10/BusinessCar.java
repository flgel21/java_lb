import java.util.Objects;

// Бизнес-класс - тоже легковой автомобиль, наследуем Car.
// Особенность: кожаный салон.
public class BusinessCar extends Car {
    private boolean leatherSeats; // есть ли кожаный салон

    public BusinessCar(String brand, String model, double price, double fuelConsumption,
                       int maxSpeed, boolean leatherSeats) {
        super(brand, model, price, fuelConsumption, maxSpeed);
        this.leatherSeats = leatherSeats;
    }

    public boolean isLeatherSeats() { return leatherSeats; }
    public void setLeatherSeats(boolean leatherSeats) { this.leatherSeats = leatherSeats; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        BusinessCar that = (BusinessCar) o;
        return leatherSeats == that.leatherSeats;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), leatherSeats);
    }

    @Override
    public String toString() {
        return "Бизнес: " + super.toString() + ", кожаный салон: " + (leatherSeats ? "да" : "нет");
    }
}
