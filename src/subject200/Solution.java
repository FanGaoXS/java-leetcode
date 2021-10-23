package cn.fangaoxs.day7.subject200;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/25/17:07
 * @Description:
 */
public class Solution {
    public static int numIslands(char[][] grid) {
        int number = 0;
        //遍历整个二维数组
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]=='1'){   //如果有1则开始扩散（执行dfs）
                    number++;   //同时岛屿数量++
                    dfs(grid,i,j);
                }
            }
        }
        return number;
    }

    /**
     * 深度优先遍历，将所有遍历到的岛屿变成0
     */
    private static void dfs(char[][] grid,int i,int j){
        if ( (i<0)||(i >= grid.length)||
                (j<0)||(j >= grid[0].length||
                (grid[i][j]!='1'))){   //超出4个边界或已经为0了
            return;
        }
        grid[i][j] = '0';   //将扩散到的岛屿置为0（方便不再重复计算）
        dfs(grid,i,j+1);//向右
        dfs(grid,i+1,j);//向下
        dfs(grid,i,j-1);//向左
        dfs(grid,i-1,j);//向上
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'0','1','0','0','0'},
                {'0','1','0','0','0'},
                {'0','1','0','0','0'},
                {'0','1','0','0','0'},
                {'0','1','0','0','0'},
                {'0','1','0','0','0'},
        };
        int islands = numIslands(grid);
        System.out.println("islands = " + islands);
    }
}
