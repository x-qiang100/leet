package jz;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:xq
 * @date:2021/9/19 14:07
 * ClassName:jian58_1
 * Package:jz
 * Description:
 */
public class jian58_1 {
    class Solution {
        public String reverseWords(String s) {
            final StringBuilder str = new StringBuilder();

            final String[] split = s.split(" ");
            int l = split.length;
            for (int i = l - 1; i >=0; i--) {
                if(!split[i].equals("") && i!=l-1){
                    str.append(' ');
                }
                str.append(split[i] );
            }
            return str.toString();
        }
    }
    void test(){
        final String s = new Solution().reverseWords("    a good   exapm;    ");
        System.out.println("s = " + s);

    }

    public static void main(String[] args) {
        new jian58_1().test();
    }
}
