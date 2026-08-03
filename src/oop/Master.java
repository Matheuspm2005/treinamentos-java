package oop;

public class Master {
    public static void main(String[] args) {
        Pen p1 = new Pen();
        p1.cPen("Bic", "Blue", 0.5f);
        p1.status();
        p1.draw();
        p1.setCapped(false);
        for(int i = 0; i <= 10; i++){
            p1.draw();
        }
        p1.status();
        p1.setCapped(true);
        p1.setInkLevel(10);
        p1.status();
    }
}
