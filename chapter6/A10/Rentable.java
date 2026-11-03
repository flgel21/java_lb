// Интерфейс "Аренда": здание можно сдавать в аренду
public interface Rentable {
    void rent(String tenant); // сдать арендатору
    void stopRent();          // закончить аренду
    boolean isRented();       // сдано ли сейчас
}
