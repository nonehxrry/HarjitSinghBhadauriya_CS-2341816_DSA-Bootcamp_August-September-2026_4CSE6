class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        int gap = 1;

        while (gap < lists.length) {
            for (int i = 0; i + gap < lists.length; i += 2 * gap) {
                lists[i] = merge(lists[i], lists[i + gap]);
            }
            gap *= 2;
        }

        return lists[0];
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(-1), curr = dummy;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                curr.next = a;
                a = a.next;
            } else {
                curr.next = b;
                b = b.next;
            }
            curr = curr.next;
        }

        curr.next = (a != null) ? a : b;
        return dummy.next;
    }
}
