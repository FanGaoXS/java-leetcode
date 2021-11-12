package _64;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/11/10/18:27
 * @Description:        超时
 */
public class Solution {

    private int m;
    private int n;
    private int[][] grid;
    private int sum = 0;
    private int result = Integer.MAX_VALUE;

    public int minPathSum(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;
        dfs(0,0);
        return result;
    }

    private void dfs(int i,int j){
        if (i >= m || j >= n) return;
        sum += grid[i][j];
        if (i == m-1 && j == n-1) {
            result = Math.min(result,sum);
        }
        dfs(i+1,j);
        dfs(i,j+1);
        sum -= grid[i][j];
    }

}

