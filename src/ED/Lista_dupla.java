package ED;

class Lista_dupla {
    class No {
        private int valor;
        private No ant;
        private No prox;

        public No (int valor) {
            this.valor = valor;
            this.ant = null;
            this.prox = null;
        }

        public int getValor(){
            return this.valor;
        }
        public No getAnt(){
            return this.ant;
        }
        public No getProx() {
            return this.prox;
        }
        public void setValor(int valor){
            this.valor = valor;
        }
        public void setAnt(No ant){
            this.ant = ant;
        }
        public void setProx(No prox) {
            this.prox = prox;
        }
    }

    private No inicio;
    private No fim;
    private int tamanho;

    public Lista_dupla(){
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
    public void setInicio(No inicio){
        this.inicio = inicio;
    }
    public void setFim(No fim){
        this.fim = fim;
    }
    public void setTamanho(int tamanho){
        this.tamanho = tamanho;
    }

    public boolean isEmpty(){
        return this.tamanho == 0;
    }

    public void insereNoInicio(int valor){
        No noh = new No(valor);

        if(this.isEmpty()){
            this.inicio = noh;
            this.fim = this.inicio;
            this.tamanho += 1;
            return;
        }

        noh.setProx(this.getInicio());
        this.inicio = noh;
        this.tamanho += 1;
    }

    public String exibeLista(){
        String str = "";
        if(this.isEmpty()){
            str += "Lista Vazia.";
            return str;
        }

        for(No i = this.inicio; i != null; i = i.getProx()){
            str += i.getValor() + ", ";
        }

        return str;
    }
    public String exibeListaReversa(){
        String str = "";
        if(this.isEmpty()){
            str += "Lista Vazia.";
            return str;
        }

        for(No i = this.fim; i != null; i = i.getAnt()){
            str += i.getValor() + ", ";
        }

        return str;
    }



    public static void main(String[] args) {

        Lista_dupla ld = new Lista_dupla();
        System.out.println(ld.exibeLista());
        ld.insereNoInicio(5);
        System.out.println(ld.exibeLista());
        ld.insereNoInicio(46);
        System.out.println(ld.exibeLista());

    }
}