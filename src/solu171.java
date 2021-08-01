public class solu171 {

    class Solution {
        public int titleToNumber(String columnTitle) {
            int s = 0;
            int co = 26;
            int l = columnTitle.length();
            for (int i = 0; i < l; i++) {
                int add = columnTitle.charAt(i)-'A'+1;
                s = s*26 + add;
            }
            return s;
        }
    }
    public int titleToNumber(String columnTitle) {
        System.out.println(new Solution().titleToNumber("FXSHRXW"));
        return new Solution().titleToNumber("ZY");
    }

    public static void main(String[] args) {
        new solu171().titleToNumber("");
    }
}
