// Офисное здание. Специальные методы: добавить этаж, посчитать рабочие места
public class OfficeBuilding extends Building {
    private int floors;            // количество этажей
    private int workplacesPerRoom; // рабочих мест в одной комнате

    public OfficeBuilding(String name, double area, int rooms, double totalPrice,
                          int floors, int workplacesPerRoom) {
        super(name, area, rooms, totalPrice);
        this.floors = floors;
        this.workplacesPerRoom = workplacesPerRoom;
    }

    // добавить этаж: растет площадь и число комнат
    public void addFloor(double floorArea, int roomsOnFloor) {
        floors++;
        increaseArea(floorArea);
        addRooms(roomsOnFloor);
        System.out.println("Добавлен этаж, теперь этажей: " + floors);
    }

    // всего рабочих мест в здании
    public int countWorkplaces() {
        return getRoomsCount() * workplacesPerRoom;
    }

    public String getType() {
        return "Офисное здание";
    }

    public String toString() {
        return super.toString() + ", этажей: " + floors + ", рабочих мест: " + countWorkplaces();
    }
}
