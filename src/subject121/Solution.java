package cn.fangaoxs.day6.subject121;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/24/17:02
 * @Description:
 */
class Solution {

    public static int maxProfit(int[] prices) {
        int low = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            low = Math.min(low,prices[i]);          //最小买入价
            result = Math.max(result,prices[i]-low);//当前利润和上次利润取较大
        }
        return result;
    }

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        int maxProfit = maxProfit(prices);
        System.out.println("maxProfit = " + maxProfit);
    }
}
