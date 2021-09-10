package jz;

/**
 * @author xq
 * @Date 2021/9/10 下午4:53
 * @ClassName jian04
 * @Description 二维数组中的查找
 */

public class jian04 {

    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            int l = matrix.length;
            if( l == 0) return false;
            int n = matrix[0].length;
            int left ;
            int right = n-1;
            int temp = -1;
            for (int i = 0; i < l; i++) {
                left  = 0;
                int mid = 0;
                while (left <= right){
                    mid = (left+right)/2;
                    if(matrix[i][mid] == target){
                        return true;
                    }
                    if(matrix[i][mid] > target ){
                        temp = mid;
                        right = mid - 1;
                    }else {
                        left = mid + 1;
                    }
                }
                right = temp;
                if(temp == -1){
                    right = n-1;
                }

            }
            return false;
        }
    }

    //从左上到右下
    class Solution2 {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            int m = matrix.length;
            if( m == 0) return false;
            int n = matrix[0].length;
            int x = 0 ;
            int y = n-1 ;

            while (x < m && y >= 0){
                if(matrix[x][y] == target){
                    return true;
                }
                if(matrix[x][y] > target){
                    y--;
                }else {
                    x++;
                }

            }
            return false;
        }
    }


    public void test(){
        int[][] ints = {
                {1, 4,  7,11,15},
                {2, 5,  8,12,19},
                {3, 6,  9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,31},
        };
        boolean numberIn2DArray = new Solution2().findNumberIn2DArray(ints, 17);
        System.out.println("numberIn2DArray = " + numberIn2DArray);
    }
    public static void main(String[] args) {
        new jian04().test();

    }
}

