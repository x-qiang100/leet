package jz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:xq
 * @date:2021/10/8 19:13
 * ClassName:jian38
 * Package:jz
 * Description:
 */
public class jian38 {

    class Solution {

        public String[] permutation(String s) {
            list = new ArrayList<>();
            dfs(s, 0, new StringBuilder(),  new boolean[s.length()] );
            String[] ss = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                ss[i] = list.get(i);
            }
            return ss;
        }

        List<String> list;

        void dfs(String s, int idx, StringBuilder sb,  boolean[] use){
            if(idx == s.length()) {
                list.add(sb.toString());
                return;
            }
            int k = 0;
            List<Character> boo = new ArrayList<>();
            while (k < s.length()){
                if(boo.contains(s.charAt(k)) || use[k] ){
                    k++;
                    continue;
                }
                boo.add(s.charAt(k));
                sb.append(s.charAt(k));
                use[k] = true;
                dfs(s, idx+1, sb, use);
                use[k] = false;
                sb.deleteCharAt(sb.length() - 1);
                k++;
            }
        }

    }
    void test(){
        final String[] abcs = new Solution().permutation("abbcc");
        System.out.println("Arrays.toString(abcs) = " + Arrays.toString(abcs));
    }
    public static void main(String[] args) {
        new jian38().test();
    }
}
