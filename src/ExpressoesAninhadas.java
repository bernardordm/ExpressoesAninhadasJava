public static final class No<T> {
    private T valor;
    private No<T> proximo;

    public No(T valor) {
        this.valor = valor;
        this.proximo = null;
    }
}

public static final class Pilha<T> {
    private No<T> topo;

    public Pilha() {
        this.topo = null;
    }

    public void push(T valor) {
        No<T> novoNo = new No<>(valor);
        novoNo.proximo = topo;
        topo = novoNo;
    }

    public T pop() {
        if (topo == null) {
            throw new RuntimeException("Pilha vazia");
        }
        T valor = topo.valor;
        topo = topo.proximo;
        return valor;
    }

    public boolean isEmpty() {
        return topo == null;
    }
}