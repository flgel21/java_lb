// Класс Четырехугольник. Вершины a, b, c, d идут по порядку обхода
public class Quadrangle {
    private Point a;
    private Point b;
    private Point c;
    private Point d;

    public Quadrangle() {
        // по умолчанию единичный квадрат
        a = new Point(0, 0);
        b = new Point(1, 0);
        c = new Point(1, 1);
        d = new Point(0, 1);
    }

    public Quadrangle(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Point getA() { return a; }
    public void setA(Point a) { this.a = a; }
    public Point getB() { return b; }
    public void setB(Point b) { this.b = b; }
    public Point getC() { return c; }
    public void setC(Point c) { this.c = c; }
    public Point getD() { return d; }
    public void setD(Point d) { this.d = d; }

    // периметр - сумма длин четырех сторон
    public double perimeter() {
        return a.distance(b) + b.distance(c) + c.distance(d) + d.distance(a);
    }

    // площадь по формуле Гаусса (формула площади по координатам вершин)
    public double area() {
        double sum = a.getX() * b.getY() - b.getX() * a.getY()
                + b.getX() * c.getY() - c.getX() * b.getY()
                + c.getX() * d.getY() - d.getX() * c.getY()
                + d.getX() * a.getY() - a.getX() * d.getY();
        return Math.abs(sum) / 2;
    }

    // угол в вершине p прямой, если скалярное произведение векторов равно 0
    private boolean isRight(Point p, Point prev, Point next) {
        double dot = (prev.getX() - p.getX()) * (next.getX() - p.getX())
                + (prev.getY() - p.getY()) * (next.getY() - p.getY());
        return Math.abs(dot) < 0.000001;
    }

    // у прямоугольника все углы прямые
    private boolean isRectangle() {
        return isRight(a, d, b) && isRight(b, a, c)
                && isRight(c, b, d) && isRight(d, c, a);
    }

    // у ромба все стороны равны
    private boolean isRhombus() {
        double ab = a.distance(b);
        return Math.abs(ab - b.distance(c)) < 0.000001
                && Math.abs(ab - c.distance(d)) < 0.000001
                && Math.abs(ab - d.distance(a)) < 0.000001;
    }

    // тип: квадрат = и прямоугольник, и ромб
    public String getType() {
        if (isRectangle() && isRhombus()) return "Квадрат";
        if (isRectangle()) return "Прямоугольник";
        if (isRhombus()) return "Ромб";
        return "Произвольный";
    }

    public String toString() {
        return getType() + " " + a + b + c + d
                + ", площадь = " + area() + ", периметр = " + perimeter();
    }
}
