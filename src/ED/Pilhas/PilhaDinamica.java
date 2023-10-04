package ED.Pilhas;

public class PilhaDinamica {

    class No {
        private int valor;
        private No prox;

        public No(int valor) {
            this.valor = valor;
            this.prox = null;
        }

        public int getValor() {
            return valor;
        }

        public void setValor(int valor) {
            this.valor = valor;
        }

        public No getProx() {
            return prox;
        }

        public void setProx(No no) {
            this.prox = no;
        }
    }

    private No topo;
    private int tamanho;

    public PilhaDinamica() {
        this.topo = null;
        this.tamanho = 0;
    }

    public No getTopo() {
        return topo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean isEmpty(){
        return this.topo == null;
    }

    public void push(int valor) {
        No no = new No(valor);
        no.setProx(this.topo);
        this.topo = no;
        this.tamanho++;
    }

    public void imprimePilha(){
        if(this.isEmpty()){
            System.out.println("Pilha vazia!!");
            return;
        }
        No no = this.topo;
        while (no.getProx() != null){
            System.out.println(no.getValor() + ", ");
        }
    }
    @Override
    public String toString() {
        return "PilhaDinamica{" +
                "topo=" + topo +
                ", tamanho=" + tamanho +
                '}';
    }

    public static void main(String[] args) {
        PilhaDinamica pd = new PilhaDinamica();
        System.out.println(pd.isEmpty());
    }
}

