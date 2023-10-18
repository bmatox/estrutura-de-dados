package ED.Filas;

class FilaDinamica {
    class No {
        int valor;
        No prox;

        public No(int valor) {
            this.valor = valor;
            this.prox = null;
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

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public static void main(String[] args) {

    }
}
