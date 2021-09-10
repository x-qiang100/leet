package jz;

import java.util.Arrays;

/**
 * @author xq
 * @Date 2021/9/10 下午6:01
 * @ClassName jian50
 * @Description 第一个只出现一次的字符
 */

public class jian50 {


    class Solution {
        public char firstUniqChar(String s) {
            int[] ints = new int[30];
            int[] idx = new int[30];
            Arrays.fill(idx, -1);

            int l = s.length();
            char[] chars = s.toCharArray();
            for (int i = 0; i < l; i++) {
                int temp = chars[i]-'a';
                ints[ temp] ++;
                if(idx[temp] == -1){
                    idx[temp] = i;
                }
            }
            int ans = -1;
            int minIdx = -1;
            for (int i = 0; i < 26; i++) {
                if(ints[i] == 1){
                    if(ans == -1){
                        ans = idx[i];
                        minIdx = i;
                    }else {
                        if(ans > idx[i] ){
                            ans = idx[i];
                            minIdx = i;
                        }

                    }
                }
            }
            if(minIdx == -1){
                return ' ';
            }else {
                return (char) ('a'+minIdx);
            }

        }
    }


    class Solution2 {
        public char firstUniqChar(String s) {
            int result = s.length();
            for (char i = 'a'; i <= 'z'; i++) {
                int i1 = s.indexOf(i);
                if (i1 != -1 && i1 == s.lastIndexOf(i)){
                    result = Math.min(result,i1);
                }
            }
            if (result == s.length()){
                return ' ';
            }
            return s.charAt(result);
        }
    }


    public void test(){
        char c = new Solution().firstUniqChar("abaccdedeffbc");
        System.out.println("c = " + c);
    }
    public static void main(String[] args) {
        new jian50().test();
    }
}

