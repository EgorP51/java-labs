package model;

import java.util.List;

public class ShapeData {
    private List<Shape> shapes;

    public ShapeData(List<Shape> shapesList) {
        shapes = shapesList;
    }

    public List<Shape> getShapes() {
        return shapes;
    }
}
