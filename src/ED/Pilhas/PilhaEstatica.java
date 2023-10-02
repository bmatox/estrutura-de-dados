package ED.Pilhas;

public class PilhaEstatica {
    String[] vetor;
<<<<<<< HEAD
    int topo;
=======
    int topo; //onde o próximo elemento irá entrar, ou seja, o índice.
>>>>>>> b334af9 (Modificações na classe PilhaEstatica.java)

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

    public static void main(String[] args) {
        PilhaEstatica pe = new PilhaEstatica(5);
        System.out.println(pe.toString());

    }
}