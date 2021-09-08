package jz;

/**
 * @author xq
 * @Date 2021/9/8 下午6:28
 * @ClassName jian58
 * @Description 左旋转字符串
 */

public class jian58 {

    class Solution {
        public String reverseLeftWords(String s, int n) {

            StringBuilder sb = new StringBuilder();
            int l = s.length();
            sb.append(s.substring(n, l));
            sb.append(s.substring(0,n));

//            for (int i = n; i < l; i++) {
//                sb.append(s.charAt(i));
//            }
//            for (int i = 0; i < n; i++) {
//                sb.append(s.charAt(i));
//            }

            return sb.toString();
        }
    }

    public void test(){
        String s = new Solution().reverseLeftWords("123456789", 3);
        System.out.println("s = " + s);
    }

    public static void main(String[] args) {
        new jian58().test();
    }

}

