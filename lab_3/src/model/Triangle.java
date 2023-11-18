package model;

public class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(String shapeColor, double base, double height) {
        super(shapeColor);
        this.base = base;
        this.height = height;
    }

    @Override
    public double calcArea() {
        return 0.5 * base * height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a triangle with color: " + shapeColor + " and area: " + calcArea());
    }

    @Override
    public String toString() {
        return "Triangle - " + super.toString();
    }
}

