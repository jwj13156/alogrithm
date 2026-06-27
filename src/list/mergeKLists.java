package list;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class mergeKLists {
	public ListNode mergeKLists(ListNode[] lists) {
		 if (lists == null || lists.length == 0) return null;
	        return merge(lists, 0, lists.length - 1);
    }
	// 分治：合并区间 [l, r] 内所有链表
    private ListNode merge(ListNode[] lists, int l, int r) {
        // 区间只有一条链表，直接返回
        if (l == r) return lists[l];
        int mid = (l + r) / 2;
        ListNode left = merge(lists, l, mid);
        ListNode right = merge(lists, mid + 1, r);
        // 合并两条有序链表
        return mergeTwo(left, right);
    }
    // 基础工具：合并两条升序链表
	private ListNode mergeTwo(ListNode a, ListNode b) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (a != null && b != null) {
            if (a.val < b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        cur.next = a == null ? b : a;
        return dummy.next;
    }
}
