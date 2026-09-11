package exerciciosSala_Backup.Fracao.src;

public class Fracao{


    private final int numerador;  // não-negativo!
    private final int denominador;  // positivo
    private final boolean sinal;  // true para positivo ou zero; false para negativo


    public Fracao(int numerador, int denominador) {
        this.numerador = Math.abs(numerador);
        this.denominador = Math.abs(denominador);
        this.sinal = numerador * denominador >= 0;
    }


    @Override
    public String toString() {
        if(getNumerador() == 0)
            return "0";
        else if(getDenominador() == 1) {
            if (getSinal())
                return "" + numerador;
            else
                return "-" + numerador;
        }
        else if (getSinal())
            return numerador + "/" + denominador;
        else
            return "-" + numerador + "/" + denominador;
    }


    public Fracao somar(Fracao outra) {
        int denominador1 = this.getDenominador();
        int denominador2 = outra.getDenominador();
        int numerador1 = this.getNumerador();
        int numerador2 = outra.getNumerador();
        int pos;
        if(this.getDenominador() != outra.getDenominador()) {
            int mmc = Aritmetica.mmc(this, outra, Aritmetica.mdc(this.getDenominador(),outra.getDenominador()));
            numerador1 = mmc / denominador1;
            numerador2 = mmc / denominador2;
            denominador1 = mmc;
        }
        if(this.sinal != outra.sinal){
            pos = (numerador1 - numerador2) > 0 ? (this.getSinal() ? 1 : -1)  : (outra.getSinal() ? 1 : -1);
            Fracao resultado = new Fracao(((numerador1 - numerador2) * pos), denominador1);
            return getFracaoIrredutivel(resultado);
        }
        else {
            pos = this.getSinal() ? 1 : -1;
            Fracao resultado = new Fracao((numerador1 + numerador2) * pos, denominador1);
            return getFracaoIrredutivel(resultado);
        }
    }


    public int getDenominador() {
        return denominador;
    }


    public int getNumerador() {
        return numerador;
    }


    public boolean getSinal() {
        return sinal;
    }


    public double getValorNumerico() {
        double numero = (double)getNumerador()/getDenominador();
        numero = getSinal()? numero: numero * -1;
        return numero;
    }


    public Fracao getFracaoIrredutivel(Fracao fracao) {
        int mDc = Aritmetica.mdc(fracao.getNumerador(), fracao.getDenominador());
        int pos = fracao.getSinal() ? 1 : -1;
        Fracao resultado = new Fracao(fracao.getNumerador()*pos/mDc, fracao.getDenominador()/mDc);
        return resultado;
    }


    public Fracao multiplicar(Fracao outra) {
        int pos = getSinal() == outra.getSinal() ? 1 : -1;
        Fracao resultado = new Fracao((this.getNumerador() * outra.getNumerador() * pos), (this.getDenominador()*outra.getDenominador()));
        return resultado;
    }

    public Fracao multiplicar(Fracao outra, boolean reduz) {
        int pos = getSinal() == outra.getSinal() ? 1 : -1;
        Fracao resultado = new Fracao((this.getNumerador() * outra.getNumerador() * pos), (this.getDenominador()*outra.getDenominador()));
        if(reduz) return getFracaoIrredutivel(resultado);
        return resultado;
    }
}