package jz;

import java.util.*;

/**
 * @author:xq
 * @date:2021/9/21 11:45
 * ClassName:jian45
 * Package:jz
 * Description:
 */
public class jian45 {
    class Solution {
        public String minNumber(int[] nums) {
            Integer[] ins = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                ins[i] = nums[i];
            }
            Arrays.sort(ins, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if (o1.equals(o2)) return 0;
                    String s1 = o1.toString() + o2.toString();
                    String s2 = o2.toString() + o1.toString();
                    int l = s1.length();
                    for (int i = 0; i < l; i++) {
                        if (s1.charAt(i) < s2.charAt(i)) {
                            return -1;
                        }
                        if (s1.charAt(i) > s2.charAt(i)) {
                            return 1;
                        }
                    }
                    return 0;
                }
            });
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < ins.length; i++) {
                s.append(ins[i].toString());
            }
            System.out.println("Arrays.toString(ins) = " + Arrays.toString(ins));
            return s.toString();
        }

    }

    void test(){
        final String s = new Solution().minNumber(new int[]{
                1,2,3,33,332,33234
        });
        System.out.println("s = " + s);
    }

    public static void main(String[] args) {
        new jian45().test();
    }
}
    /*
111
11111

333
33335

11111113
11113111

322
32231

322
32232232

344>
3443443
3443443344
3443443443
*/
