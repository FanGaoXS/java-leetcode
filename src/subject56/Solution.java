package subject56;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/29/19:59
 * @Description:
 */
class Solution {
    public static int[][] merge(int[][] intervals) {
        //Array.sort和Comparator比较器排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0]; //根据[start,end]中的start来排序
            }
        });
        ArrayList<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];                            //当前位置的区间的左边界
            int end = intervals[i][1];                              //当前位置的区间的右边
            int mergedLastStart = merged.get(merged.size()-1)[0];   //已经排序好的区间的最后一个区间的左边界
            int mergedLastEnd = merged.get(merged.size()-1)[1];     //已经排序好的区间的最后一个区间的右边界
            //如果当前区间的左边界比已经排序号的区间的最后一个区间的有边界大则说明一定不会有重叠
            if (start>mergedLastEnd){
                merged.add(intervals[i]);   //则直接将当前区间加入
            } else {    //否则会有重叠，合并后的右边界是取最大
                merged.set(merged.size()-1,new int[]{mergedLastStart,Math.max(end,mergedLastEnd)});
            }
        }
        return merged.toArray(new int[0][]);
    }

    public static int[][] merge2(int[][] intervals) {
        //将intervals数组进行排序，按照其中的start由小到大排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        ArrayList<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            //当前区间的start和end
            int start = intervals[i][0];
            int end = intervals[i][1];
            //上次已经排好顺序的区间的start和end
            int lastMergedStart = merged.get(merged.size() - 1)[0];
            int lastMergedEnd = merged.get(merged.size() - 1)[1];
            //如果当前区间的start大于上次排好的区间的end，则说明当前区间和上次排序好的区间不可能重合
            if (start>lastMergedEnd) {
                merged.add(intervals[i]);
            } else {
                //否则则有可能重合，修改上次排序好的区间的end为当前区间和上次区间取最大
                merged.set(merged.size()-1,new int[]{lastMergedStart,Math.max(end,lastMergedEnd)});
            }
        }
        return merged.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] resultInts = merge2(intervals);
        for (int i = 0; i < resultInts.length; i++) {
            System.out.println();
            System.out.println("start = "+ resultInts[i][0]);
            System.out.println("end = "+ resultInts[i][1]);
            System.out.println();
        }
    }
}
