package subject79;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/11/12/20:28
 * @Description:
 */
public class Solution2 {

    private char[][] board;
    private int h;
    private int w;
    private String word;
    private boolean result = false;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.h = board.length;
        this.w = board[0].length;
        this.word = word;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (word.charAt(0) == board[i][j]) {
                    //如果word的第一个字母和网格中的字符相匹配，则开始dfs尝试搜索整个单词
                    dfs(i,j,0);
                    if (result) return true;
                }
            }
        }
        return false;
    }

    private void dfs(int i,int j,int n){
        //到达边界、word的指针超出范围、元素被访问过
        if (i == h
                || j == w
                || i < 0
                || j < 0
                || n == word.length()
                || board[i][j] == '0') return ;
        if (board[i][j] == word.charAt(n)) {    //如果该位置与word指针指向的字符相匹配
            //并且此时的字符已经与word的最后一个字符相匹配（说明该word存在于网格中）
            if (n == word.length()-1) {
                result = true;
                return;
            }
            char temp = board[i][j];
            board[i][j] = '0';  //该位置访问后就置为'0'
            dfs(i+1,j,n+1);
            dfs(i,j+1,n+1);
            dfs(i-1,j,n+1);
            dfs(i,j-1,n+1);
            board[i][j] = temp; //将该位置复原
        }
    }
}
