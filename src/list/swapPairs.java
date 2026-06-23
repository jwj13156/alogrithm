package list;

class ListNode {
    int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class swapPairs {
	public ListNode swapPairs(ListNode head) {
		//这种链表相关的题目一般都会用到虚拟头结点
		//新建虚拟头结点 dummy，统一处理头节点交换逻辑，不用单独判断头部
		//用cur指针作为每组前一个前驱节点，每次处理 cur -> a -> b -> nextGroup
		//交换逻辑固定三步：
		//cur.next = b
		//a.next = b.next
		//b.next = a
		//cur 移动到 a（下一组前驱），循环直到后面不足两个节点
		
        ListNode temp=new ListNode(1,head);
        ListNode cur=temp;
        while (cur.next != null && cur.next.next != null) {
            ListNode a = cur.next;
            ListNode b = cur.next.next;
            cur.next=b;
            a.next=b.next;
            b.next=a;
            
            cur=a;
        }
        return temp.next;
    }
}
