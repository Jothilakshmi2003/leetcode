import java.util.*;

// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        int n = 1;
        ListNode tail = head;

        // Find length and tail
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        // Make it circular
        tail.next = head;

        k = k % n;

        int steps = n - k - 1;
        ListNode newTail = head;

        while (steps-- > 0) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;

        // Break the circle
        newTail.next = null;

        return newHead;
    }

    // Helper: create linked list from array
    public static ListNode createList(int[] arr) {
        if (arr.length == 0)
            return null;

        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;

        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }

        return head;
    }

    // Helper: print linked list
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter node values:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter k (rotations): ");
        int k = sc.nextInt();

        ListNode head = createList(arr);

        System.out.print("Original List: ");
        printList(head);

        Solution obj = new Solution();
        head = obj.rotateRight(head, k);

        System.out.print("Rotated List: ");
        printList(head);

        sc.close();
    }
}
