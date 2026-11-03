import java.util.Objects;

// Эконом-класс - это легковой автомобиль, поэтому наследуем Car.
// Особенность: объем багажника.
public class EconomyCar extends Car {
    private int trunkVolume; // объем багажника, литров

    public EconomyCar(String brand, String model, double price, double fuelConsumption,
                      int maxSpeed, int trunkVolume) {
        super(brand, model, price, fuelConsumption, maxSpeed);
        this.trunkVolume = trunkVolume;
    }

    public int getTrunkVolume() { return trunkVolume; }
    public void setTrunkVolume(int trunkVolume) { this.trunkVolume = trunkVolume; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        EconomyCar that = (EconomyCar) o;
        return trunkVolume == that.trunkVolume;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), trunkVolume);
    }

    @Override
    public String toString() {
        return "Эконом: " + super.toString() + ", багажник: " + trunkVolume + " л";
    }
}
