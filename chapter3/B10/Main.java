// Глава 3, вариант B, задание 10
// Работа с прямыми: пересечения с осями, пересечение двух прямых,
// группы параллельных прямых

public class Main {
    public static void main(String[] args) {
        // массив прямых
        Line[] lines = new Line[6];
        lines[0] = new Line(1, -1, 0);   // y = x
        lines[1] = new Line(2, -2, 5);   // параллельна первой
        lines[2] = new Line(1, 1, -4);   // x + y = 4
        lines[3] = new Line(2, 2, 1);    // параллельна третьей
        lines[4] = new Line(0, 1, -3);   // y = 3
        lines[5] = new Line(0, 1, -7);   // y = 7, параллельна пятой

        // пересечения с осями
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
            System.out.println("  с осью OX: " + lines[i].crossOX());
            System.out.println("  с осью OY: " + lines[i].crossOY());
        }

        // пересечение первой и третьей прямой
        double[] point = lines[0].cross(lines[2]);
        if (point == null) {
            System.out.println("Прямые параллельны");
        } else {
            System.out.println("Пересечение 1 и 3 прямых: (" + point[0] + "; " + point[1] + ")");
        }

        // группы параллельных прямых
        System.out.println("Группы параллельных прямых:");
        boolean[] used = new boolean[lines.length]; // уже попала в группу или нет
        int groupNumber = 1;
        for (int i = 0; i < lines.length; i++) {
            if (used[i]) continue; // эту прямую уже учли
            System.out.println("Группа " + groupNumber + ":");
            groupNumber++;
            for (int j = i; j < lines.length; j++) {
                if (!used[j] && lines[i].isParallel(lines[j])) {
                    System.out.println("  " + lines[j]);
                    used[j] = true;
                }
            }
        }
    }
}
