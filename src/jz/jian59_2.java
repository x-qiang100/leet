package jz;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author:xq
 * @date:2021/10/2 16:34
 * ClassName:jian59_2
 * Package:jz
 * Description:
 */
public class jian59_2 {
    class MaxQueue {
        Queue<Integer> queue ;
        List<Integer> max ;
//        Integer max;
        public MaxQueue() {
            queue = new LinkedList<>();
            max = new LinkedList<>();
        }

        public int max_value() {
            if(queue.size() == 0 ) return -1;
            return max.get(0);
        }

        public void push_back(int value) {
            List<Integer> temp = new LinkedList<>();
            for (Integer integer : max) {
                if(integer > value){
                    temp.add(integer);
                }else {
                    break;
                }
            }
            temp.add(value);
            max = temp;
            queue.add(value );
        }

        public int pop_front() {
            if(queue.size() == 0 ) return -1;
            Integer ans = queue.poll();
            if(max.get(0).equals(ans)){
                max.remove(0);
            }
            return ans;
        }
    }


}
