package oop;

public class Master {
    public static void main(String[] args) {
        Pen p1 = new Pen();
        p1.color = "Blue";
        p1.model = "Bic";
        p1.ink_level = 100;
        p1.capped = true;
        p1.tip = 0.5f;
        p1.status();
        p1.draw();
        p1.setCapped(false);
        p1.draw();
        p1.status();
        p1.setCapped(true);
    }
}
