package ED;

public class Vetor {
    private int tamanho; // o tamanho do vetor
    private double[] elementos; // o array que armazena os elementos do vetor

    // o construtor que recebe o tamanho do vetor e aloca dinamicamente o array
    public Vetor(int tamanho) {
        this.tamanho = tamanho; // atribui o tamanho ao atributo da classe
        this.elementos = new double[tamanho]; // cria um novo array de doubles com o tamanho especificado
    }

    // um método para obter o tamanho do vetor
    public int getTamanho() {
        return this.tamanho; // retorna o atributo tamanho
    }

    // um método para obter um elemento do vetor em uma posição específica
    public double getElemento(int posicao) {
        return this.elementos[posicao]; // retorna o elemento do array na posição indicada
    }

    // um método para alterar um elemento do vetor em uma posição específica
    public void setElemento(int posicao, double valor) {
        this.elementos[posicao] = valor; // atribui o valor ao elemento do array na posição indicada
    }

    // um método para imprimir os elementos do vetor na tela
    public void imprimir() {
        System.out.print("["); // imprime um colchete aberto
        for (int i = 0; i < this.tamanho; i++) { // percorre todos os elementos do array
            System.out.print(this.elementos[i]); // imprime o elemento na posição i
            if (i < this.tamanho - 1) { // se não for o último elemento
                System.out.print(", "); // imprime uma vírgula e um espaço
            }
        }
        System.out.println("]"); // imprime um colchete fechado e uma quebra de linha
    }

    // uma função que soma todos os elementos do vetor
    public double somaElementos() {
        double soma = 0; // uma variável para armazenar a soma
        for (int i = 0; i < this.tamanho; i++) { // percorre todos os elementos do array
            soma += this.elementos[i]; // adiciona o elemento na posição i à soma
        }
        return soma; // retorna a soma
    }

    // uma função que multiplica todos os elementos do vetor pelo elemento n
    public void multiplicaVetor(int n) {
        for (int i = 0; i < this.tamanho; i++) { // percorre todos os elementos do array
            this.elementos[i] *= n; // multiplica o elemento na posição i pelo valor de n
        }
    }

    // uma função que eleva todos os elementos do vetor ao quadrado
    public void quadradosVetor() {
        for (int i = 0; i < this.tamanho; i++) { // percorre todos os elementos do array
            this.elementos[i] = Math.pow(this.elementos[i], 2); // eleva o elemento na posição i ao quadrado usando a classe Math
        }
    }

    // uma função que soma os elementos do vetor atual aos do vetor v
    public Vetor somaVetor(Vetor v) {
        if (this.tamanho == v.getTamanho()) { // verifica se os dois vetores têm o mesmo tamanho
            Vetor resultado = new Vetor(this.tamanho); // cria um novo objeto da classe Vetor com o mesmo tamanho dos vetores originais
            for (int i = 0; i < this.tamanho; i++) { // percorre todos os elementos dos arrays
                resultado.setElemento(i, this.elementos[i] + v.getElemento(i)); // atribui a soma dos elementos na posição i dos dois vetores ao elemento correspondente do vetor resultado
            }
            return resultado; // retorna o vetor resultado
        } else { // se os dois vetores não têm o mesmo tamanho
            return null; // retorna null para indicar que não é possível somar os vetores
        }
    }


    public static void main(String[] args) {
        // cria um objeto da classe Vetor com tamanho 5
        Vetor v = new Vetor(5);

        // atribui alguns valores aos elementos do vetor
        v.setElemento(0, 1.2);
        v.setElemento(1, 3.4);
        v.setElemento(2, 5.6);
        v.setElemento(3, 7.8);
        v.setElemento(4, 9.0);

        // imprime o tamanho e os elementos do vetor
        System.out.println("O tamanho do vetor é: " + v.getTamanho());
        System.out.println("Os elementos do vetor são:");
        v.imprimir();
    }
}
