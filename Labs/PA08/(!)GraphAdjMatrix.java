import java.util.*;

public class GraphAdjMatrix implements Graph{
    int n;
    boolean visited[];
    List<Integer> g[];
    List<Integer> ans;
    public GraphAdjMatrix(int n){
        this.n = n;
        g = new List[n];
        visited = new boolean[n];
        ans = new ArrayList<Integer>();
        for(int i = 0;i < n;++i){
            g[i] = new ArrayList<Integer>();
            visited[i] = false;
        }
    }
    public void addEdge(int v1, int v2){
        g[v1].add(v2);
    }
	public void topologicalSort(){
	    for(int i = 0;i < n;++i)
	        if(visited[i] == false)
	            dfs(i);
	    for(int i = n-1;i >= 0;--i)
	        System.out.print(ans.get(i) + " ");
	    System.out.println();
	}
	void dfs(int index){
	    visited[index] = true;
	    for(int i = 0;i < g[index].size();++i)
	        if(visited[g[index].get(i)] == false)
	            dfs(g[index].get(i));
	    ans.add(index);
	}
	public int[] neighbors(int vertex){
	    int n =  g[vertex].size();
	    int ans[] = new int[n];
	    for(int i = 0;i < n;++i)
	        ans[i] = g[vertex].get(i);
	    return ans;
	}
}