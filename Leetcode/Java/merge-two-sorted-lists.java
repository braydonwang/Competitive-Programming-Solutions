class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode root = ans;
        while (l1 != null || l2 != null){
            if (l1 == null){
                ans.next = l2;
                l2 = null;
            } else if (l2 == null){
                ans.next = l1;
                l1 = null;
            } else {
                int v1 = l1.val, v2 = l2.val;
                if (v1 < v2){
                    ans.next = new ListNode(v1);
                    l1 = l1.next;
                } else {
                    ans.next = new ListNode(v2);
                    l2 = l2.next;
                }
                ans = ans.next;
            }
        }
        return root.next;
    }
}
