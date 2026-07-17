package basics;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        System.out.println("Ola, digite os numeros:");
        Scanner num1 = new Scanner(System.in);
        Scanner num2 = new Scanner(System.in);
        int numero1 = num1.nextInt();
        int numero2 = num2.nextInt();
        System.out.printf("O resultado da soma e: %d\n", numero1+numero2);
        System.out.printf("O resultado da subtracao e: %d\n", numero1-numero2);
        System.out.printf("O resultado da multiplicacao e: %d\n", numero1*numero2);
        System.out.printf("O resultado da divisao e: %.2f\n", (float)numero1/numero2);
        System.out.printf("O resto e: %d\n", numero1%numero2);
        System.out.printf("O primeiro elevado ao segundo: %f", Math.pow((double)numero1, (double)numero2));
    }
}