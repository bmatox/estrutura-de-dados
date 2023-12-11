package ED.Hash; // Define o pacote do código

public class TabelaHash_OA { // Define a classe TabelaHash_OA
    private int size; // Define um atributo privado para o tamanho da tabela
    private Integer[] chaves; // Define um atributo privado para o vetor de chaves
    public TabelaHash_OA(int size) { // Define um construtor público que recebe o tamanho da tabela
        this.size = size; // Atribui o tamanho da tabela ao atributo size
        this.chaves = new Integer[size]; // Cria um vetor de Integer com o tamanho da tabela e atribui ao atributo chaves
    }
    private int hash(int chave) { // Define um método privado que calcula o valor de hash de uma chave
        return chave % size; // Retorna o resto da divisão da chave pelo tamanho da tabela
    }
    public void insert(int chave) { // Define um método público que insere uma chave na tabela
        int i = hash(chave); // Calcula o valor de hash da chave
        while (chaves[i] != null) { // Enquanto a posição da tabela estiver ocupada por outra chave
            i = (i + 1) % size; // Incrementa o valor de hash em uma unidade e aplica o módulo pelo tamanho da tabela
        }
        chaves[i] = chave; // Insere a chave na posição da tabela
    }
    public boolean search(int chave) { // Define um método público que busca uma chave na tabela
        int i = hash(chave); // Calcula o valor de hash da chave
        while (chaves[i] != null) { // Enquanto a posição da tabela não estiver vazia
            if (chaves[i] == chave) { // Se a posição da tabela contiver a chave buscada
                return true; // Retorna verdadeiro
            }
            i = (i + 1) % size; // Incrementa o valor de hash em uma unidade e aplica o módulo pelo tamanho da tabela
        }
        return false; // Retorna falso se não encontrar a chave na tabela
    }
    public void print() { // Define um método público que imprime a tabela
        for (int i = 0; i < size; i++) { // Percorre todas as posições da tabela
            System.out.println(i + ": " + chaves[i]); // Imprime o índice e a chave da posição
        }
    }


    public static void main(String[] args) { // Define o método principal que executa o código
        TabelaHash_OA th = new TabelaHash_OA(10); // Cria um objeto da classe TabelaHash_OA com tamanho 10
        th.insert(15); // Insere a chave 15 na tabela
        th.insert(25); // Insere a chave 25 na tabela
        th.insert(35); // Insere a chave 35 na tabela
        th.insert(45); // Insere a chave 45 na tabela
        th.insert(55); // Insere a chave 55 na tabela
        th.insert(65); // Insere a chave 65 na tabela
        th.insert(75); // Insere a chave 75 na tabela
        th.insert(85); // Insere a chave 85 na tabela
        th.insert(95); // Insere a chave 95 na tabela
        th.print(); // Imprime a tabela
        System.out.println(th.search(15)); // Busca a chave 15 na tabela e imprime o resultado
        System.out.println(th.search(25)); // Busca a chave 25 na tabela e imprime o resultado
        System.out.println(th.search(35)); // Busca a chave 35 na tabela e imprime o resultado
        System.out.println(th.search(45)); // Busca a chave 45 na tabela e imprime o resultado
        System.out.println(th.search(55)); // Busca a chave 55 na tabela e imprime o resultado
        System.out.println(th.search(65)); // Busca a chave 65 na tabela e imprime o resultado
        System.out.println(th.search(75)); // Busca a chave 75 na tabela e imprime o resultado
        System.out.println(th.search(85)); // Busca a chave 85 na tabela e imprime o resultado
        System.out.println(th.search(95)); // Busca a chave 95 na tabela e imprime o resultado
        System.out.println(th.search(5)); // Busca a chave 5 na tabela e imprime o resultado
        th.insert(5); // Insere a chave 5 na tabela
    }
}
