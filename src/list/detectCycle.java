package list;

import java.util.HashSet;

class ListNode {
    int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class detectCycle {
	public ListNode detectCycle(ListNode head) {
		HashSet<ListNode> visited = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            // 该节点已经标记过，存在环
            if (visited.contains(cur)) {
                return cur;
            }
            // 标记当前节点
            visited.add(cur);
            cur = cur.next;
        }
        // 走到链表末尾，无环
        return null;
    }
}
