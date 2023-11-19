```java
// Runtime: 0 ms (Top 100%) | Memory: 39 MB (Top 80.53%)
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null)
            return null;
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode newHead = new ListNode();
        ListNode newNode = newHead;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                newNode.next = list1;
                list1 = list1.next;
            } else {
                newNode.next = list2;
                list2 = list2.next;
            }
            newNode = newNode.next;
        }
        if (list1 != null)
            newNode.next = list1;
        else if (list2 != null)
            newNode.next = list2;
        return newHead.next;
    }
}
```