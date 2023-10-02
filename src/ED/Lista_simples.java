package ED;
class Lista_simples {
    class No {
        private int valor;
        private No prox;

        public No (int valor) {
            this.valor = valor;
            this.prox = null;
        }

        public void setValor(int valor){
            this.valor = valor;
        }

        public void setProx(No prox){
            this.prox = prox;
        }

        public int getValor(){
            return this.valor;
        }

        public No getProx(){
            return this.prox;
        }
    }

    //atributos da classe lista

    private No inicio;
    private int tamanho;

    public No getInicio(){
        return this.inicio;
    }

    public void setInicio(No inicio){
        this.inicio = inicio;
    }

    public Lista_simples () {
        this.inicio = null;
        this.tamanho = 0;
    }

    public int getTamanho(){
        return this.tamanho;
    }

    public boolean isEmpty() {
        return this.inicio == null;
    }

    public void insereNoInicio(int valor) {
        No novoNo = new No(valor);
        novoNo.setProx(inicio);
        this.setInicio(novoNo);
        this.tamanho += 1;
    }

    public void insereNoFim(int valor){
        No noh = new No(valor);

        if(this.isEmpty()){
            this.setInicio(noh);
            this.tamanho += 1;
            return;
        }

        No n1 = this.getInicio();
        while(n1.getProx() != null){
            n1 = n1.getProx();
        }
        n1.setProx(noh);
        this.tamanho += 1;
    }

    public void removeNoFim(){

        if(this.isEmpty()){
            System.out.println("Lista vazia.");
            return;
        } else if (this.inicio.getProx() == null) {
            System.out.println("Removido o número: " + this.inicio.getValor());
            this.inicio = null;
            this.tamanho -= 1;
            return;
        }
        No n1 = this.getInicio().getProx();
        No n2 = this.getInicio();
        while(n1.getProx() != null){
            n1 = n1.getProx();
            n2 = n2.getProx();
        }
        System.out.println("Removido o número: " + n1.getValor());
        n2.setProx(null);
        this.tamanho -= 1;
    }

    public void removeNoInicio(){
        if(this.isEmpty()){
            System.out.println("Lista vazia.");
            return;
        }
        System.out.println("Removido o número: " + this.inicio.getValor());
        this.inicio = this.inicio.getProx();
        this.tamanho -= 1;
    }

    public void buscarNaLista(int valor){
        No n1 = this.getInicio();
        int contador = 0;
        while(n1.getProx() != null){
            if(n1.getValor() == valor){
                System.out.println("O valor existe na lista e está na posição: " + contador + " da lista");
                return;
            }
            n1 = n1.getProx();
            contador += 1;
        }
        System.out.println("O valor não existe na lista");
    }

    public void insereNaPosicao(int valor, int posicao) {

        if (posicao < 0 || posicao > this.tamanho) {
            System.out.println("Posição inválida.");
            return;
        }
        if (posicao == 0) {
            this.insereNoInicio(valor);
            return;
        }
        if (posicao == this.tamanho) {
            this.insereNoFim(valor);
            return;
        }
        No novoNo = new No(valor);
        No n1 = this.getInicio();
        No n2 = null;
        int contador = 0;
        while (contador < posicao) {
            n2 = n1;
            n1 = n1.getProx();
            contador++;
        }
        novoNo.setProx(n1);
        n2.setProx(novoNo);
        this.tamanho++;
    }

    public void removeNaPosicao(int posicao) {

        if (posicao < 0 || posicao >= this.tamanho) {
            System.out.println("Posição inválida.");
            return;
        }
        if (posicao == 0) {
            this.removeNoInicio();
            return;
        }
        if (posicao == this.tamanho - 1) {
            this.removeNoFim();
            return;
        }
        No n1 = this.getInicio();
        No n2 = null;
        int contador = 0;
        while (contador < posicao) {
            n2 = n1;
            n1 = n1.getProx();
            contador++;
        }
        System.out.println("Removido o número: " + n1.getValor());
        n2.setProx(n1.getProx());
        this.tamanho--;
    }

    @Override
    public String toString() {
        return "Lista_simples{" +
                "inicio=" + inicio +
                ", tamanho=" + tamanho +
                '}';
    }

    /*Public String toString() {
        return "Lista_simples{" +
                "inicio=" + inicio +
                ", tamanho=" + tamanho +
                '}';
    }*/


    public static void main(String[] args) {
        Lista_simples l1 = new Lista_simples();
        System.out.println(l1.isEmpty());
        l1.insereNoFim(5);
        l1.insereNoFim(10);
        l1.insereNoFim(11);
        l1.insereNoFim(12);
        /*l1.removeNoInicio();
        System.out.println(l1.isEmpty());
        System.out.println(l1.toString());
        System.out.println(l1.getTamanho());
        System.out.println(l1.toString());
        l1.insereNoInicio(7);
        System.out.println(l1.toString());
        l1.removeNoFim();*/
        System.out.println(l1.toString());
        l1.buscarNaLista(10);
    }
}