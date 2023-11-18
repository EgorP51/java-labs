package model;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String shapeColor, double width, double height) {
        super(shapeColor);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calcArea() {
        return width * height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a rectangle with color: " + shapeColor + " and area: " + calcArea());
    }

    @Override
    public String toString() {
        return "Rectangle - " + super.toString();
    }
}
