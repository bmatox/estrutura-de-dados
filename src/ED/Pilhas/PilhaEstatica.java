package ED.Pilhas;

public class PilhaEstatica {
    String[] vetor;
    int topo;

    public PilhaEstatica(int tam) {
        this.vetor = new String[tam];
        this.topo = 0;
    }

    public boolean isEmpty(){
        return this.topo == 0;
    }

    public static void main(String[] args) {
        PilhaEstatica pe = new PilhaEstatica(5);
        System.out.println(pe.toString());

    }
}