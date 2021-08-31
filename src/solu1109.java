import java.util.Arrays;

/**
 * @author xq
 * @Date 2021/8/31 下午7:22
 * @ClassName solu1109
 * @Description 航班预定统计
 */

public class solu1109 {
    class Solution {
        public int[] corpFlightBookings(int[][] bookings, int n) {
            int[] answer = new int[n];
            for (int[] ints : bookings) {
                answer[ints[0]-1 ] += ints[2];
                if(ints[1] < n){
                    answer[ints[1]] -= ints[2];
                }
            }
            for (int i = 1; i < n; i++) {
                answer[i]+=answer[i-1];
            }
            return answer;
        }
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ints = new Solution().corpFlightBookings(bookings, n);
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
        return ints;
    }
    public static void main(String[] args) {
        int[][] bookings = {
                {1, 2, 10},
                {2, 3, 20},
                {2, 5, 25},
        };
        new solu1109().corpFlightBookings(bookings, 5);
    }
}

