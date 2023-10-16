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
            return -1; //retorna um valor inválido para indicar que a pilha está vazia
        } else {
            int valor = this.vetor[topo-1]; //guarda o valor do topo em uma variável auxiliar
            this.topo--; //decrementa o topo
            System.out.println("Estou retirando o valor " + valor + " da pilha.");
            return valor; //retorna o valor removido
        }
    }

    public void ordenaPilha() {
        int[] aux = new int[this.vetor.length];
        for(int i = 0; i < this.vetor.length; i++){
            aux[i] = this.pop(); //desempilha os valores do vetor e armazena no vetor auxiliar
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
        for(int i = this.vetor.length - 1; i >= 0; i--){
            this.push(aux[i]); //empilha os valores ordenados do vetor auxiliar no vetor original
        }
    }

    public static void main(String[] args) {
        Q1 pe = new Q1(4);
        pe.push(1);
        pe.push(7);
        pe.push(4);
        pe.push(2);
        System.out.println("Pilha antes de ordenar:");

        while(!pe.isEmpty()){
            System.out.print(pe.pop() + " "); //desempilha e imprime cada elemento da pilha
        }
        System.out.println();

        pe.push(1); //empilha novamente os valores na pilha
        pe.push(7);
        pe.push(4);
        pe.push(2);

        pe.ordenaPilha(); //ordena a pilha em ordem crescente
        System.out.println("Pilha depois de ordenar:");
        while(!pe.isEmpty()){
            System.out.print(pe.pop() + " "); //desempilha e imprime cada elemento da pilha ordenada
        }
        System.out.println();

    }
}