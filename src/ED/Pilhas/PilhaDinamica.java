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
        // Cria um novo nó com o valor recebido
        No no = new No(valor);
        // Faz o novo nó apontar para o antigo topo da pilha
        no.setProx(this.topo);
        // Faz o topo da pilha apontar para o novo nó
        this.topo = no;
        // Incrementa o tamanho da pilha em uma unidade
        this.tamanho++;
    }

    public int pop() {
        if(this.isEmpty()){
            System.out.println("Pilha está vazia!!!");
            return -1;
        }
        int tmp = this.topo.getValor();
        this.topo = this.topo.getProx();
        this.tamanho--;
        return tmp;
    }

    public void imprimePilha(){
        if(this.isEmpty()){
            System.out.println("Pilha vazia!!");
            return;
        }
        No no = this.topo;
        System.out.print("Elementos da pilha dinâmica: {");
        while (no.getProx() != null){
            System.out.print(no.getValor() + ", ");
            no = no.getProx();
        }
        System.out.print(no.getValor() + "}");
    }


    public static void main(String[] args) {
        PilhaDinamica pd = new PilhaDinamica();
        System.out.println(pd.isEmpty());
        pd.imprimePilha();
        pd.push(5);
        pd.push(3);
        pd.push(11);
        pd.imprimePilha();
        System.out.println("");
        pd.pop();
        pd.pop();
        pd.imprimePilha();

    }
}

