package ED.Filas;

class FilaDinamica {
    class No {
        int valor;
        No prox;

        public No(int valor) {
            this.valor = valor;
            this.prox = null;
        }
        // retorna o valor do nó
        public int getValor() {
            return valor;
        }
        //retorna o proximo nó
        public No getProx() {
            return prox;
        }

        public void setProx(No prox) {
            this.prox = prox;
        }
    }
    private No inicio;
    private No fim;
    private int tamanho;

    public FilaDinamica() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public No getInicio() {
        return inicio;
    }

    public void setInicio(No inicio) {
        this.inicio = inicio;
    }

    public No getFim() {
        return fim;
    }

    public void setFim(No fim) {
        this.fim = fim;
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean isEmpty(){
        return this.tamanho == 0;
    }

    public void enqueue(int valor){
        No noh = new No(valor);
        if(this.isEmpty()){
            this.inicio = this.fim = noh;
            this.tamanho++;
            //return;
        } else {
            this.tamanho++;
            this.fim.setProx(noh);
            this.fim = this.fim.getProx();
        }
    }

    public String toString() {

        String str = "";
        No n1 = this.getInicio();
        while(n1 != null){
            str += n1.getValor() + ", ";
            n1 = n1.getProx();
        }
        return str;
    }

    public int dequeue(){
        if(this.isEmpty()){
            System.out.println("Fila vazia...");
            return -1;
        } else if(this.tamanho == 1) {
            int v = this.inicio.getValor();
            this.inicio = this.fim = null;
            return v;
        }
        int v = this.inicio.getValor();
        this.inicio = this.inicio.getProx();
        this.tamanho--;
        return v;
    }


    public static void main(String[] args) {
        FilaDinamica fd = new FilaDinamica();
        fd.enqueue(5);
        //System.out.println(fd.isEmpty());
        System.out.println(fd.getInicio().getValor());
        System.out.println(fd.getFim().getValor());

        fd.enqueue(7);
        System.out.println(fd.getInicio().getValor());
        System.out.println(fd.getFim().getValor());

        fd.enqueue(11);
        System.out.println(fd.getInicio().getValor());
        System.out.println(fd.getFim().getValor());

        System.out.println(fd.toString());

        fd.dequeue();
        System.out.println(fd.toString());
    }
}
