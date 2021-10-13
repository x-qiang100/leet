package jz;

import java.util.Arrays;

/**
 * @author:xq
 * @date:2021/10/13 8:55
 * ClassName:jian51
 * Package:jz
 * Description: 数组中的逆序对，归并排序
 */
public class jian51 {
    class Solution {

        int count = 0;
        public int reversePairs(int[] nums) {
            int[] copys = Arrays.copyOf(nums, nums.length);
            reverse(copys, 0, copys.length);
            return count;
        }

        void reverse(int[] copys, int lIdx, int rIdx){
            int mid = (lIdx+rIdx)/2;
            if(mid != lIdx) {
                reverse(copys, lIdx, mid);
                reverse(copys, mid, rIdx);
            }
            if(lIdx == rIdx-1){
                return;
            }

            int i = lIdx, j = mid ;
            int idx = 0;
            int[] temp = new int[rIdx - lIdx];
            while ( i < mid && j < rIdx ){
                if(copys[i] <= copys[j]){
                    temp[idx] = copys[i];
                    idx++;
                    i++;
                    count+= j-mid;
                }else {
                    temp[idx] = copys[j];
                    idx++;
                    j++;
                }
            }
            while (i < mid){
                temp[idx++] = copys[i++];
                count+= j-mid;
            }
            while (j < rIdx){ temp[idx++] = copys[j++]; }

            for (int i1 = lIdx; i1 < rIdx; i1++) {
                copys[i1] = temp[i1-lIdx];
            }
        }
    }
    /*
    5 6 1 2
    5 8 4 6
    1 2 5 6
    4 6 5 8
     */

    void test(){
        int[] nums = {1,3,2,3,1};
        final int i = new Solution().reversePairs(nums);
        System.out.println("i = " + i);
    }


    public static void main(String[] args) {
        new jian51().test();
    }
}
