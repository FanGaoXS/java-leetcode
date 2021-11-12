package _64;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/11/11/19:18
 * @Description:
 */
public class Solution2 {

    private int m;
    private int n;
    private int[][] grid;
    //缓存（存放[i,j]点到终点的最短路径）
    private int[][] cache;

    public int minPathSum(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;
        this.cache = new int[m][n];
        return dfs(0,0);
    }

    //返回[i,j]点到终点的最短路径
    private int dfs(int i,int j){
        if (i == m || j == n) return Integer.MAX_VALUE;
        if (i == m-1 && j == n-1) return grid[i][j]; //到达终点时返回该终点的值
        if (cache[i][j]!=0) return cache[i][j];
        int nextMinPath = Math.min(dfs(i + 1, j), dfs(i, j + 1));
        int nowMinPath = nextMinPath + grid[i][j];
        cache[i][j] = nowMinPath;
        return nowMinPath;
    }

}
