package jz;

/**
 * @author xq
 * @Date 2021/9/9 下午12:49
 * @ClassName jian53_1
 * @Description 统计数字在排序数组中出现的次数
 */

public class jian53_1 {

    //二分
    class Solution {
        public int search(int[] nums, int target) {
            int l = nums.length;
            int left = 0;
            int right = l-1;
            int mid = -1;
            while (left <= right){
                mid = (left+right)/2;
                if(target > nums[mid]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
            if(mid == -1 || target != nums[mid]) return 0;
            int count = 0;
            int temp = mid;
            while (temp >= 0){
                if(nums[temp] == target){
                    count++;
                    temp--;
                }else {
                    break;
                }
            }
            temp = mid+1;
            while (temp < l){
                if(nums[temp] == target){
                    count++;
                    temp++;
                }else {
                    break;
                }
            }

            return count;
        }
    }

    public void test(){
        int[] ints ={4};
        int search = new Solution().search(ints, 4);
        System.out.println("search = " + search);
    }
    public static void main(String[] args) {
        new jian53_1().test();
    }
}

