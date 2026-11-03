// Глава 3, вариант A, задание 10
// Создаем массив поездов и выводим данные по условиям

public class Main {

    // a) поезда, следующие до заданного пункта назначения
    static void printByDestination(Train[] trains, String destination) {
        for (int i = 0; i < trains.length; i++) {
            if (trains[i].getDestination().equals(destination)) {
                System.out.println(trains[i]);
            }
        }
    }

    // b) поезда до заданного пункта, отправляющиеся после заданного часа
    static void printByDestinationAndHour(Train[] trains, String destination, int hour) {
        for (int i = 0; i < trains.length; i++) {
            if (trains[i].getDestination().equals(destination)
                    && trains[i].getHours() > hour) {
                System.out.println(trains[i]);
            }
        }
    }

    // c) поезда до заданного пункта, у которых есть общие места
    static void printWithCommonSeats(Train[] trains, String destination) {
        for (int i = 0; i < trains.length; i++) {
            if (trains[i].getDestination().equals(destination)
                    && trains[i].getCommon() > 0) {
                System.out.println(trains[i]);
            }
        }
    }

    public static void main(String[] args) {
        // массив из пяти поездов
        Train[] trains = new Train[5];
        trains[0] = new Train("Москва", 101, 8, 30, 50, 20, 30, 5);
        trains[1] = new Train("Москва", 102, 15, 45, 0, 18, 25, 4);
        trains[2] = new Train("Минск", 205, 12, 0, 40, 15, 20, 2);
        trains[3] = new Train("Москва", 103, 21, 10, 35, 10, 12, 0);
        trains[4] = new Train("Брест", 310, 6, 20);

        System.out.println("a) Поезда до Москвы:");
        printByDestination(trains, "Москва");

        System.out.println();
        System.out.println("b) Поезда до Москвы, отправляющиеся после 12 часов:");
        printByDestinationAndHour(trains, "Москва", 12);

        System.out.println();
        System.out.println("c) Поезда до Москвы с общими местами:");
        printWithCommonSeats(trains, "Москва");
    }
}
