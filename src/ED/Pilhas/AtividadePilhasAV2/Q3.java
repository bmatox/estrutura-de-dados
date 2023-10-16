package ED.Pilhas.AtividadePilhasAV2;

//(PE) Desenvolva uma função para inverter a posição dos elementos de uma pilha P.
public class Q3 {
    int[] vetor;
    int topo; //onde o próximo elemento irá entrar, ou seja, o índice.

    public Q3(int tam) {
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

    public void imprimePilha() {
        int i = this.topo - 1; //cria uma variável i que recebe o valor do topo da pilha menos um
        while(i >= 0){ //enquanto i for maior ou igual a zero
            System.out.print(this.vetor[i] + " "); //imprime o elemento do vetor na posição i
            i--; //decrementa i
        }
        System.out.println(); //imprime uma quebra de linha
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

    public void invertePilha() {
        Q3 Q = new Q3(this.vetor.length); //cria uma pilha auxiliar Q do mesmo tamanho que P
        int x; //cria uma variável auxiliar x
        while(!this.isEmpty()){ //enquanto P não estiver vazia
            x = this.pop(); //desempilha um elemento de P e armazena em x
            Q.push(x); //empilha x em Q
        }
        while(!Q.isEmpty()){ //enquanto Q não estiver vazia
            x = Q.pop(); //desempilha um elemento de Q e armazena em x
            this.push(x); //empilha x em P
        }

    }

    public static void main(String[] args) {
        Q3 pe = new Q3(4);
        pe.push(1);
        pe.push(7);
        pe.push(4);
        pe.push(2);

        System.out.println("Pilha na ordem correta:");
        pe.imprimePilha(); //imprime a pilha na ordem correta

        pe.invertePilha(); //inverte a posição dos elementos da pilha
        System.out.println("Pilha na ordem inversa:");
        pe.imprimePilha(); //imprime a pilha na ordem inversa
    }

}