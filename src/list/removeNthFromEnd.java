package list;

class ListNode {
    int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class removeNthFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// 虚拟头，规避删除头节点的特殊情况
        ListNode dummy = new ListNode(0, head);
        ListNode temp = dummy;
        int len = 0;

        // 1. 统计链表总长度
        while (head != null) {
            len++;
            head = head.next;
        }

        // 2. 找到要删除节点的前驱节点：走 len-n 步
        int step = len - n;
        for (int i = 0; i < step; i++) {
            temp = temp.next;
        }

        // 删除目标节点
        temp.next = temp.next.next;
        // 返回真实头节点
        return dummy.next;
    }
}
