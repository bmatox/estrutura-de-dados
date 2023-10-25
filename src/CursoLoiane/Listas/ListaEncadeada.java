package CursoLoiane.Listas;

public class ListaEncadeada <T> {

    private No<T> inicio; // primeira referencia
    private No<T> ultimo; // segunda referencia
    private int tamanho;


    public int getTamanho(){ //retorna o tamanho da lista
        return this.tamanho;
    }

    public void adiciona(T elemento){
        No<T> celula = new No<T>(elemento);
        if (tamanho == 0){
            this.inicio = celula; // inicio apontando para o primeiro elemento criado.
        } else {
            this.ultimo.setProximo(celula); // apontando para a proxima celular sempre que nao cai no if (tamanho diferente de 0)
        }
        this.ultimo = celula; // final apontando para a referencia do primeiro elemento criado (considerando apenas um nó criado) OU para a referencia do ultimo elemento (proximo).
        this.tamanho++; //incrimenta uma unidade à variavel tamanho, sempre que o metodo é solicitado na main
    }

    public void limpa(){ // remover todos os elementos da lista pelo método mais simples
        this.inicio = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public void limpaV2(){ // remover todos os elementos da lista pelo método "mais correto"
        //não necessário
    }

    public void removeNoinicio(){ // metodo para remover no inicio (implementado pelo professor).
        if (this.tamanho == 0){
            System.out.println("Lista vazia.");
        } else {
            System.out.println("Removido o número: " + this.inicio.getElemento() + " da lista.");
            this.inicio = this.inicio.getProximo();
            tamanho--;
        }
    }

    public void removeNoFim() {
        if (this.tamanho == 0) { // verifica se a lista está vazia
            System.out.println("Lista vazia.");
        }
        No<T> atual = this.inicio; // variável auxiliar para percorrer a lista
        No<T> anterior = null; // variável auxiliar para guardar o nó anterior
        while (atual.getProximo() != null) { // enquanto não chegar ao fim da lista
            anterior = atual; // guarda o nó atual como anterior
            atual = atual.getProximo(); // avança para o próximo nó
        }
        // nesse ponto, atual é o último nó e anterior é o penúltimo
        if (anterior == null) { // se a lista tem apenas um elemento
            this.inicio = null; // remove a referência ao início
            this.ultimo = null; // remove a referência ao último
        } else { // se a lista tem mais de um elemento
            anterior.setProximo(null); // remove a referência ao último nó (remove o nó)
            this.ultimo = anterior; // atualiza a referência ao último nó
        }
        this.tamanho--; // decrementa o tamanho da lista
    }

    public void buscarElemento(T elemento) {
        int pos = 0; // variável para armazenar a posição do elemento
        No<T> atual = this.inicio; // variável auxiliar para percorrer a lista
        while (atual != null) { // enquanto não chegar ao fim da lista
            // se o elemento do nó atual é igual ao elemento buscado
            if (atual.getElemento().equals(elemento)){
                System.out.println("O valor existe na lista e está na posição: " + pos + " da lista");
            }
            pos++; // incrementa a posição em uma unidade
            atual = atual.getProximo(); // avança para o próximo nó
        }
    }

    public T removerNaPosicao(int posicao) {
        if (this.tamanho == 0) { // verifica se a lista está vazia
            return null; // ou lança uma exceção
        }

        No<T> atual = this.inicio; // variável auxiliar para percorrer a lista
        No<T> anterior = null; // variável auxiliar para guardar o nó anterior
        while (posicao > 1) { // enquanto não chegar à posição desejada
            anterior = atual; // guarda o nó atual como anterior
            atual = atual.getProximo(); // avança para o próximo nó
            posicao--; // decrementa a posição em uma unidade
        }
        // nesse ponto, anterior é o nó anterior à posição desejada e atual é o nó na posição desejada
        anterior.setProximo(atual.getProximo()); // remove a referência ao nó na posição desejada
        if (atual == this.ultimo) { // se o nó na posição desejada for o último nó da lista
            this.ultimo = anterior; // atualiza a referência ao último nó da lista
        }
        this.tamanho--; // decrementa o tamanho da lista
        return atual.getElemento(); // retorna o elemento removido
    }

    public boolean adicionarNaPosicao(T elemento, int posicao) {
        No<T> novo = new No<T>(elemento); // cria um novo nó com o elemento
        if (this.tamanho == 0) { // verifica se a lista está vazia
            this.inicio = novo; // insere o novo nó no início da lista
            this.ultimo = novo; // atualiza a referência ao último nó
            this.tamanho++; // incrementa o tamanho da lista
            return true; // retorna true para indicar sucesso
        }

        No<T> atual = this.inicio; // variável auxiliar para percorrer a lista
        No<T> anterior = null; // variável auxiliar para guardar o nó anterior
        while (posicao > 1) { // enquanto não chegar à posição desejada
            anterior = atual; // guarda o nó atual como anterior
            atual = atual.getProximo(); // avança para o próximo nó
            posicao--; // decrementa a posição em uma unidade
        }
        // nesse ponto, anterior é o nó anterior à posição desejada e atual é o nó na posição desejada
        novo.setProximo(atual); // liga o novo nó ao nó na posição desejada
        anterior.setProximo(novo); // liga o nó anterior ao novo nó
        this.tamanho++; // incrementa o tamanho da lista
        return true; // retorna true para indicar sucesso
    }



    @Override
    public String toString() {
        return "ListaEncadeada{" +
                "inicio = " + inicio +
                '}';
    }
}
