package list;
import java.util.*;
class ListNode {
	     int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
class reverseList {
	public ListNode reverseList(ListNode head) {
		//就是多使用几个节点来相互调换，和数组间的值相互交换有点像
		if(head ==null ) return null;
        ListNode cur =head;
        ListNode pre=null;
        while(cur!=null) {
        	ListNode tem =cur.next;
        	cur.next=pre;
        	pre =cur;
        	cur=tem;
        }
        return pre;
    }
}
