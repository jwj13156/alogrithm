package list;

class ListNode {
    int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class reverseKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode dummy=new ListNode(1,head);
		ListNode pre=dummy;
		while(true) {
			//1.先保存每组的末尾
			ListNode end=pre;
			for(int i=0;i<k;i++) {
				end=end.next;
				if(end==null) {
					return dummy.next;
				}
			}
			
			//2.保存每组的起点和下一组的起点，切断当前组进行翻转
			ListNode start=pre.next;
			ListNode nextNode=end.next;
			end.next=null;
			pre.next=reverse(start);
			
			//3.翻转完了连接，和更新pre节点位置
			start.next=nextNode;
			pre=start;
		}
    }
	
	private ListNode reverse(ListNode head) {
		ListNode pre=null;
		ListNode cur=head;
		while(cur!=null) {
			ListNode tem=cur.next;
			cur.next=pre;
			pre=cur;
			cur=tem;
		}
		return pre;
	}
}
