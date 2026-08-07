package oop.animal;

public class Fish extends Animal{
    private String scaleColor;

    @Override
    public String toString() {
        return "Fish{" +
                "scaleColor='" + scaleColor + '\'' +
                ", weight=" + weight +
                ", age=" + age +
                ", members=" + members +
                '}';
    }

    @Override
    public void move() {
        System.out.println("Swimming");
    }

    @Override
    public void feed() {
        System.out.println("Eating substances");
    }

    @Override
    public void makeSound() {
        System.out.println("Blowing bubbles");
    }

    public String getScaleColor() {
        return scaleColor;
    }

    public void setScaleColor(String scaleColor) {
        this.scaleColor = scaleColor;
    }
}
