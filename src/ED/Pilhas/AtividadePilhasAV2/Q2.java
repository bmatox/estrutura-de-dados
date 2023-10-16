package ED.Pilhas.AtividadePilhasAV2;
//(PD) Dado uma pilha que armazene numeros, escreva uma função que forneça o maior, o menor e a media aritmética dos elementos da pilha.
public class Q2 {

    class No {
        private int valor;
        private No prox;

        public No(int valor) {
            this.valor = valor;
            this.prox = null;
        }

        public int getValor() {
            return valor;
        }

        public void setValor(int valor) {
            this.valor = valor;
        }

        public No getProx() {
            return prox;
        }

        public void setProx(No no) {
            this.prox = no;
        }
    }

    private No topo;
    private int tamanho;

    public Q2() {
        this.topo = null;
        this.tamanho = 0;
    }

    public No getTopo() {
        return topo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean isEmpty(){
        return this.topo == null;
    }

    public void push(int valor) {
        No no = new No(valor);
        no.setProx(this.topo);
        this.topo = no;
        this.tamanho++;
    }

    public int pop() {
        if(this.isEmpty()){
            System.out.println("Pilha está vazia!!!");
            return -1;
        }
        int tmp = this.topo.getValor();
        this.topo = this.topo.getProx();
        this.tamanho--;
        return tmp;
    }

    public void imprimePilha(){
        if(this.isEmpty()){
            System.out.println("Pilha vazia!!");
            return;
        }
        No no = this.topo;
        System.out.print("Elementos da pilha dinâmica: {");
        while (no.getProx() != null){
            System.out.print(no.getValor() + ", ");
            no = no.getProx();
        }
        System.out.print(no.getValor() + "}");
    }

    public void estatisticasPilha() {
        int max = this.topo.getValor(); //cria uma variável max que recebe o valor do topo da pilha
        int min = this.topo.getValor(); //cria uma variável min que recebe o valor do topo da pilha
        int soma = this.topo.getValor(); //cria uma variável soma que recebe o valor do topo da pilha
        double media = 0; //cria uma variável media que recebe zero
        No no = this.topo; //cria uma variável no que recebe o nó do topo da pilha
        while(no != null){ //enquanto no não for nulo
            if (no.getValor() > max) { //se o valor de no for maior que max
                max = no.getValor(); //atualiza max com esse valor
            }
            if (no.getValor() < min) { //se o valor de no for menor que min
                min = no.getValor(); //atualiza min com esse valor
            }
            soma += no.getValor(); //soma o valor de no à soma
            no = no.getProx(); //atualiza no com o próximo nó da pilha
        }
        media = (double) soma / this.tamanho; //calcula a média dividindo a soma pelo tamanho da pilha
        System.out.println("Maior: " + max); //imprime o maior valor da pilha
        System.out.println("Menor: " + min); //imprime o menor valor da pilha
        System.out.println("Média: " + media); //imprime a média aritmética dos valores da pilha
    }



    public static void main(String[] args) {
        Q2 P = new Q2(); //cria uma pilha P

        P.push(5); //empilha alguns valores em P
        P.push(3);
        P.push(11);
        P.push(2);

        P.imprimePilha(); //imprime a pilha
        System.out.println();
        System.out.println("\nEstatísticas:");
        P.estatisticasPilha(); //chama o método estatisticasPilha() e imprime os resultados
    }

}

