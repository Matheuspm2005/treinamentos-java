package oop.animal;

public class Reptile extends Animal{
    private String scaleColor;

    @Override
    public String toString() {
        return "Reptile{" +
                "scaleColor='" + scaleColor + '\'' +
                ", weight=" + weight +
                ", age=" + age +
                ", members=" + members +
                '}';
    }

    @Override
    public void move() {
        System.out.println("Crawling");
    }

    @Override
    public void feed() {
        System.out.println("Eating Vegetables");
    }

    @Override
    public void makeSound() {
        System.out.println("Reptile Sound");
    }

    public String getScaleColor() {
        return scaleColor;
    }

    public void setScaleColor(String scaleColor) {
        this.scaleColor = scaleColor;
    }
}
