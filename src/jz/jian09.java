package jz;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author xq
 * @Date 2021/9/7 下午12:52
 * @ClassName jian09
 * @Description 用两个栈实现队列
 */

public class jian09 {
    class CQueue{
        Deque<Integer> stack1 ;
        Deque<Integer> stack2 ;
        public CQueue() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        public void appendTail(int value){
            stack1.push(value );
        }
        public int deleteHead(){
            if(stack2.isEmpty()){
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }

            int ans = -1;
            if(!stack2.isEmpty() ){
                ans = stack2.pop();
            }
            return ans;
        }

    }

    public void test(){
        CQueue queue = new CQueue();
        System.out.println("queue.deleteHead() = " + queue.deleteHead());
        queue.appendTail(1);
        queue.appendTail(2);
        System.out.println("queue.deleteHead() = " + queue.deleteHead());
        queue.appendTail(3);
        queue.appendTail(4);
        System.out.println("queue.deleteHead() = " + queue.deleteHead());
        System.out.println("queue.deleteHead() = " + queue.deleteHead());
        System.out.println("queue.deleteHead() = " + queue.deleteHead());
        System.out.println("queue.deleteHead() = " + queue.deleteHead());
        queue.appendTail(4);
        System.out.println("queue.deleteHead() = " + queue.deleteHead());

    }

    public static void main(String[] args) {
        new jian09().test();
    }
}

