package jz;

/**
 * @author:xq
 * @date:2021/10/2 14:30
 * ClassName:jian20
 * Package:jz
 * Description: 数值
 */
public class jian20 {

    class Solution {
        public boolean isNumber(String s) {
            s = s.trim();
            final char[] chars = s.toCharArray();
            int l = chars.length;
            int start = 0;

            int countPoint = 0;
            int eCount = 0;
            int numCount = 0;
            for (int i = start; i < l; i++) {
                if(chars[i] == ' '){ return false; }
                if(chars[i] >= 'A' && chars[i] <= 'z'){
                    if(chars[i] != 'e' && chars[i] != 'E'){
                        return false;
                    }
                }


                if(chars[i] >= '0' && chars[i] <= '9'){
                    numCount++;
                }

                if(chars[i] == '+' || chars[i] == '-'){
                    int temp = i+1;
                    if(temp > l-1) return false;
                    if(chars[temp] > '0' && chars[temp] < '9' ){
                        numCount++;
                    }else if(chars[temp] != '.') return false;


                    temp = i-1;
                    if(temp> start ){
                        if(chars[temp]!='e' && chars[temp]!='E'){
                            return false;
                        }
                    }
                }

                if(chars[i] == '.'){
                    if(countPoint != 0 || eCount!=0){
                        return false;
                    }
                    int temp = i+1;
                    countPoint++;
                    if( i!= l -1 && chars[temp]>='0' && chars[temp]<='9'){
                        numCount++;
                    }else{
                        if(numCount == 0){
                            return false;
                        }
                    }
                }
                if(chars[i] == 'e' || chars[i] == 'E'){
                    if(eCount!=0 || numCount==0){
                        return false;
                    }
                    int temp = i+1;
                    eCount++;

                    if(i == l -1) return false;
                    if(chars[temp] >='0' && chars[temp]<='9'){
                        numCount++;
                    }else if(chars[temp] == '+' || chars[temp] == '-'){
                        temp++;
                        if(temp < l && chars[temp] >='0' && chars[temp]<='9'){
                            numCount++;
                        }else {
                            return false;
                        }
                    }else {
                        return false;
                    }

                }
            }
            if(numCount == 0) return false;

            return true;

        }


    }


    void test(){
        final Solution s = new Solution();
        boolean number = false;
        String[] sr = {
//                "12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"
//                "+100", "5e2", "-123", "3.1416", "-1E-16", "0123"
//                "0","e","  .1  ",".","3.","0..",
                "-1e-16",".8+","+.8","-1 ","6+1"
        };
        for (int i = 0; i < sr.length; i++) {
            System.out.println(sr[i]);
            number = s.isNumber(sr[i]);
            System.out.println(number);
        }

    }
    public static void main(String[] args) {
        int f = (int) 1e10;
        new jian20().test();
    }
}
