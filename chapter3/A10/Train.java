// Класс Поезд (Train)
public class Train {
    private String destination; // пункт назначения
    private int number;         // номер поезда
    private int hours;          // время отправления: часы
    private int minutes;        // время отправления: минуты
    private int common;         // число общих мест
    private int coupe;          // число мест в купе
    private int platzkart;      // число плацкартных мест
    private int lux;            // число мест люкс

    // конструктор без параметров
    public Train() {
        destination = "не указан";
    }

    // конструктор с основными данными
    public Train(String destination, int number, int hours, int minutes) {
        this.destination = destination;
        this.number = number;
        this.hours = hours;
        this.minutes = minutes;
    }

    // конструктор со всеми данными
    public Train(String destination, int number, int hours, int minutes,
                 int common, int coupe, int platzkart, int lux) {
        this(destination, number, hours, minutes); // вызываем конструктор выше
        this.common = common;
        this.coupe = coupe;
        this.platzkart = platzkart;
        this.lux = lux;
    }

    // геттеры и сеттеры
    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }

    public int getHours() { return hours; }
    public void setHours(int hours) { this.hours = hours; }

    public int getMinutes() { return minutes; }
    public void setMinutes(int minutes) { this.minutes = minutes; }

    public int getCommon() { return common; }
    public void setCommon(int common) { this.common = common; }

    public int getCoupe() { return coupe; }
    public void setCoupe(int coupe) { this.coupe = coupe; }

    public int getPlatzkart() { return platzkart; }
    public void setPlatzkart(int platzkart) { this.platzkart = platzkart; }

    public int getLux() { return lux; }
    public void setLux(int lux) { this.lux = lux; }

    // строковое представление поезда
    public String toString() {
        return "Поезд №" + number + ", пункт назначения: " + destination
                + ", отправление: " + hours + ":" + (minutes < 10 ? "0" : "") + minutes
                + ", места (общие/купе/плацкарт/люкс): "
                + common + "/" + coupe + "/" + platzkart + "/" + lux;
    }
}
