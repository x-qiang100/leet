package jz;

/**
 * @author xq
 * @Date 2021/9/8 下午6:21
 * @ClassName jian05
 * @Description 替换空格
 */

public class jian05 {

    class Solution {
        public String replaceSpace(String s) {
            StringBuilder sb = new StringBuilder();
            int l = s.length();
            for (int i = 0; i < l; i++) {
                if(s.charAt(i) == ' '){
                    sb.append("%20");
                }else {
                    sb.append(s.charAt(i));
                }
            }
            return sb.toString();
        }
    }


    void test(){
        String  s = "hello world ni   hao ";
        String s1 = new Solution().replaceSpace(s);
        System.out.println("s1 = " + s1);
    }
    public static void main(String[] args) {
        new jian05().test();
    }
}

