package list;
import java.util.*;

class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	     ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
public class sortList {
	public ListNode sortList(ListNode head) {
		//把所有节点值存入数组，排序后重新赋值链表
        List<Integer> list=new ArrayList<>();
        
        ListNode node=head;
        while(node != null) {
        	list.add(node.val);
        	node = node.next;
        }
        Collections.sort(list);
        node=head;
        for(int n:list) {
        	node.val=n;
        	node=node.next;
        }
        return head;
    }
}
