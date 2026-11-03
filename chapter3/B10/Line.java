// Класс Прямая на плоскости. Уравнение прямой: a*x + b*y + c = 0
// Арифметические действия (сложение, вычитание и т.д.) для прямых
// не имеют смысла, поэтому их в классе нет.
public class Line {
    private double a;
    private double b;
    private double c;

    // прямая y = x по умолчанию
    public Line() {
        a = 1;
        b = -1;
        c = 0;
    }

    public Line(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // прямая по двум точкам (x1, y1) и (x2, y2)
    public Line(double x1, double y1, double x2, double y2) {
        this.a = y1 - y2;
        this.b = x2 - x1;
        this.c = x1 * y2 - x2 * y1;
    }

    public double getA() { return a; }
    public void setA(double a) { this.a = a; }

    public double getB() { return b; }
    public void setB(double b) { this.b = b; }

    public double getC() { return c; }
    public void setC(double c) { this.c = c; }

    // точка пересечения с осью OX (там y = 0), возвращает x
    // если прямая параллельна оси, пересечения нет - возвращаем null
    public Double crossOX() {
        if (a == 0) return null;
        return -c / a;
    }

    // точка пересечения с осью OY (там x = 0), возвращает y
    public Double crossOY() {
        if (b == 0) return null;
        return -c / b;
    }

    // проверка, параллельна ли эта прямая другой прямой
    public boolean isParallel(Line other) {
        // прямые параллельны, если a1*b2 - a2*b1 = 0
        double d = a * other.b - other.a * b;
        return Math.abs(d) < 0.000001;
    }

    // точка пересечения двух прямых (метод Крамера), вернет {x, y}
    // если прямые параллельны - вернет null
    public double[] cross(Line other) {
        double d = a * other.b - other.a * b;
        if (Math.abs(d) < 0.000001) return null;
        double x = (b * other.c - other.b * c) / d;
        double y = (c * other.a - other.c * a) / d;
        return new double[]{x, y};
    }

    public String toString() {
        return a + "x + " + b + "y + " + c + " = 0";
    }
}
