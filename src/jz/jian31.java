package jz;

import java.util.*;

/**
 * @author:xq
 * @date:2021/10/2 11:30
 * ClassName:jian31
 * Package:jz
 * Description:
 */
public class jian31 {

    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            int l = pushed.length;
            int idxPush = 0;
            int idxPop = 0;
            Deque<Integer> s = new ArrayDeque<>();
            while (idxPush < l){
                s.addFirst(pushed[idxPush++]);
                while (s.size() !=0 && s.peek().equals( popped[idxPop])){
                    s.poll();
                    idxPop++;
                }
            }
            return s.size() == 0;
        }

    }

}
