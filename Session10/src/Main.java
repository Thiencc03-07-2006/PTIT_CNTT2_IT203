import bai1.Circle;
import bai1.Rectangle;
import bai1.Shape;
import bai2.Bicycle;
import bai2.Car;
import bai2.Vehicle;
import bai3.Duck;
import bai3.Fish;
import bai4.RemoteControl;
import bai5.BonusCalculator;
import bai5.Employee;
import bai5.Manager;
import bai5.OfficeStaff;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Bai1
        System.out.println("Bai1");
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        System.out.println("=== Circle ===");
        System.out.println("Area: " + circle.getArea());
        System.out.println("Perimeter: " + circle.getPerimeter());
        System.out.println("=== Rectangle ===");
        System.out.println("Area: " + rectangle.getArea());
        System.out.println("Perimeter: " + rectangle.getPerimeter());
        //Bai2
        System.out.println("Bai2");
        Vehicle car = new Car("Toyota");
        Vehicle bicycle = new Bicycle("Giant");
        car.move();
        bicycle.move();
        //Bai3
        System.out.println("Bai3");
        Duck duck = new Duck("Donald");
        Fish fish = new Fish("Nemo");
        duck.swim();
        duck.fly();
        fish.swim();
        //Bai4
        System.out.println("Bai4");
        RemoteControl smartLight = new RemoteControl() {
            @Override
            public void powerOn() {
                System.out.println("Đèn đã bật");
            }
        };
        smartLight.powerOn();
        smartLight.checkBattery();
        //Bai5
        System.out.println("Bai5");
        List<Employee> employees = new ArrayList<>();
        employees.add(new OfficeStaff("Lan", 8000));
        employees.add(new Manager("Hùng", 15000, 5000));
        System.out.println("=== BẢNG LƯƠNG ===");
        for (Employee emp : employees) {
            System.out.println("Nhân viên: " + emp.getName());
            System.out.println("Lương cơ bản: " + emp.getBaseSalary());
            if (emp instanceof BonusCalculator) {
                double bonus = ((BonusCalculator) emp).getBonus();
                System.out.println("Thưởng KPI: " + bonus);
            } else {
                System.out.println("Thưởng KPI: Không có");
            }
            System.out.println("Tổng lương: " + emp.calculateSalary());
            System.out.println("-------------------------");
        }
    }
}