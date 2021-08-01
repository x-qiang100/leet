package Common;

/**
 * @author xq
 * @Date 2021/8/1 下午9:19
 * @ClassName ListNode
 * @Description Definition for singly-linked list.
 */

public class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    static ListNode create(int[] ints){
        int l = ints.length;
        if(l == 0){
            return new ListNode();
        }
        ListNode head = new ListNode(ints[0]);
        ListNode p = head;
        for (int i = 1; i < l; i++) {
            ListNode node = new ListNode(ints[i]);
            p.next = node;
            p = node;
        }
        return head;
    }

    static void show(ListNode head){
        ListNode p = head;
        System.out.print("{");
        while (p != null){
            System.out.print(p.val+", ");
            p=p.next;
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        ListNode listNode = create(new int[]{1, 2, 3, 4, 5, 6});
        show(listNode);
    }
}

