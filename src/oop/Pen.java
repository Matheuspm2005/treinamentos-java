package oop;

public class Pen {
    private String model;
    private String color;
    private int inkLevel;
    private boolean capped;
    private float tip;
    //Getter
    void status(){
        System.out.println("Pen model: " + model);
        System.out.println("Pen color: " + color);
        System.out.println("Pen ink level: " + inkLevel);
        System.out.println("Pen capped: " + capped);
        System.out.println("Pen tip: " + tip);
    }
    //Construct method
    public void cPen(String m, String c, float t){
        this.model = m;
        this.color = c;
        this.inkLevel = 100;
        this.tip = t;
        this.setCapped(true);
    }
    public String getModel() {
        return this.model;
    }
    //Setter
    void setCapped(boolean capped){
        this.capped = capped;
    }
    void setInkLevel(int lvl) {
        this.inkLevel += lvl;
    }
    void draw(){
        if (capped)
            System.out.println("Error, must uncap the pen.");
        else if(this.inkLevel < 10){
            System.out.println("Error, ink level too low");
        }
        else {
            System.out.println("Drawn!");
            this.inkLevel -= 10;
        }
    }
}
