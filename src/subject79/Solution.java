package cn.fangaoxs.day22.subject79;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/10/0:39
 * @Description:
 */
public class Solution {

    private int w;  //宽
    private int h;  //高
    private char[][] board;
    private String word;

    public boolean exist(char[][] board, String word) {
        w = board[0].length;
        h = board.length;
        this.word = word;
        this.board = board;
        boolean result;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (word.charAt(0) == board[i][j]) {
                    //寻找board数组中与word的第一个字符相匹配的左边，然后开始遍历
                    result = dfs(i,j,0);
                    if (result){
                        return true;
                    }
                }

            }
        }
        return false;
    }

    private boolean dfs(int i,int j,int n){
        if (i < 0
            || i >= h
            || j < 0
            || j >= w
            || n >= word.length()
            || board[i][j] == '0'){
            //越界或者board已经被访问过
            return false;
        }
        if (word.charAt(n) == board[i][j] ){
            board[i][j] = '0'; //如果访问了则改为0（方便后续判断是否访问过）
            if ( n == word.length()-1) return true; //如果已经访问到了word的最后一个字符（说明全部匹配）
            boolean resultUp = dfs(i - 1, j, n + 1);      //向上继续遍历（并且匹配word中下一个字符）
            boolean resultDown = dfs(i + 1, j, n + 1);    //向下继续遍历
            boolean resultLeft = dfs(i, j - 1, n + 1);    //向左继续遍历
            boolean resultRight = dfs(i, j + 1, n + 1);   //向右继续遍历
            board[i][j] = word.charAt(n);                           //遍历完后切记一定要将改为0的字符复原
            //最后返回该点的访问匹配结果（只要有一个为true就行）
            return resultUp || resultDown || resultLeft || resultRight;
        }
        return false;
    }
}
