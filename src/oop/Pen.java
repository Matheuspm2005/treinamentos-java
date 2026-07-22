package oop;

public class Pen {
    String model;
    String color;
    int ink_level;
    boolean capped;
    float tip;
    void status(){
        System.out.println("Pen model: " + model);
        System.out.println("Pen color: " + color);
        System.out.println("Pen ink level: " + ink_level);
        System.out.println("Pen capped: " + capped);
        System.out.println("Pen tip: " + tip);
    }
    void setCapped(boolean capped){
        this.capped = capped;
    }
    void draw(){
        if (capped)
            System.out.println("ERROR! Must uncap the pen.");
        else {
            System.out.println("Drawn!");
        }
    }
}
