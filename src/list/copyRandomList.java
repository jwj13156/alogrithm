package list;
import java.util.*;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class copyRandomList {
	public Node copyRandomList(Node head) {
		if(head ==null) return null;
		Node cur=head;
		//复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
		Map<Node,Node> map=new HashMap<>();
		//先复制各节点值
		while(cur !=null) {
			map.put(cur, new Node(cur.val));
			cur=cur.next;
		}
		//复制随机节点
		cur=head;
		while(cur!=null) {
			map.get(cur).next=map.get(cur.next);
			map.get(cur).random=map.get(cur.random);
			cur=cur.next;
		}
		
        return map.get(head);
    }
}
