package cn.fangaoxs.day20.subject62;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/07/13:08
 * @Description:
 */
class Solution {

    public static int uniquePaths(int m, int n) {
        // m宽
        // n高
        //          1   1   1   1   1   1   1
        //          1   2   3   4   5   6   7
        //          1   3   6   10  15  21  28
        // 每个位置的路径为左方和上方的数字和
        int[][] res = new int[n][m];
        for (int i = 0; i < m; i++) {   //第一横行赋值1
            res[0][i] = 1;
        }
        for (int i = 0; i < n; i++) {   //第一竖列赋值1
            res[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                res[i][j] = res[i-1][j] + res[i][j-1];
            }
        }
        return res[n-1][m-1];   //返回右下角的元素
    }

    public static void main(String[] args) {
        int m = 7;
        int n = 3;
        int paths = uniquePaths(m, n);
        System.out.println("paths = " + paths);
    }
}
