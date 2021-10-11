package mian;

/**
 * @author:xq
 * @date:2021/10/11 22:15
 * ClassName:solu01_05
 * Package:mian
 * Description:
 */
public class solu01_05 {
    class Solution {
        public boolean oneEditAway(String first, String second) {
            int l1 = first.length();
            int l2 = second.length();
            if(l1-l2 >1 || l1-l2 <-1){
                return false;
            }
            char[] ch1 = first.toCharArray();
            char[] ch2 = second.toCharArray();
            if(ch1.length == ch2.length){
                int flag = 0;
                for (int i = 0; i < ch2.length; i++) {
                    if(ch1[i] != ch2[i]){
                        flag++;
                    }
                }
                return flag <= 1;
            }else {
                if(ch1.length > ch2.length){
                    char[] mid = ch1;
                    ch1 = ch2;
                    ch2 = mid;
                }
                int flag = 0;
                for (int i = 0, j = 0; i < ch1.length; i++, j++) {
                    if(ch1[i] != ch2[j]){
                        if(flag == 1) return false;
                        j++;
                        flag++;
                        if(ch1[i] != ch2[j]) return false;
                    }
                }
                return true;
            }

        }
    }


    public static void main(String[] args) {
        String s = null;
        System.out.println("s = " + s);
//        if(s.toString().equals("null")){
//            System.out.println("----");
//        }
//        if(s == null);
    }
}
