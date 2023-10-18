package ED.Filas;

class FilaEstatica {

    int inicio;
    int fim;
    int qtdElementos;
    int tamanho;
    int fila[];

    public FilaEstatica(){
        this.inicio = this.fim = -1;
        this.qtdElementos = 0;
        this.tamanho = 100;
        this.fila = new int[this.tamanho];
    }

    public boolean isEmpty(){
        return this.qtdElementos == 0;
    }

    public boolean isFull(){
        return this.qtdElementos == this.tamanho-1;
    }

    public void enqueue(int valor){
        if(this.isFull()){
            System.out.println("Fila cheia...");
            return;
        } else if(this.inicio == -1){
            this.inicio = this.fim = 0;
            this.fila[fim] = valor;
            this.qtdElementos++;
            return;
        }
        this.fim++;
        this.qtdElementos++;
        this.fila[fim] = valor;

    }

    public String toString(){
        String str = "";
        for(int i = this.inicio; i <= this.fim; i++) {
            str += this.fila[i] + ", ";
        }
        return str;
    }

    public int getQtdElementos(){
        return this.qtdElementos;
    }

    public int dequeue(){
        if(this.isEmpty()){
            System.out.println("A fila está vazia...");
            return -1;
        }
        int ret = this.fila[this.inicio];
        this.inicio++;
        this.qtdElementos--;
        return ret;
    }
}
public class Main
{
    public static void main(String[] args) {
        FilaEstatica fe = new FilaEstatica();

        fe.enqueue(5);
        fe.enqueue(8);
        fe.enqueue(41);

        System.out.println(fe.getQtdElementos());

        System.out.println(fe.toString());

        System.out.println(fe.dequeue());

        System.out.println(fe.toString());
        System.out.println(fe.getQtdElementos());

        System.out.println(fe.dequeue());

        System.out.println(fe.toString());
        System.out.println(fe.getQtdElementos());
    }
}