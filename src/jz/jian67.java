package jz;

/**
 * @author:xq
 * @date:2021/10/2 15:43
 * ClassName:jian67
 * Package:jz
 * Description:
 */
public class jian67 {

    class Solution {
        public int strToInt(String str) {
            if(str == null || str.length() == 0) return 0;
            long val = 0L;
            int zf = 1;
            int zfCount = 0;
            str = str.trim();
            if( str.length() == 0) return 0;

            final char[] chs = str.toCharArray();
            final int l = chs.length;
            if(chs[0] == '+' || chs[0] == '-'){
                if(chs[0] == '-'){
                    zf = -1;
                }
            }
            for (int i = 0; i < l; i++) {
                if(i == 0 ){
                    if(chs[i] == '+' || chs[i] == '-'){
                        continue;
                    }
                }
                if(chs[i] >= '0' && chs[i] <= '9'){
                    long x = chs[i] - '0';
                    val = val*10 + x;
                 }else {
                    break;
                }
            }
            if(val == 0){
                return 0;
            }
            val = val*zf;
            if(val < Integer.MIN_VALUE || val > Integer.MAX_VALUE){
                if(zf == 1) return Integer.MAX_VALUE;
                return Integer.MIN_VALUE;
            }
            return (int) val;
        }
    }
    void test(){
        final Solution s = new Solution();
        String[] sr = {
                "","-91283472332", "adas123","243hjk","  -42"
//                "-1e-16",".8+","+.8","-1 ","6+1"
        };
        for (int i = 0; i < sr.length; i++) {
            System.out.println(sr[i]);
            final int i1 = s.strToInt(sr[i]);
            System.out.println("i1 = " + i1);
        }

    }
    public static void main(String[] args) {
        int f = (int) 1e10;
        new jian67().test();
    }

}
