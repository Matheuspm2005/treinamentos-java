package oop.college;

public class Master {
    public static void main(String[] args){
        Person p1 = new Person();
        Student p2 = new Student();
        Faculty p3 = new Faculty();
        Staff p4 = new Staff();

        p1.setName("Peter");
        p2.setName("Paul");
        p3.setName("Carl");
        p4.setName("Maria");

        p1.setSex('M');
        p2.setSex('M');
        p3.setSex('M');
        p4.setSex('F');

        p3.setSalary(500);
        p3.increaseSalary(100);

        p2.setCourse("Computer Science");
        p2.withdraw();

        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
        System.out.println(p4.toString());
    }


}
