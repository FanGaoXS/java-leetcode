package cn.fangaoxs.day32.subject695;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/19/22:35
 * @Description:
 */
class Solution {

    private int[][] grid;

    private int h; //高

    private int w; //宽

    private int maxArea;

    private int area;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.w = grid[0].length;
        this.h = grid.length;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == 1) {  //寻找为1的岛屿的起始点
                    area = 0;
                    dfs(i,j);
                    maxArea = Math.max(maxArea,area);
                }
            }
        }
        return maxArea;
    }

    private void dfs(int i,int j){
        //达到边界
        if (i < 0 || i >= h || j < 0 || j >= w || grid[i][j] == 0) {
            return;
        }
        if (grid[i][j] == 1) {
            area+=1;
            grid[i][j] = 0;       //访问后置为0
            dfs(i+1,j);         //向下
            dfs(i-1,j);         //向上
            dfs(i,j+1);         //向右
            dfs(i,j-1);         //向左
        }
    }

}

class Main {
    public static void main(String[] args) {
        int[][] grid = {
            {0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        Solution solution = new Solution();
        int maxAreaOfIsland = solution.maxAreaOfIsland(grid);
        System.out.println("maxAreaOfIsland = " + maxAreaOfIsland);
    }
}
