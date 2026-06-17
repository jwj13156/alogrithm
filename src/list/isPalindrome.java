package list;
import java.util.*;

class ListNode {
    int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class isPalindrome {
	public boolean isPalindrome(ListNode head) {
		//回文链表很简单就能想到数组加双指针的解法
		//进阶的方法是使用快慢指针，一个走的快一个走的慢，当走的快的到终点时走的慢的
		//到中点，此时反转链表就可以对比是否回文
        List<Integer> list=new ArrayList<>();
        ListNode cur= head;
        while(cur!=null) {
        	list.add(cur.val);
        	cur=cur.next;
        }
        int l=0,r=list.size()-1;
        while(l<r) {
        	if(!list.get(l).equals(list.get(r))) {
        		return false;
        	}
        	l++;r--;
        }
        return true;
    }
}
