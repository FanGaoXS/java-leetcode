package cn.fangaoxs.day19.subject48;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/06/19:10
 * @Description:
 *
 */
public class Solution {
    public static void rotate(int[][] matrix) {
        int a = matrix.length;      //矩形，长和宽相等
        //先沿水平线翻转
        for (int i = 0; i < a/2; i++) {
            for (int j = 0; j < a; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[a-1-i][j];
                matrix[a-1-i][j] = temp;
            }
        }
        //再沿主对角线翻转
        for (int i = 0; i < a; i++) {
            for (int j = i+1; j < a; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println("matrix[i][j] = " + matrix[i][j]);
            }
        }
    }
}
