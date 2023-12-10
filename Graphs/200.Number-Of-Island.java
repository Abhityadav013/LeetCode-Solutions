//Question Link:---->https://leetcode.com/problems/number-of-islands/description/

// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
// return the number of islands.

// An island is surrounded by water and is formed by connecting adjacent lands
// horizontally or vertically. You may assume all four edges of the grid are all surrounded
// by water.

class Solution {
    int dr[] = {-1,1 ,0 ,0};
    int dc[] = {0 ,0 ,-1 ,1};
    public void dfs(char grid[][], int r ,int c){
        if(r < 0 || c < 0|| r >= grid.length || c>=grid[0].length) return;

        if(grid[r][c] == '0' || grid[r][c] == '2') return;

        grid[r][c] = '2';
        for(int i= 0 ; i< 4 ; i++){
            dfs(grid,r +dr[i], c + dc[i]);
        }

        // dfs(grid,r-1,c);
        // dfs(grid,r+1,c);
        // dfs(grid,r,c-1);
        // dfs(grid,r,c+1);
    }
    public int numIslands(char[][] grid) {
        int isIsland = 0;
        for(int i = 0 ; i <grid.length;i++){
            for(int j = 0 ; j < grid[0].length;j++){
                if(grid[i][j]=='1'){
                    isIsland++;
                    dfs(grid,i,j);
                }
            }
        }
        return isIsland;
    }
}