package aprendendo_listas;

public class No<T> { //esse <T> faz com que a lista seja tipada de forma genérica, tendo em vista que não se sabe p tipo do elemento que está sendo trabalhado na lista.

    private T elemento;
    private No<T> proximo;

    public No(T elemento) {
        this.elemento = elemento;
        this.proximo = null; // o último elemento da lista sempre vai ter o próximo com o valor de nulo.
    }

    public No(T elemento, No<T> proximo) {
        this.elemento = elemento;
        this.proximo = proximo;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public No<T> getProximo() {
        return proximo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "No{" +
                "elemento=" + elemento +
                ", proximo=" + proximo +
                '}';
    }
}
