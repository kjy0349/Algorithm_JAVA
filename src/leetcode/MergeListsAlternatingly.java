package leetcode;

public class MergeListsAlternatingly {
    static class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }
    }

    public void mergeAlt(Node head1, Node head2){
        Node current1 = head1;
        Node current2 = head2;
        while (current1.next != null && current2 != null) {
            Node temp = current1.next;
            current1.next = new Node(current2.data);
            current1 = current1.next;
            current1.next = temp;
            current1 = current1.next;
            current2 = current2.next;
        }
        if (current1.next == null && current2 != null) {
            current1.next = new Node(current2.data);
            current1 = current1.next;
            current2 = current2.next;
        }
        while (head1 != null) {
            System.out.print(head1.data + " ");
            head1 = head1.next;
        }
        System.out.println();
        while (current2 != null) {
            System.out.print(current2.data + " ");
            current2 = current2.next;
        }
    }
}
