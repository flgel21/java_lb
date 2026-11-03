// Глава 3, вариант C
// Массив четырехугольников: считаем количество каждого типа,
// для каждого типа ищем наибольший и наименьший по площади и периметру

public class Main {
    // удобный метод, чтобы короче создавать четырехугольник по 8 числам
    static Quadrangle make(double x1, double y1, double x2, double y2,
                           double x3, double y3, double x4, double y4) {
        return new Quadrangle(new Point(x1, y1), new Point(x2, y2),
                new Point(x3, y3), new Point(x4, y4));
    }

    public static void main(String[] args) {
        Quadrangle[] all = new Quadrangle[7];
        all[0] = make(0, 0, 2, 0, 2, 2, 0, 2);   // квадрат
        all[1] = make(0, 0, 5, 0, 5, 3, 0, 3);   // прямоугольник
        all[2] = make(0, 0, 4, 0, 4, 1, 0, 1);   // прямоугольник
        all[3] = make(0, 0, 3, 4, 8, 4, 5, 0);   // ромб
        all[4] = make(0, 0, 1, 0, 1, 1, 0, 1);   // квадрат
        all[5] = make(0, 0, 6, 0, 5, 4, 1, 7);   // произвольный
        all[6] = make(0, 0, 4, 0, 5, 3, 1, 3);   // произвольный (параллелограмм)

        String[] types = {"Квадрат", "Прямоугольник", "Ромб", "Произвольный"};

        for (int t = 0; t < types.length; t++) {
            int count = 0;
            Quadrangle maxArea = null, minArea = null;
            Quadrangle maxPer = null, minPer = null;

            // проходим по всем фигурам и берем только нужного типа
            for (int i = 0; i < all.length; i++) {
                if (!all[i].getType().equals(types[t])) continue;
                count++;
                if (maxArea == null || all[i].area() > maxArea.area()) maxArea = all[i];
                if (minArea == null || all[i].area() < minArea.area()) minArea = all[i];
                if (maxPer == null || all[i].perimeter() > maxPer.perimeter()) maxPer = all[i];
                if (minPer == null || all[i].perimeter() < minPer.perimeter()) minPer = all[i];
            }

            System.out.println(types[t] + ": " + count + " шт.");
            if (count > 0) {
                System.out.println("  Наибольшая площадь: " + maxArea);
                System.out.println("  Наименьшая площадь: " + minArea);
                System.out.println("  Наибольший периметр: " + maxPer);
                System.out.println("  Наименьший периметр: " + minPer);
            }
        }
    }
}
