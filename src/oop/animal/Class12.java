package oop.animal;

public class Class12 {
    public static void main(String[] args) {
        Mammal m = new Mammal();
        Reptile r = new Reptile();
        Fish f = new Fish();
        Bird b = new Bird();
        Kangaroo k = new Kangaroo();
        Dog d = new Dog();
        Turtle t = new Turtle();
        Pigeon p = new Pigeon();

        m.setWeight(5.84f);
        m.setAge(3);
        m.setMembers(4);
        m.setCoatColor("Blue");
        System.out.println(m.toString());
        m.feed();
        m.move();
        m.makeSound();

        r.setWeight(5.84f);
        r.setAge(3);
        r.setMembers(0);
        r.setScaleColor("Green");
        System.out.println(r.toString());
        r.feed();
        r.move();
        r.makeSound();

        f.setWeight(5.84f);
        f.setAge(3);
        f.setMembers(4);
        f.setScaleColor("Yellow");
        System.out.println(f.toString());
        f.feed();
        f.move();
        f.makeSound();

        b.setWeight(5.84f);
        b.setAge(4);
        b.setMembers(4);
        b.setFeatherColor("Red");
        System.out.println(b.toString());
        b.feed();
        b.move();
        b.makeSound();

        k.move();
        d.makeSound();
        t.move();
        p.makeSound();
        d.react("Fun");
        d.react(8);
        d.react(13.7f);
    }
}
