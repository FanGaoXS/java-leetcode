package cn.fangaoxs.day1.subject3;

import org.omg.CORBA.BAD_TYPECODE;

import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        String s = "a1234588";
        int length = lengthOfLongestSubstring(s);
        int length2 = lengthOfLongestSubstring2(s);
        System.out.println("length = " + length);
        System.out.println("length2 = " + length2);
    }

    public static int lengthOfLongestSubstring(String s) {
        byte[] bytes = s.getBytes();
        if (bytes.length<2) return bytes.length;
        int maxLength = 0;
        HashSet<Byte> set = new HashSet<>();
        set.add(bytes[0]);
        int leftIndex = 0;
        int rightIndex = 1;
        while (rightIndex<bytes.length){
            if (set.contains(bytes[rightIndex])){ //如果set中包含正在比较的元素
                set.remove(bytes[leftIndex]);
                leftIndex++;
            } else {
                set.add(bytes[rightIndex]);
                maxLength = Math.max(maxLength,set.size());
                rightIndex++;
            }
        }
        return maxLength;
    }
    public static int lengthOfLongestSubstring2(String s) {
        if (s.length()<=1) return s.length();
        int left = 0;
        int right = 1;
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(left));
        int maxSize = 1;
        while (right<s.length()){
            if (set.add(s.charAt(right))){
                //往set中添加元素成功，则继续移动右指针，记录下此时最大的size，并且取最大
                maxSize = Math.max(maxSize, set.size());
                right++;
            } else {
                //往set中添加元素失败，说明元素已经存在，则移动左指针（并且移除左边的元素，确保当前set中没有重复元素）
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxSize;
    }
}
