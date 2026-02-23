package bai3;

public class Duck extends Animal implements Swimmable, Flyable {

    public Duck(String name) {
        super(name);
    }

    @Override
    public void swim() {
        System.out.println(name + " đang bơi trên mặt nước.");
    }

    @Override
    public void fly() {
        System.out.println(name + " đang bay trên bầu trời.");
    }
}