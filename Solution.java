class LinkedList {
    int val;
    LinkedList next;
    LinkedList(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public boolean hasCycle(LinkedList head) {
        if(head == null){
            return false;
        }
        LinkedList slow = head;
        LinkedList fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedList head = new LinkedList(1);
        Solution solution = new Solution();
        boolean res = solution.hasCycle(head);
        System.out.println(res);
    }
}
