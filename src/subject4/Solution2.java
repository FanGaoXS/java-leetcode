package subject4;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/10/30/16:39
 * @Description:
 */
public class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int length = m + n;
        int[] ints = new int[length];
        for (int i = 0; i < m; i++) {
            ints[i] = nums1[i];
        }
        for (int i = 0; i < n; i++) {
            ints[i+m] = nums2[i];
        }   //两个数组合并
        Arrays.sort(ints);  //数组排序
        if (length%2 == 0) {   //合并后的数组长度是偶数
            return (ints[length/2-1] + ints[length/2])/2.0;
        }
        return ints[length/2];
    }
}
