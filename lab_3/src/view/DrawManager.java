package view;

import model.Shape;

import java.util.List;

public class DrawManager {
    public void displayShapes(List<Shape> shapes) {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
