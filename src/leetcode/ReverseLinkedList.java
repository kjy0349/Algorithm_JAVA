package leetcode;
import java.util.*;

public class ReverseLinkedList {
    static class Node
    {
        int data;
        Node next;
        Node(int key)
        {
            data = key;
            next = null;
        }
    }

    public static Node reverse(Node node, int k)
    {
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        int count = 0;

        while (node != null) {
            if (count == k) {
                Collections.reverse(temp);
                for (int elem : temp) arr.add(elem);
                temp.clear();
                count = 0;
            }
            temp.add(node.data);
            node = node.next;
            count++;
        }

        if (temp.size() != 0) {
            Collections.reverse(temp);
            for (int elem : temp) arr.add(elem);
        }

        Node head1 = new Node(arr.get(0));
        Node current = head1;
        for (int i = 1; i < arr.size(); i++) {
            current.next = new Node(arr.get(i));
            current = current.next;
        }

        return head1;
    }
}
