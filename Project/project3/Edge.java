
public class Edge<V, E> {
    V src;
    V dir;
    E cost;

    public Edge(V src, V dir, E cost) {
        this.src = src;
        this.dir = dir;
        this.cost = cost;
    }
}