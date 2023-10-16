package ED.Pilhas.AtividadePilhasAV2;

//(PE) Desenvolva uma função para testar se duas pilhas P1 e P2 são iguais
public class Q5 {
    int[] vetor;
    int topo; //onde o próximo elemento irá entrar, ou seja, o índice.

    public Q5(int tam) {
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

    public boolean pilhasIguais(Q5 P2) {
        if (this.topo != P2.topo) { //se P1 e P2 tiverem tamanhos diferentes
            return false; //retorna falso
        }
        int i = this.topo - 1; //cria uma variável i que recebe o valor do topo de P1 menos um
        int j = P2.topo - 1; //cria uma variável j que recebe o valor do topo de P2 menos um
        while(i >= 0 && j >= 0){ //enquanto i e j forem maiores ou iguais a zero
            if (this.vetor[i] != P2.vetor[j]) { //se o elemento do vetor de P1 na posição i for diferente do elemento do vetor de P2 na posição j
                return false; //retorna falso
            }
            i--; //decrementa i
            j--; //decrementa j
        }
        return true; //retorna verdadeiro
    }


    public void invertePilha() {
        Q5 Q = new Q5(this.vetor.length); //cria uma pilha auxiliar Q do mesmo tamanho que P
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
        Q5 P1 = new Q5(4); //cria uma pilha P1 de tamanho 4
        Q5 P2 = new Q5(4); //cria uma pilha P2 de tamanho 4

        P1.push(1); //empilha alguns valores em P1
        P1.push(7);
        P1.push(4);
        P1.push(2);

        P2.push(1); //empilha alguns valores em P2
        P2.push(7);
        P2.push(4);
        P2.push(2);

        System.out.println("P1 e P2 são iguais? " + P1.pilhasIguais(P2)); //chama o método pilhasIguais() passando P2 como parâmetro e imprime o resultado
    }


}