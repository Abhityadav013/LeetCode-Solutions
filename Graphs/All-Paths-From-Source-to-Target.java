// Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1,
//  find all possible paths from node 0 to node n - 1 and return them in any order.
// The graph is given as follows: graph[i] is a list of all nodes you can visit from 
// node i (i.e., there is a directed edge from node i to node graph[i][j]).


class Solution {
    public List<List<Integer>> allPaths = new ArrayList<>();

    public void getPath(int src,int des, int[][]graph,List<Integer>path){
        path.add(src);
        if(src == des){
            allPaths.add(new ArrayList<>(path));
        }

        for(int nbr: graph[src]){
            getPath(nbr,des,graph,path);
        }
        path.remove(path.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        getPath(0,n-1,graph,new ArrayList<>());
        return allPaths;
    }
}