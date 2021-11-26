package backjoon;
import java.io.*;

public class Josefus {
    public static class Node{
        public int value;
        public Node next = null;

        Node(int value){
            this.value = value;
        }

        void append(int value){
            Node end = new Node(value);
            Node point = this;
            while(point.next != null){
                if(point.next == this){
                    break;
                }
                point = point.next;
            }
            point.next = end;
            end.next = this;
        }

        void delete(int value){
            Node point = this;
            while(point.next.value != value){
                point = point.next;
            }
            point.next = point.next.next;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);
        Node node = new Node(1);
        for(int i=2;i<=N;i++){
            node.append(i);
        }
        int z = 0;
        Node pointer = node;
        for(int i=0;i<K-1;i++){
             pointer = pointer.next;
        }
        if(N == 1){
            System.out.print("<"+pointer.value+">");
        } else{
            System.out.print("<"+pointer.value + ", ");
            node.delete(pointer.value);
        }
        while(z < N - 1){
            for(int i=0;i<K;i++){
                pointer = pointer.next;
            }
            if(z == N-2){
                System.out.print(pointer.value+">");
            } else{
                System.out.print(pointer.value + ", ");
            }
            if(node.value == pointer.value){
                node.delete(pointer.value);
                node = node.next;
            } else{
                node.delete(pointer.value);
            }
            z++;
        }
    }
}
