package exerciciosSala.Fracao.src;

public class Aritmetica{
    public static int mdc(int a, int b){
        int menor = a>b ? b:a;
        int maior = a>b ? a:b;
        int resto= 1;
        while(resto != 0){
            resto = maior % menor;
            maior = menor;
            menor = resto;
        }
        return maior;
    }


    public static int mmc(Fracao f1, Fracao f2, int mdc){
        return (f1.getDenominador()* f2.getDenominador()) / Aritmetica.mdc(f1.getDenominador(), f2.getDenominador());
    }

    public static int mmc(int a, int b){
        return (Math.abs(a * b) / mdc(a, b));
    }
}