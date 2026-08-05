package oop.ufc;

public class Ufc {
    public static void main(String[] args) {
        Fighter[] l = new Fighter[2];
        l[0] = new Fighter("Shadow", "EUA", 26, 170, 77, 7, 1, 1);
        l[1] = new Fighter("Bullet train", "Brazil", 28, 174, 79, 14, 2, 0);

        Fight UFC01 = new Fight();
        Fight UFC02 = new Fight();
        UFC01.scheduleFight(l[0], l[0], 3);
        UFC01.fight();
        UFC02.scheduleFight(l[0], l[1], 5);
        UFC02.fight();

        l[0].status();
        l[1].status();
    }
}
