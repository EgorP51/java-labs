package controller;

import model.*;
import view.DrawManager;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShapeController {
    private ShapeData shapeData;
    private DrawManager drawManager;

    public ShapeController(ShapeData shapeData, DrawManager drawManager) {
        this.shapeData = shapeData;
        this.drawManager = drawManager;
    }

    public void processShapes() {
        List<Shape> shapes = shapeData.getShapes();

        System.out.println("\nDefault:");
        drawManager.displayShapes(shapes);

        Collections.sort(shapes, Comparator.comparingDouble(Shape::calcArea));

        System.out.println("\nSort(area)");
        drawManager.displayShapes(shapes);

        Collections.sort(shapes, Comparator.comparing(shape -> shape.shapeColor));

        System.out.println("\nSort(color)");
        drawManager.displayShapes(shapes);

        // Areas here
        double totalArea = shapes.stream().mapToDouble(Shape::calcArea).sum();
        System.out.println("\nTotal Area: " + totalArea);

        double totalTriangleArea = getTotalShapeArea(shapes, Triangle.class);
        System.out.println("Total Triangle Area: " + totalTriangleArea);

        double totalRectangleArea = getTotalShapeArea(shapes, Rectangle.class);
        System.out.println("Total Rectangle Area: " + totalRectangleArea);

        double totalCircleArea = getTotalShapeArea(shapes, Circle.class);
        System.out.println("Total Circle Area: " + totalCircleArea);
    }
    private double getTotalShapeArea(List<Shape> shapes, Class<? extends Shape> shapeClass){
        return shapes.stream().filter(shapeClass::isInstance).mapToDouble(Shape::calcArea).sum();
    }
}
