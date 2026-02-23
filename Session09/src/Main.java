import bai1.Student;
import bai2.Animal;
import bai2.Cat;
import bai2.Dog;
import bai3.Manager;
import bai6.Circle;
import bai6.Rectangle;
import bai6.Shape;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Bai1
        System.out.println("Bai1");
        Student s = new Student("Nguyễn Văn A", 20, "SV001", 3.5);
        s.displayInfo();
        //Bai2
        System.out.println("Bai2");
        Animal a1 = new Dog();
        Animal a2 = new Cat();
        a1.sound();
        a2.sound();
        //Bai3
        System.out.println("Bai3");
        Manager m = new Manager("Nguyễn Văn B", 15000000, "Kỹ thuật");
        m.displayInfo();
        //Bai4
        System.out.println("Bai4");
        Animal animal = new Dog();
        animal.sound();
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.wagTail();
        }
        //Bai6
        System.out.println("Bai6");
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(5));
        shapes.add(new Rectangle(3, 4));
        shapes.add(new Rectangle(6));
        double totalArea = 0;
        int index = 1;
        System.out.println("Kết quả tính toán hình học:\n");
        for (Shape shape : shapes) {
            double area = shape.calculateArea();
            System.out.println(index + ". " + shape +
                    " - Diện tích: " + String.format("%.2f", area));
            totalArea += area;
            index++;
        }
        System.out.println("\n=> Tổng diện tích các hình: " +
                String.format("%.2f", totalArea));
    }
}