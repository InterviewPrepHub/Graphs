package com.example.GraphSeries.ConnectedComponent;

public class CountNumberOfIslands {

    public static void main(String[] args) {
        char[][] islands = {{'1', '1', '0', '0', '0'},
                            {'1', '1', '0', '0', '0'},
                            {'0', '0', '1', '0', '0'},
                            {'0', '0', '0', '1', '1'}};

        CountNumberOfIslands c = new CountNumberOfIslands();
        int count = c.noOfIslands(islands);
        System.out.println(count);

    }

    private int noOfIslands(char[][] grid) {

        if(grid.length == 0 || grid == null) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        int count = 0;
        int largestIsland = Integer.MIN_VALUE;

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    int islandSize = drawTreeForComponent(i,j,grid,visited);
                    count++;
                    largestIsland = Math.max(largestIsland, islandSize);
                }
            }
        }

        System.out.println("largest island size :");

        return count;
    }

    private int drawTreeForComponent(int i, int j, char[][] grid, boolean[][] visited) {

        if (i<0 || i>=grid.length || j<0 || j>=grid[0].length || visited[i][j] == true || grid[i][j] == '0') {
            return 0;
        }

        visited[i][j] = true;

        int size = 1;

        size += drawTreeForComponent(i-1, j, grid, visited);
        size += drawTreeForComponent(i, j+1, grid, visited);
        size += drawTreeForComponent(i, j-1, grid, visited);
        size += drawTreeForComponent(i+1, j, grid, visited);

        return size;
    }
}
