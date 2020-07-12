public class Triangle {

    private Point A;
    private Point B;
    private Point C;

    public Triangle() {
        this.setDefault();
    }

    public Triangle(Point A, Point B, Point C) {
        if (isValid(A, B, C)) {
            this.A = A;
            this.B = B;
            this.C = C;
        } else {
            this.setDefault();
        }
    }

    public boolean isValid(Point A, Point B, Point C) {
        double side1 = A.distance(B);
        double side2 = A.distance(C);
        double side3 = B.distance(C);

        if (side1 + side2 > side3 || side1 + side3 > side2 || side2 + side3 > side1)
            return true;
        return false;
    }

    public void setDefault() {
        this.A = new Point(0, 0);
        this.B = new Point(0, 3);
        this.C = new Point(4, 0);
    }

    public double getLenghtAB() {
        return this.A.distance(this.B);
    }

    public double getLenghtAC() {
        return this.A.distance(this.C);
    }

    public double getLenghtBC() {
        return this.B.distance(this.C);
    }

    public String toString() {
        return "A: " + A.toString() + " , B: " + B.toString() + " , C: " + C.toString();
    }

}