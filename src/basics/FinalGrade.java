package basics;

import java.util.Scanner;

public class FinalGrade {
    public static void main(String[] args) {
        Scanner t1 = new Scanner(System.in);
        Scanner t2 = new Scanner(System.in);
        System.out.println("Grade on the first test:");
        int g1 = t1.nextInt();
        System.out.println("Grade on the second test:");
        int g2 = t2.nextInt();
        int average = Math.round((float)(g1 + g2) / 2);
        if(average >= 70)
            System.out.printf("%d, Congrats, you're moving up to the next grade!\n", average);
        else
            System.out.printf("%d, Repeating the grade.\n", average);
    }
}
