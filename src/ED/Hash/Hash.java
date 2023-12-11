package ED.Hash;

class Hash {
    private int[] vet1;

    public Hash (int tam) {
        this.vet1 = new int[tam];
    }

    public int hashFunc(int chave){
        return chave%vet1.length;
    }

    public void insere(int chave){
        int posicao = this.hashFunc(chave);
        this.vet1[posicao] = chave;
    }

    public String toString(){
        String str = "";
        for(int i = 0; i < vet1.length; i++) {
            str += vet1[i] + ", ";
        }
        return str;
    }
    public static void main(String[] args) {
        Hash h1 = new Hash(8);
        System.out.println(h1.hashFunc(64));
        h1.insere(64);
        h1.insere(45);
        System.out.println(h1.toString());
    }
}