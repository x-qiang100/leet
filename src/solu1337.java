import java.util.Arrays;

/**
 * @author xq
 * @Date 2021/8/1 下午8:01
 * @ClassName solu1337
 * @Description leetcode 1337
 */

public class solu1337 {

    class Solution {
        public int[] kWeakestRows(int[][] mat, int k) {
            int m = mat.length;
            int n = mat[0].length;
            int[][] count = new int[m][2];

            for (int i = 0; i < m; i++) {
                //遍历
//                for (int j = 0; j < n; j++) {
//                    count[i][0]+=mat[i][j];
//                }
                //二分查找
//                count[i][0]=Arrays.binarySearch(mat[i], 0);
                int l = 0, r = n - 1, pos = -1;
                while (l <= r) {
                    int mid = (l + r) / 2;
                    if (mat[i][mid] == 0) {
                        r = mid - 1;
                    } else {
                        pos = mid;
                        l = mid + 1;
                    }
                }
                count[i][0] = pos+1;
                count[i][1] = i;
            }

            System.out.println("Arrays.deepToString(count) = " + Arrays.deepToString(count));
            Arrays.sort(count,(o1, o2)->{
                if(o1[0] == o2[0]){
                    if(o1[1] == o2[1]){
                        return 0;
                    }
                    return (o1[1]>o2[1])?1:-1;
                }
                return (o1[0]>o2[0])?1:-1; }
            );
            int[] answer = new int[k];
            for (int i = 0; i < k; i++) {
                answer[i] = count[i][1];
            }
            return answer;
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {

        return new Solution().kWeakestRows(mat, k);
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1,0,0,0,0},
                {1,1,1,1,0},
                {1,1,1,0,0},
                {1,1,0,0,0},
                {1,1,0,0,0},
        };

        int[] ints = new solu1337().kWeakestRows(mat, 4);
        System.out.println("ints = " + Arrays.toString(ints));
    }
}

