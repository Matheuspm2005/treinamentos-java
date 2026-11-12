package exerciciosSala.Banco.src;

    public enum Dinheiro{
        CINCOCENTAVOS(true, 0.5f),
        DEZCENTAVOS(true, 0.10f),
        VINTECINCOCENTAVOS(true, 0.25f),
        CINQUENTACENTAVOS(true, 0.50f),
        UMREAL(true, 1),
        DOISREAIS(false, 2),
        DEZREAIS(false, 10),
        VINTEREAIS(false, 20),
        CINQUENTAREAIS(false, 50),
        CEMREAIS(false, 100),
        DUZENTOSREAIS(false, 200);

        private final boolean ehMoeda;
        private final float valor;

        Dinheiro(boolean ehMoeda, float valor){
            this.ehMoeda = ehMoeda;
            this.valor = valor;
        }

        public boolean isMoeda() {
            return ehMoeda;
        }

        public float getValor() {
            return valor;
        }
    }
