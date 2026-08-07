package oop.animal;

public class Bird extends Animal{
    private String featherColor;

    @Override
    public String toString() {
        return "Bird{" +
                "featherColor='" + featherColor + '\'' +
                ", weight=" + weight +
                ", age=" + age +
                ", members=" + members +
                '}';
    }

    @Override
    public void move() {
        System.out.println("Flying");
    }

    @Override
    public void feed() {
        System.out.println("Eating Fruits");
    }

    @Override
    public void makeSound() {
        System.out.println("Bird Sound");
    }

    public String getFeatherColor() {
        return featherColor;
    }

    public void setFeatherColor(String featherColor) {
        this.featherColor = featherColor;
    }
}
