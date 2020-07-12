public class Line {

    private Point A;
    private Point B;

    public Line() {
        A.setXY(0, 0);
        B.setXY(0, 0);
    }

    public Line(Point A, Point B) {
        if (A == B) {
            throw new IllegalArgumentException("These two points do not form a line!");
        }
        this.B = B;
        this.A = A;
    }

    public Line(double x1, double y1, double x2, double y2) {
        A.setXY(x1, y1);
        B.setXY(x2, y2);
    }

    public Point getA() {
        return A;
    }

    public void setA(Point A) {
        this.A = A;
    }

    public void setA(double x, double y) {
        this.A = new Point(x, y);
    }

    public Point getB() {
        return B;
    }

    public void setB(Point B) {
        this.B = B;
    }

    public void setB(double x, double y) {
        this.B = new Point(x, y);
    }

    public double lenght() {
        return A.distance(B);
    }

    public String toString() {
        return "Start: " + A.toString() + " , End: " + B.toString();
    }

}