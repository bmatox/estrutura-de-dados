package ED.Hash;

import  java.util.List;
import  java.util.ArrayList;

class TabelaHash_CA {
    List[] lista;

    public TabelaHash_CA(int n){
        this.lista = new List[n];
        for(int i = 0; i < n; i++){
            this.lista[i] = new ArrayList();
        }
    }

    public int hashFunc(int chave){
        return chave%this.lista.length;
    }

    public void insere(int chave){
        int pos = this.hashFunc(chave);
        this.lista[pos].add(chave);
    }

    public String toString(){
        String str = "";
        for(int i = 0; i < this.lista.length; i++){
            str += "Index: "+i+" - " + this.lista[i] + "\n";
        }
        return str;
    }

    public int buscaChave(int chave){
        int pos = this.hashFunc(chave);
        ArrayList l1 = (ArrayList) lista[pos];
        //for(List l1 : lista[pos]){
        for(int i = 0; i < l1.size(); i++){
            if(l1.get(i).equals(chave)){
                return pos;
            }
        }
        //}
        return -1;
    }
    public static void main(String[] args) {
        TabelaHash_CA hash = new TabelaHash_CA(5);
        System.out.println(hash.hashFunc(18));
        hash.insere(20);
        hash.insere(25);
        hash.insere(18);
        hash.insere(20);
        System.out.println(hash.toString());
        System.out.println(hash.buscaChave(11));
    }
}