// Глава 6, вариант A, задание 10
// Дом, офисное здание и торговый центр через интерфейсы

public class Main {
    public static void main(String[] args) {
        // ----- Дом -----
        House house = new House("Дом на Лесной", 120, 5, 9600000);
        house.build();
        System.out.println("Цена за кв. метр: " + house.pricePerSquareMeter());
        System.out.println("Комнат: " + house.getRoomsCount());
        house.increaseArea(30);
        System.out.println("Цена за кв. метр после увеличения: " + house.pricePerSquareMeter());
        house.repair(2);
        house.repair(9); // такой комнаты нет
        house.rent("семья Петровых");
        house.addGarage();
        house.plantGarden(200);
        System.out.println(house);

        // ----- Офисное здание -----
        System.out.println();
        OfficeBuilding office = new OfficeBuilding("Бизнес-центр Альфа", 2000, 40, 160000000, 5, 6);
        office.build();
        office.rent("ООО Ромашка");
        office.addFloor(400, 8);
        System.out.println(office);

        // ----- Торговый центр -----
        System.out.println();
        ShoppingCenter mall = new ShoppingCenter("ТЦ Радуга", 8000, 3, 400000000, 500);
        mall.build();
        mall.openShop("Одежда");
        mall.openShop("Обувь");
        mall.openShop("Электроника");
        mall.openShop("Продукты"); // свободных помещений уже нет
        System.out.println(mall);

        // интерфейс как тип: один и тот же код работает с любым зданием
        System.out.println();
        Rentable[] list = {house, office, mall};
        for (int i = 0; i < list.length; i++) {
            System.out.println("В аренде: " + list[i].isRented());
        }
    }
}
