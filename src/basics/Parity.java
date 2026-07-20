package basics;

import java.util.Scanner;

public class Parity {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("insert an integer despite 0:");
        int num = input.nextInt();
        while(num != 0){
            if(num % 2 == 0){
                System.out.printf("%d is even\n", num);
            }
            else{
                System.out.printf("%d is odd\n", num);
            }
            num = input.nextInt();
        }
        System.out.println("Adiós");
    }
}
