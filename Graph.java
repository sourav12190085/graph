import java.util.NoSuchElementException;
public class Graph {

    private final int V;       // number of vertices
    private int E;             // number of edges 
    private temp<Integer>[] adj;

    public Graph(int V) {
        if (V<=0)  throw new IllegalArgumentException("Vertex is less than or equal to 0");
        this.V=V;
        this.E=0;
        adj=(temp<Integer>[]) new temp[V];
        for(int i=0;i<V;i++){
            adj[i]=new temp<Integer>();
        }

    }
    public int V() {
       return V; 
    }

    public int E() {
        return E;
    }
  
    private void validateVertex(int v) {
        if(v<0 || v>=V)
        {
            throw new IllegalArgumentException("Vertex is not in range");
        }
    }
 
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        E++;
        adj[v].add(w);
        adj[w].add(v);


    }

    public Iterable<Integer> adj(int v) {
       validateVertex(v);
        return adj[v];
    }

 
    public String toString() {
        StringBuilder q = new StringBuilder();
        q.append(V + " Vertices, " + E + " Edges " + "\n");
        for (int v = 0; v < V; v++) {
            q.append(v + ": ");
            for (int w : adj[v]) {
                q.append(w + " ");
            }
            q.append("\n");
        }
        return q.toString();


    }
    public static void main(String[] args) {
   Graph test=new Graph(8);
    test.addEdge(0,1);
    test.addEdge(2,3);
    test.addEdge(3,4);
    test.addEdge(5,3);
    test.addEdge(4,2);
    test.addEdge(5,0);
    test.validateVertex(3);


    System.out.println(test.toString()); 
    System.out.println("All test Case Passed.");

   }

}
