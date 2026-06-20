package list;
import java.util.*;

class ListNode {
    int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class mergeTwoLists {
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		//很简单的题，因为两个链表都是有序的，直接循环添加到一个新的链表就行
        ListNode res=new ListNode();
        ListNode ans=res;
        while(list1 != null|| list2 !=null) {
        	if(list1==null) {
        		res.next=list2;
        		break;
        	}
        	if(list2 == null) {
        		res.next=list1;
        		break;
        	}
        	
        	if(list1.val<list2.val) {
        		res.next=list1;
        		list1=list1.next;
        	}else {
        		res.next=list2;
        		list2=list2.next;
        	}
        	res=res.next;
        }
        return ans.next;
    }
}
