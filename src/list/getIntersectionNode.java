package list;
import java.util.*;


class ListNode {
	  int val;
	  ListNode next;
	  ListNode(int x) {
	     val = x;
	      next = null;
	  }
}
public class getIntersectionNode {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
            return null;
        }
		//遍历链表 A，把所有节点对象存入哈希集合；
		//遍历链表 B，逐个判断当前节点是否在集合中；
		//第一个命中的节点就是相交起点；遍历完无匹配则返回 null。
		//要点：比较节点引用，不是节点值（值可能重复）。
		Set<ListNode> set= new HashSet<>();
		ListNode a=headA;
		ListNode b=headB;	
		while (a != null) {
            set.add(a);
            a = a.next;
        }
		while (b != null) {
            if (set.contains(b)) {
                return b;
            }
            b = b.next;
        }
        return null;
    }
}

