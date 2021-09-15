package jz;

import java.util.*;

/**
 * @author:xq
 * @date:2021/9/15 9:12
 * ClassName:jian48
 * Package:jz
 * Description:
 */
public class jian48 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() <= 0) {
                return 0;
            }

            int leftIndex = -1;
            int result = 0;
            Map<Character, Integer> leftIndexMap = new HashMap<Character, Integer>();

            char[] charArray = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                if (leftIndexMap.containsKey( charArray[i] )) {   // 当前数字 在之前遍历时出现过，就更新 窗口左边界
                    leftIndex = Math.max(leftIndex, leftIndexMap.get(charArray[i]));
                }
                leftIndexMap.put(charArray[i], i);

                result = Math.max(result, i - leftIndex);   // 计算 当前结果
            }
            return result;
        }
    }

    void test(){
        final int i = new Solution().lengthOfLongestSubstring("dvdf");
        System.out.println("i = " + i);
    }

    public static void main(String[] args) {
        new jian48().test();
    }
}
