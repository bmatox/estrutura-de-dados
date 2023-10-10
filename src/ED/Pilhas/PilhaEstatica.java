package ED.Pilhas;

public class PilhaEstatica {
    String[] vetor;
    int topo; //onde o próximo elemento irá entrar, ou seja, o índice.

    public PilhaEstatica(int tam) {
        this.vetor = new String[tam];
        this.topo = 0;
    }

    public boolean isEmpty(){
        return this.topo == 0;
    }

    public boolean isFull(){
        return this.topo == this.vetor.length;
    }

    public boolean push(String str){
    if(this.isFull()){
        System.out.println("Pilha cheia!!!");
        return false;
    }
    this.vetor[topo] = str;
    this.topo++;
    return true;
    }

    public void pop(){
        if (this.isEmpty()){
            System.out.println("Não removeu!");
        } else {
            this.topo--;
            System.out.println("Estou retirando o valor " + this.vetor[topo] + " da pilha.");
        }

    }

    public static void main(String[] args) {
        PilhaEstatica pe = new PilhaEstatica(5);
        pe.push("Bruno");
        System.out.println(pe.isEmpty());
    }
}