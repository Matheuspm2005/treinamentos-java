package oop.animal;

public class Mammal extends Animal{
    private String coatColor;

    @Override
    public String toString() {
        return "Mammal{" +
                "coatColor='" + coatColor + '\'' +
                ", weight=" + weight +
                ", age=" + age +
                ", members=" + members +
                '}';
    }

    @Override
    public void move() {
        System.out.println("Running!");
    }

    @Override
    public void feed() {
        System.out.println("suckling");
    }

    @Override
    public void makeSound() {
        System.out.println("Mammal Sound");
    }

    public String getCoatColor() {
        return coatColor;
    }

    public void setCoatColor(String coatColor) {
        this.coatColor = coatColor;
    }
}
