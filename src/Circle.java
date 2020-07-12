public class Circle {

    private Point center;
    private double radius;

    public Circle() {
        this.center = new Point(0, 0);
        this.radius = 1;
    }

    public Circle(Point center, double radius) {
        this.center = center;
        setRadius(radius);
    }

    public Circle(double x, double y, double radius) {
        this.center = new Point(x, y);
        setRadius(radius);
    }

    public Point getCenter() {
        return this.center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void setCenter(double x, double y) {
        this.center = new Point(x, y);
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0) {
            System.out.println("The radius must be positive!");
            return;
        }
        this.radius = radius;
    }

    public double getDiameter() {
        return radius * 2;
    }

    public double getCircumference() {
        return Math.PI * getDiameter();
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public String toString() {
        return "Center: " + center.toString() + " , Radius: " + this.radius;
    }

}