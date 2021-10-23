package cn.fangaoxs.day29.subject240;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/17/10:23
 * @Description:
 *                  240. 搜索二维矩阵 II
 *                  https://leetcode-cn.com/problems/search-a-2d-matrix-ii/submissions/
 */
public class Solution {

    private int[][] matrix;
    private int target;
    private int m;
    private int n;

    public boolean searchMatrix(int[][] matrix, int target) {
        this.matrix = matrix;
        this.target = target;
        m = matrix.length;
        n = matrix[0].length;
        return dfs(0,n-1);
    }

    //返回[i,j]是否等于target
    private boolean dfs(int i,int j){
        //越界或者被访问过
        if (i >= m || j <0 || matrix[i][j] == Integer.MIN_VALUE) return false;
        //如果目标值大于当前方格中的值则向下移动
        if (target > matrix[i][j]) {
            return dfs(i + 1, j);
        } else if (target < matrix[i][j]) {
            return dfs(i, j - 1);
        } else {
            return true;
        }
    }

}
