package oop.books;

public class Master {
    public static void main(String[] args) {
        Person[] p = new Person[2];
        Books[] b = new Books[3];

        p[0] = new Person("Marty", 32, 'f');
        p[1] = new Person("Matthew", 30, 'M');

        b[0] = new Books("The Lord of the Rings: The Fellowship of the Ring", "J.R.R. Tolkien", 576, p[1]);
        b[1] = new Books("The Hobbit", "J.R.R. Tolkien", 328,  p[1]);
        b[2] = new Books("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 223,  p[0]);

        for(int i = 0; i < 3; i++)
            System.out.println(b[i].detail());
    }
}
