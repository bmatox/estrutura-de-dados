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
        // se a fila estiver vazia, retorna uma string vazia
        if (this.isEmpty()) {
            return "";
        }
        // cria um nó auxiliar que aponta para o início da fila
        No aux = this.inicio;
        // cria uma string que vai armazenar os valores da fila
        String s = "";
        // percorre a fila até chegar ao fim
        while (aux != null) {
            // adiciona o valor do nó à string, seguido de uma vírgula
            s += aux.getValor() + ",";
            // avança para o próximo nó
            aux = aux.getProx();
        }
        // remove a última vírgula da string
        s = s.substring(0, s.length() - 1);
        // retorna a string com os valores da fila
        return s;
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
    }
}
