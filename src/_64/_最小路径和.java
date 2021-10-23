package cn.fangaoxs.day21._64;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/08/12:39
 * @Description:        https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class _最小路径和 {

    private int h;         //高
    private int w;          //宽
    private int[][] grid;
    private int[][] cache;      //缓存

    public int minPathSum(int[][] grid) {
        h = grid.length;
        w = grid[0].length;
        this.grid = grid;
        cache = new int[h][w];
        return dfs(0,0);    //返回起点[0,0]到终点[h-1,w-1]的最小路径
    }

    //返回[i,j]该点点到终点[h-1,w-1]的最小路径和
    private int dfs(int i,int j){
        //到达下右边界（不可能到达），返回无穷大
        if (i == h || j == w) return Integer.MAX_VALUE;
        //已经到达终点终点返回终点本身的路径
        if (i == h-1 && j == w-1)  return grid[h-1][w-1];
        //如果该点有缓存（不为0）直接取用
        if (cache[i][j]!=0) return cache[i][j];
        //下一点（往下或者往右）到终点的路径取最小
        int nextStepMinPath = Math.min(dfs(i + 1, j), dfs(i, j + 1));
        //当前点到终点的最小路径（下一点的最小路径与当前点数值和）
        int nowStepMinPath = nextStepMinPath + grid[i][j];
        //把当前点到终点的最小路径放置缓存中（便于后面取用）
        cache[i][j] = nowStepMinPath;
        return nowStepMinPath;
    }

}
