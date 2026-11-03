// Интерфейс "Строительство": что можно делать со зданием при его создании
public interface Buildable {
    void build();                    // построить
    double pricePerSquareMeter();    // цена за квадратный метр
    int getRoomsCount();             // сколько комнат
    void increaseArea(double extra); // увеличить площадь
}
