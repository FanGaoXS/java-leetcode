package cn.fangaoxs.day12.subject69;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/30/12:56
 * @Description:
 */
public class Solution {

    public static int mySqrt(int x) {
        int left = 0;
        int right = x;
        int result = -1;
        while (left<=right){
            int mid = left + (right - left)/2;
            if ((long)((long) mid *mid)>x){         //取左区间
                right = mid - 1;
            } else if ((long)((long) mid *mid)<x){  //取右区间
                result = mid;           //暂存结果
                left = mid + 1;
            } else if ((long)((long) mid *mid)==x) return mid;
        }
        return result;
    }

    public static void main(String[] args) {
        int x = Integer.MAX_VALUE;
        int result = mySqrt(x);
        System.out.println("result = " + result);
    }
}
