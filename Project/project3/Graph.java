
import java.util.*;

public class Graph<V, E> {

    private HashMap<V, List<Edge<V, E>>> map;

    public Graph() {
        this.map = new HashMap<>();
    }

    // add undirected edges
    public void addEdge(V src, V dir, E edge) {
        ArrayList<Edge<V, E>> list = new ArrayList<>();
        if(map.containsKey(src)) {
            map.get(src).add(new Edge<>(src, dir, edge));
        } else {
            list.add(new Edge<>(src, dir, edge));
            map.put(src, list); 
        }
            
    }

    public boolean contain(V src) {
        return map.containsKey(src);
    }

    /* 
        Find shortest path
    *   BFS implement
    * 
    */
    public List<V> findShortest(V src, V dir) {
        List<V> curResult = new ArrayList<>();
        if (src.equals(dir)) {
            curResult.add(dir);
            return curResult;
        }

        Queue<HashMap<V, List<V>>> queue = new LinkedList<>();
        HashMap<V, List<V>> tmp = new HashMap<V, List<V>>();
        tmp.put(src, curResult);
        queue.add(tmp);

        Set<V> visited = new HashSet<>();

        while (!queue.isEmpty()) {
        		HashMap<V, List<V>> node = queue.poll();
        		for(V key: node.keySet()) {
        			if (!map.containsKey(key) || visited.contains(key)) {
        				continue;
        			}
	        		
		            visited.add(key);
		            for (Edge<V, E> edge: map.get(key)) {
		                List<V> newCurResult  = new ArrayList<>(node.get(key));
		                newCurResult.add(edge.dir);
		                if (edge.dir.equals(dir)) {
		                    return newCurResult;
		                } else {
		                	HashMap<V, List<V>> tmpNew = new HashMap<V, List<V>>();
		                    tmpNew.put(edge.dir, newCurResult);
		                    queue.add(tmpNew);
		                }
		            }
        		}
        }
        return null;
    }
}