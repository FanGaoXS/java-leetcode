package cn.fangaoxs.day2.subject54;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/21/0:25
 * @Description:
 */
class Solution {

    public static void main(String[] args) {
        int[][] matrix = { {1,2,3,4},{5,6,7,8},{9,10,11,12} };
        List<Integer> integers = spiralOrder2(matrix);
        System.out.println("integers = " + integers);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length;
        int bottom = matrix.length;
        int top = 0;
        int direction = 0;
        while ( (left<right)&&(top<bottom) ){
            if (direction == 0){
                // 右移动
                for (int i = left; i < right; i++) {
                    result.add(matrix[top][i]);
                }
                top++;
                direction = 1; //接下来往下
            } else if (direction == 1){
                // 下移动
                for (int i = top; i < bottom; i++) {
                    result.add(matrix[i][right-1]);
                }
                right--;
                direction = 2; //接下来往左
            } else if (direction == 2){
                //左移动
                for (int i = right-1; i >= left; i--) {
                    result.add(matrix[bottom-1][i]);
                }
                bottom--;
                direction = 3; //接下来往上
            } else if (direction == 3) {
                //上移动
                for (int i = bottom-1; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
                direction = 0;
            }
        }
        return result;
    }

    public static List<Integer> spiralOrder2(int[][] matrix) {
        int up = 0;
        int down = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        int size = (down+1) * (right+1);
        ArrayList<Integer> integers = new ArrayList<>();
        int i = 0;
        int j = 0;
        int duration = 1;
        while (integers.size() != size) {
            if (duration == 1) {            //向右走
                integers.add(matrix[i][j]);
                if (j == right) {
                    duration = 2;
                    up++;
                    i = up;
                } else {
                    j++;
                }
            } else if (duration == 2) {     //向下
                integers.add(matrix[i][j]);
                if (i == down) {
                    duration = 3;
                    right--;
                    j = right;
                } else {
                    i++;
                }
            } else if (duration == 3) {     //向左
                integers.add(matrix[i][j]);
                if (j == left) {
                    duration = 4;
                    down--;
                    i = down;
                } else {
                    j--;
                }
            } else if (duration == 4) {     //向上
                integers.add(matrix[i][j]);
                if (i == up) {
                    duration = 1;
                    left++;
                    j = left;
                } else {
                    i--;
                }
            }
        }
        return integers;
    }
}
