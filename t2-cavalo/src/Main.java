public class Main {
    public static void main(String[] args) {
        
        // Ler arquivo
        In in = new In("dados/entrada.txt");
        Graph G = new Graph(in);

        // 1. Lista de adjacência
        StdOut.println("Lista de adjacência:");
        for (int v = 0; v < G.V(); v++) {
            StdOut.print(v + ": ");
            for (int w : G.adj(v)) {
                StdOut.print(w + " ");
            }
            StdOut.println();
        }

        // 2. Componentes conexas
        CC cc = new CC(G);
        int numComponentes = cc.count();

        StdOut.println("\nComponentes conexas: " + numComponentes);

        for (int i = 0; i < numComponentes; i++) {
            StdOut.print("Vértices da componente " + i + ": ");
            for (int v = 0; v < G.V(); v++) {
                if (cc.id(v) == i) {
                    StdOut.print(v + " ");
                }
            }
            StdOut.println();
        }

        // 3. Distância mínima (0,0) -> (2,2)
        // (0,0) = 0
        // (2,2) = 8
        int origem = 0;
        int destino = 8;

        BreadthFirstPaths bfs = new BreadthFirstPaths(G, origem);

        StdOut.println("\nDistância mínima de 0 até 8: " + bfs.distTo(destino));

        // 4. Verificar ciclo
        Cycle cycle = new Cycle(G);

        if (cycle.hasCycle()) {
            StdOut.println("\nO grafo possui ciclo: Sim");

            StdOut.print("Um ciclo encontrado: ");
            for (int v : cycle.cycle()) {
                StdOut.print(v + " ");
            }
            StdOut.println();

        } else {
            StdOut.println("\nO grafo possui ciclo: Não");
        }

        // 5. Complexidade (explicação simples)
        StdOut.println("\nAnálise de complexidade:");
        StdOut.println("BFS: O(V + E)");
        StdOut.println("CC: O(V + E)");
        StdOut.println("Cycle: O(V + E)");
        StdOut.println("Espaço: O(V)");
    }
}