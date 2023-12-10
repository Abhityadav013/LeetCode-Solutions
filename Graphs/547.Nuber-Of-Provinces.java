// There are n cities. Some of them are connected, while some are not.
// If city a is connected directly with city b, and city b is connected directly with city c,
//  then city a is connected indirectly with city c.

// A province is a group of directly or indirectly connected cities and no other cities
// outside of the group.You are given an n x n matrix isConnected
// where isConnected[i][j] = 1 if the ith city and the jth city are directly connected,
// and isConnected[i][j] = 0 otherwise.

// Return the total number of provinces.


class Graph{
    int n;
    ArrayList<Integer> adj[];
    public Graph(int n){
        this.n = n;
        adj = new ArrayList[n];
        for(int i = 0 ; i< n; i++){
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdges(int src, int des){
        adj[src].add(des);
    }

    public void dfs(int src,boolean vis[]){
        if(vis[src] == true) return;

        vis[src] = true;
        for(int nbr:adj[src]){
            dfs(nbr,vis);
        }
    }

}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        Graph g = new Graph(n);

        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j< n; j++){
                 if(i !=j && isConnected[i][j] == 1 )
                g.addEdges(i , j);
            }
        }
        int component = 0;
        boolean vis[] =new boolean[n];
        for(int i = 0 ; i<n ; i++){
           if(vis[i] == true) continue;
           g.dfs(i,vis);
           component++;
        }
        return component;
    }
}