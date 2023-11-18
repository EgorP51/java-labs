package model;

import java.util.Random;

public class ShapeUtils {

    public static Shape[] createRandomShapesArray(int size) {
        Shape[] shapes = new Shape[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            String randomColor = getRandomColor();
            double randomDimension1 = random.nextDouble() * 10;
            double randomDimension2 = random.nextDouble() * 10;

            switch (random.nextInt(3)) {
                case 0:
                    shapes[i] = new Circle(randomColor, randomDimension1);
                    break;
                case 1:
                    shapes[i] = new Rectangle(randomColor, randomDimension1, randomDimension2);
                    break;
                case 2:
                    shapes[i] = new Triangle(randomColor, randomDimension1, randomDimension2);
                    break;
            }
        }

        return shapes;
    }

    private static String getRandomColor() {
        String[] colors = {"red", "blue", "green", "yellow", "orange", "purple"};
        Random random = new Random();
        return colors[random.nextInt(colors.length)];
    }
}
