package jz;

import java.util.LinkedList;

/**
 * @author:xq
 * @date:2021/9/22 12:50
 * ClassName:jian41
 * Package:jz
 * Description:
 */
public class jian41 {

    class MedianFinder {

        Node head;
        Node tail;
        Node mid;
        int len ;
        /** initialize your data structure here. */
        public MedianFinder() {
            head = new Node();
            tail = head;
            mid = head;
            len = 0;
        }

        public void addNum(int num) {

            Node news = new Node(num );
            len++;
            boolean flag = false;

            Node p = head.next;
            while (p != null){
                if(p.val > num) break;
                if(p == mid) flag = true;
                p = p.next;
            }

            if(p == null){
                tail.next = news;
                news.prev = tail;
                tail = news;

                if(len%2 == 1) {
                    mid = mid.next;
                }
            }else {
                Node q = p.prev;
                news.next = p;
                p.prev = news;
                news.prev = q;
                q.next = news;
                if(flag  && len%2 == 1) mid = mid.next;
                if(!flag && len%2 == 0) mid = mid.prev;
            }
        }

        public double findMedian() {
            if(head.next == null) return 0;
            if(len%2 == 1) return mid.val;

            int i1 = mid.val;
            int i2 = mid.next.val;
            double ans = (i1+i2*1.00000)/2.00000;
            return ans;
        }
        // 1 5 7 8 10 56 34 45
        // 6 10 2 8

        class Node{
            int val;
            Node prev;
            Node next;
            public Node(int val) {
                this.val = val;
            }

            public Node() {
            }
        }

    }

    void test(){
        MedianFinder fin = new MedianFinder();
        System.out.println("fin.findMedian() = " + fin.findMedian());
        fin.addNum(6);
        System.out.println("fin.findMedian() = " + fin.findMedian());
        fin.addNum(10);
        System.out.println("fin.findMedian() = " + fin.findMedian());
        fin.addNum(2);
        System.out.println("fin.findMedian() = " + fin.findMedian());
        fin.addNum(6);
        System.out.println("fin.findMedian() = " + fin.findMedian());
        fin.addNum(5);
        System.out.println("fin.findMedian() = " + fin.findMedian());
        fin.addNum(0);
        System.out.println("fin.findMedian() = " + fin.findMedian());


    }
    public static void main(String[] args) {
        new jian41().test();
    }
}
