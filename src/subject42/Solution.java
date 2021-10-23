package cn.fangaoxs.day4.subject42;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/22/20:45
 * @Description:  LeetCode 42 hard
 *          思路就是先找到最大高度的位置，然后分为左右两边。
 *          左边能够蓄水的体积永远是取决于左边较高的柱子，同理右边则取决于右边较高的柱子。
 *          左边： 从左往右依次迭代，取得目前最高的柱子，当前能够蓄水的体积总是目前最高的
 *          高度减去下一个位置的高度（高度差），只有当左边高度大于右边高度时才能蓄水。比
 *          如题目测试用例，从左往右迭代时，i=1时，leftMaxHeight = 1;这是目前最高高度，
 *          那么i=1时能够蓄水的体积就是leftMaxHeight - height[2]，也就是1-0=1；
 *          迭代到i=3时，此时的左边最高高度替换为leftMaxHeight = 2，这是目前最高高度，
 *          那么i=3时，能够蓄水的体积就是leftMaxHeight - height[4]，也就是2-1=1；i=4时，
 *          目前最高高度是leftMaxHeight = 2，此时能够蓄水的体积是leftMaxHeight - height[5] = 2-0=2，后面同理..
 *          右边： 右边同理，只需要从右往左迭代，取得最高柱子，只有当右边高度大于左边高度时才能蓄水。
 */
class Solution {
    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        int trap = trap(height);
        System.out.println("trap = " + trap);
        int trap2 = trap2(height);
        System.out.println("trap2 = " + trap2);
    }
    public static int trap(int[] height) {
        int maxHeightValue = 0;
        int maxHeightIndex = 0;
        int v = 0;
        for (int i = 0; i < height.length; i++) {
            maxHeightValue = Math.max(maxHeightValue,height[i]); //求最大高度
            if (maxHeightValue==height[i]) maxHeightIndex = i;   //最大高度的位置
        }
        /*System.out.println("maxHeightIndex = " + maxHeightIndex);
        System.out.println("maxHeightValue = " + maxHeightValue);*/
        int leftMaxHeight = 0; //初始化左边最高高度
        for (int i = 0; i < maxHeightIndex; i++) {  //左
            if (height[i]>leftMaxHeight) leftMaxHeight = height[i]; //从左往右不断获取目前最高高度
            if (leftMaxHeight>height[i+1]){
                //左边能蓄水取决于左边较高
                //左边能蓄水总是为：左边目前最高高度减去下一个位置的高度（高度差）
                v += leftMaxHeight - height[i+1];
            }
        }
        int rightMaxHeight = 0; //初始化右边最高高度
        for (int i = height.length-1; i > maxHeightIndex ; i--) {     //右
            if (height[i]>rightMaxHeight) rightMaxHeight = height[i];   //从右往左不断获取目前最高高度
            if (rightMaxHeight>height[i-1]){
                //右边能蓄水取决于右边较高
                //右边能蓄水总是为：右边目前最高高度减去下一位置的高度（高度差）
                v += rightMaxHeight - height[i-1];
            }
        }
        return v;
    }

    public static int trap2(int[] height) {
        //接的雨水的体积
        int v = 0;
        //数组中最大值的下标和值
        int maxHeightIndex = -1;
        int maxHeightValue = -1;
        for (int i = 0; i < height.length; i++) {
            //找出数组最大值以及它的下标
            if (height[i]>maxHeightValue) {
                maxHeightIndex = i;
                maxHeightValue = height[i];
            }
        }
        int leftMaxHeightValue = 0;
        for (int i = 0; i < maxHeightIndex; i++) {
            if (height[i]>=leftMaxHeightValue) {
                leftMaxHeightValue = height[i];
                continue;
            }
            v += leftMaxHeightValue - height[i];
        }
        int rightMaxHeightValue = 0;
        for (int i = height.length-1; i > maxHeightIndex; i--) {
            if (height[i]>rightMaxHeightValue){
                rightMaxHeightValue = height[i];
                continue;
            }
            v += rightMaxHeightValue - height[i];
        }
        return v;
    }
}
