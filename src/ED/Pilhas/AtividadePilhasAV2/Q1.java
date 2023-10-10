package ED.Pilhas.AtividadePilhasAV2;

//(PE) Dado uma pilha que armazene numeros, escreva uma função para ordenar os valores  da pilha em ordem crescente.

public class Q1 {
    int[] vetor;
    int topo; //onde o próximo elemento irá entrar, ou seja, o índice.

    public Q1(int tam) {
        this.vetor = new int[tam];
        this.topo = 0;
    }

    public boolean isEmpty(){
        return this.topo == 0;
    }

    public boolean isFull(){
        return this.topo == this.vetor.length;
    }

    public boolean push(int n){
        if(this.isFull()){
            System.out.println("Pilha cheia!!!");
            return false;
        }
        this.vetor[topo] = n;
        this.topo++;
        return true;
    }

    public int pop(){
        if (this.isEmpty()){
            System.out.println("Não removeu!");
        } else {
            this.topo--;
            System.out.println("Estou retirando o valor " + this.vetor[topo] + " da pilha.");
        }

        return 0;
    }

    public void ordenaPilha() {
        int[] aux = new int[this.vetor.length];
        for(int i = 0; i < this.vetor.length; i++){
            aux[i] = this.pop();
        }
        for (int i = 0; i < this.vetor.length; i++){
            for (int j = 0; j < this.vetor.length; j++){
                if (aux[i] > aux[j]){
                    int tmp = aux[i];
                    aux[i] = aux[j];
                    aux[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Q1 pe = new Q1(4);
        pe.push(1);
        pe.push(7);
        pe.push(4);
        pe.push(2);
        System.out.println();
    }
}