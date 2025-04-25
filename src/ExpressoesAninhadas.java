public class ExpressoesAninhadas {
    public static void main(String[] args) {
        String expressao = "{[()]}";
        System.out.println("Expressão: " + expressao);
        System.out.println("Resultado: " + verificaExpressao(expressao));
    }

    public static boolean verificaExpressao(String expressao) {
        Pilha<Character> pilha = new Pilha<>();

        for (char c : expressao.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                pilha.push(c);
            } else if (c == '}' || c == ']' || c == ')') {
                if (pilha.isEmpty()) {
                    return false;
                }
                char topo = pilha.pop();
                if (!verificaParenteses(topo, c)) {
                    return false;
                }
            }
        }
        return pilha.isEmpty();
    }

    private static boolean verificaParenteses(char aberto, char fechado) {
        return (aberto == '{' && fechado == '}') ||
               (aberto == '[' && fechado == ']') ||
               (aberto == '(' && fechado == ')');
    }

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
}