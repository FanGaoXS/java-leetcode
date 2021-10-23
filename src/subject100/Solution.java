package cn.fangaoxs.day34.subject100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/21/14:39
 * @Description:
 */
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        List<int[]> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new int[]{startTime[i], endTime[i], profit[i]});
        }
        Collections.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int[] dp = new int[n];
        dp[0] = jobs.get(0)[2];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], jobs.get(i)[2]);
            int l = 0, r = i - 1;
            while (l < r) {
                int mid = (r - l) / 2 + l + 1;
                if (jobs.get(mid)[1] <= jobs.get(i)[0]) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            int j = l;
            if (jobs.get(j)[1] <= jobs.get(i)[0]) {
                dp[i] = Math.max(dp[i], dp[j] + jobs.get(i)[2]);
            }
        }
        return dp[n - 1];
    }
}
