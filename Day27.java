import java.util.*;

public class ShortestPathUnweightedGraph {

    // Function to find shortest path using BFS
    public static int shortestPath(int V, List<List<Integer>> adj, int start, int end) {
        // If start and end are same
        if (start == end) return 0;

        boolean[] visited = new boolean[V];
        int[] distance = new int[V]; // distance from start

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[node] + 1;
                    queue.add(neighbor);

                    // If destination reached
                    if (neighbor == end) {
                        return distance[neighbor];
                    }
                }
            }
        }
        return -1; // no path found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter edges (u v):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u); // undirected graph
        }

        System.out.print("Enter start node: ");
        int start = sc.nextInt();

        System.out.print("Enter end node: ");
        int end = sc.nextInt();

        int result = shortestPath(V, adj, start, end);
        System.out.println("Shortest Path Length: " + result);

        sc.close();
    }
}
