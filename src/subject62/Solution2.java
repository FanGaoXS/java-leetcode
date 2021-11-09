package subject62;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/11/09/17:54
 * @Description:
 */
public class Solution2 {
    public int uniquePaths(int m, int n) {
        //m是高，n是宽
        /*
            1   1   1   1   1   1   1
            1   2   3   4   5   6   7
            1   3   6   10  15  21  28
            [i,j]位置的数字为上和左的数字和
         */
        int[][] ints = new int[m][n];
        for (int i = 0; i < n; i++) {
            ints[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            ints[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ints[i][j] = ints[i-1][j] + ints[i][j-1];
            }
        }
        return ints[m-1][n-1];
    }
}
