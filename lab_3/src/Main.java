import controller.ShapeController;
import model.Shape;
import model.ShapeData;
import model.ShapeUtils;
import view.DrawManager;

import java.util.Arrays;

//Напишіть консольний додаток, використовуючи архітектурний шаблон MVC, який:
//        •	описує інтерфейс Drawable з методом побудови фігури draw(); \|
//        •	описує абстрактний клас Shape, який реалізує інтерфейс Drawable \|
//        і містить поле shapeColor типу String для кольору фігури і конструктор для його ініціалізації, \|
//        абстрактний метод обчислення площі фігури calcArea() і перевизначений метод toString(); \/
//        •	описує класи Rectangle, Triangle, Circle, які успадковуються від класу Shape \/
//        і реалізують метод calcArea (), а також перевизначають  метод toString (); \/
//        •	створює набір даних типу Shape (масив розмірністю не менш 10 елементів); \/
//        •	обробляє масив:
//        -	відображає набір даних; \|
//        -	обчислює сумарну площу всіх фігур набору даних; \|
//        -	обчислює сумарну площу фігур заданого виду; \|
//        -	впорядковує набір даних щодо збільшення площі фігур, використовуючи об'єкт інтерфейсу Comparator; \|
//        -	впорядковує набір даних за кольором фігур, використовуючи об'єкт інтерфейсу Comparator. \|
//        Значення для ініціалізації об'єктів вибираються з заздалегідь підготовлених даних
//        (обраних випадковим чином або по порядку проходження).                               \/


public class Main {
    public static void main(String[] args) {
        int numberOfShapes = 10;

        Shape[] shapesList = ShapeUtils.createRandomShapesArray(numberOfShapes);

        for (Shape shape : shapesList) {
            System.out.println(shape.toString());
        }

        ShapeData shapeData = new ShapeData(Arrays.asList(shapesList));
        DrawManager drawManager = new DrawManager();
        ShapeController shapeController = new ShapeController(shapeData, drawManager);

        shapeController.processShapes();
    }
}
