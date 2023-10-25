package ED.Filas;

class FilaDinamica {

    class No {

        int valor;
        No prox;
        //construtor
        public No(int valor){
            this.valor = valor;
            this.prox = null;
        }
        //retorna o valor do nó
        public int getValor(){
            return this.valor;
        }
        //retorna o proximo elemento
        public No getProx(){
            return this.prox;
        }

        public void setProx(No noh){
            this.prox = noh;
        }

    }

    private No inicio;
    private No fim;
    private int tamanho;

    public FilaDinamica(){
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public No getInicio(){
        return this.inicio;
    }
    public No getFim(){
        return this.fim;
    }
    public int getTamanho(){
        return this.tamanho;
    }

    public void setInicio(No noh){
        this.inicio = noh;
    }

    public void setFim(No noh){
        this.fim = noh;
    }

    public boolean isEmpty(){
        return this.tamanho == 0 ? true : false;
    }

    public void enqueue(int valor){
        No noh = new No(valor);
        if(this.isEmpty()){
            this.inicio = this.fim = noh;
            this.tamanho++;
        } else {
            this.tamanho++;
            this.fim.setProx(noh);
            this.fim = this.fim.getProx();
        }

    }

    public int dequeue(){
        if(this.isEmpty()){
            System.out.println("Fila vazia...");
            return -1;
        } else if(this.tamanho == 1){
            int v = this.inicio.getValor();
            this.inicio = this.fim = null;
            this.tamanho--;
            return v;
        }
        int v = this.inicio.getValor();
        this.inicio = this.inicio.getProx();
        this.tamanho--;
        return v;
    }

    public String toString(){

        String str = "";
        No n1 = this.getInicio();
        while(n1 != null){
            str += n1.getValor()+", ";
            n1 = n1.getProx();
        }
        return str;
    }

    public static void main(String[] args) {

        FilaDinamica f = new FilaDinamica();
        f.enqueue(5);
        //System.out.println(f.isEmpty());
        System.out.println(f.getInicio().getValor());
        System.out.println(f.getFim().getValor());

        f.enqueue(7);
        System.out.println(f.getInicio().getValor());
        System.out.println(f.getFim().getValor());

        f.enqueue(11);
        System.out.println(f.getInicio().getValor());
        System.out.println(f.getFim().getValor());

        System.out.println(f.toString());
        System.out.println(f.dequeue());
        System.out.println(f.toString());
    }
}







