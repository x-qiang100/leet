package jz;

import javax.management.StandardEmitterMBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author:xq
 * @date:2021/9/21 14:05
 * ClassName:jian40
 * Package:jz
 * Description:
 */
public class jian40 {
    class Solution {
        List<Integer> list;
        public int[] getLeastNumbers(int[] arr, int k) {
            list = new ArrayList<>();
            quick(arr, k, 0, arr.length - 1);

            int[] ans = new int[k];
            for (int i = 0; i < k; i++) {
                ans[i] = list.get(i);
            }
            return ans;
        }
        void quick(int[] arr, int k, int left, int right){
            int l = arr.length;
            if(left > right || k == 0) { return;}

            int flag = arr[left];
            int le = left+1;
            int ri = right;

            while (le <= ri){
                while ( le <= right && arr[le] <= flag ){
                    le++;
                }
                while (ri >= left && arr[ri] > flag ){
                    ri--;
                }
                if(le > right || ri < left) break;
                if(le >= ri) break;
                int temp = arr[le];
                arr[le] = arr[ri];
                arr[ri] = temp;
            }
            if(ri > left){
                arr[left] = arr[ri];
                arr[ri] = flag;
            }
            if(ri - left <= k ){
                for (int i = left; i < ri; i++) {
                    list.add(arr[i]);
                    k--;
                }
                if(k > 0){
                    list.add(arr[ri]);
                    k--;
                }
                quick(arr, k, ri+1, right);
            }else {
                quick(arr, k, left, ri - 1);
            }
        }
    }


    void test(){

        final int[] leastNumbers = new Solution().getLeastNumbers(new int[]{
                0,0,2,
        }, 2);
        System.out.println("Arrays.toString(leastNumbers) = " + Arrays.toString(leastNumbers));
    }

    public static void main(String[] args) {
        new jian40().test();
    }
}

//12 34 45 6 78 9
/*
 8 1 3 5 2
 1 3 5 8 9
 5 1 3 8 0 7
 */