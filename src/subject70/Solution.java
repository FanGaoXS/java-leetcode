package cn.fangaoxs.day12.subject70;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/30/12:56
 * @Description:
 */
public class Solution {

    public static int climbStairs(int n) {
        int[] cache = new int[n];
        cache[0] = 1;
        cache[1] = 2;
        cache[n-1] = climb(n, cache);
        return cache[n-1];
    }

    private static int climb(int n,int[] cache){
        return cache[n-1]+cache[n-2];
    }

    public static int climbStairs2(int n) {
        if (n<=2) return n;
        int first = 1;
        int second = 2;
        //从3开始，第n个数实际上就是第n-2次循环
        for (int i = 1; i <= n-2; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

    public static void main(String[] args) {
        int n = 5;
        int result = climbStairs(n);
        int result2 = climbStairs2(n);
        System.out.println("result = " + result);
        System.out.println("result2 = " + result2);
    }
}
