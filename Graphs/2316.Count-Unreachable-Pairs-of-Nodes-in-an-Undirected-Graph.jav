//Question Link:----> https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/description/


// You are given an integer n. There is an undirected graph with n nodes, numbered from 0 to n - 1.
// You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that
// there exists an undirected edge connecting nodes ai and bi.

// Return the number of pairs of different nodes that are unreachable from each other.


class Graph{
    int n;
    ArrayList<Integer> adj[];
    public Graph(int n){
        this.n = n;
        adj = new ArrayList[n];
        for(int i = 0 ; i<n ; i++){
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdges(int src , int des){
        adj[src].add(des);
        adj[des].add(src);
    }

    public long dfs(int src ,boolean vis[]){
        if(vis[src] == true) return 0;
        long size = 1;
        vis[src] = true;
        for(int nbr:adj[src]){
            size += dfs(nbr,vis);
        }
        return size;
    }
}
class Solution {
    public long countPairs(int n, int[][] edges) {
        Graph g = new Graph(n);
        for(int edge[]:edges){
            g.addEdges(edge[0],edge[1]);
        }

        boolean vis[] = new boolean[n];
        long ans = 0;
        for(int i = 0 ; i <n ; i++){
            long size = g.dfs(i,vis);
            ans += size * (n - size);
        }
        return ans/2;
    }
}