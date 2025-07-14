public class Convert_Binary_Number_in_a_Linked_List_to_Integer {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static int getDecimalValue(ListNode head) {
        ListNode p1 = head;
        int n = 0;

        while (p1 != null) {
            n++;
            p1 = p1.next;
        }

        int sum = 0;
        p1 = head;
        while (p1 != null) {
            sum += p1.val * (int) Math.pow(2, --n);
            p1 = p1.next;
        }

        return sum;
    }

    public static void main(String[] args) {
        // Convert_Binary_Number_in_a_Linked_List_to_Integer solution = new Convert_Binary_Number_in_a_Linked_List_to_Integer();

        // Example 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(0);
        head1.next.next = new ListNode(1);
        System.out.println(getDecimalValue(head1)); // Output: 5

        // Example 2
        ListNode head2 = new ListNode(0);
        System.out.println(getDecimalValue(head2)); // Output: 0
    }
}

/*
 * 1290. Convert Binary Number in a Linked List to Integer Solved Easy Topics
 * premium lock icon Companies Hint Given head which is a reference node to a
 * singly-linked list. The value of each node in the linked list is either 0 or
 * 1. The linked list holds the binary representation of a number.
 * 
 * Return the decimal value of the number in the linked list.
 * 
 * The most significant bit is at the head of the linked list.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,0,1] Output: 5 Explanation: (101) in base 2 = (5) in base 10
 * Example 2:
 * 
 * Input: head = [0] Output: 0
 * 
 * 
 * Constraints:
 * 
 * The Linked List is not empty. Number of nodes will not exceed 30. Each node's
 * value is either 0 or 1.
 */