package jz;

/**
 * @author xq
 * @Date 2021/9/10 下午5:36
 * @ClassName jian11
 * @Description 旋转数组的最小数字
 */

public class jian11 {

    //相等时，忽略右端点
    class Solution {
        public int minArray(int[] numbers) {
            int l = numbers.length;
            int left = 0;
            int right = l - 1;

            if(l == 1  || numbers[0] < numbers[l-1]) return numbers[0];
            while (left<=right){
                int mid = (left+right)/2;
                System.out.println(mid);
                if( mid>0 && numbers[mid]<numbers[mid-1] ){
                    return numbers[mid];
                }
                if( mid < l-1 && numbers[mid] > numbers[mid+1] ){
                    return numbers[mid+1] ;
                }

                if(numbers[mid] == numbers[0]){
                    right--;
                }
                if(numbers[mid] > numbers[0]){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }


            return numbers[0];
        }
    }

    public void test(){
        int[] ns = {8,1,8,8,8};
        int i = new Solution().minArray(ns);
        System.out.println("i = " + i);
    }

    public static void main(String[] args) {
        new jian11().test();
    }
}

