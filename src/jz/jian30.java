package jz;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author xq
 * @Date 2021/9/7 下午1:16
 * @ClassName jian30
 * @Description 包含min函数的栈
 */

public class jian30 {

    class MinStack {
        private final Deque<Integer> stack ;
        private final Deque<Integer> min ;
        public MinStack() {
            stack = new LinkedList<>();
            min = new LinkedList<>();
        }

        public void push(int x) {
            stack.push(x);
            if(min.isEmpty()){
                min.push(x);
            }else {
                if(x <= min.peek() ){
                    min.push(x);
                }
            }
        }

        public void pop() {
            if(stack.isEmpty()){
                return;
            }
            int i = stack.pop();
            if(i == min.peek()){
                min.pop();
            }
        }

        public int top() {

            return stack.peek();
        }

        public int min() {

            return min.peek();
        }
    }


    public void test(){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("minStack.min = " + minStack.min());
        minStack.pop();
        System.out.println("minStack.min = " + minStack.top());
        System.out.println("minStack.min = " + minStack.min());
        minStack.pop();
        System.out.println("minStack.min = " + minStack.min());
        minStack.pop();

    }

    public static void main(String[] args) {
        new jian30().test();
    }
}

