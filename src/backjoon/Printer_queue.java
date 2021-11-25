package backjoon;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Printer_queue implements Comparable<Printer_queue>{
    private int priority;
    private int index;

    public Printer_queue (int priority, int index){
        this.priority = priority;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
    public int getPriority(){
        return priority;
    }
    @Override
    public int compareTo(Printer_queue queue){
        if (this.priority > queue.getPriority()){
            return 1;
        } else if(this.priority < queue.getPriority()){
            return -1;
        } else{
            return 0;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter ber = new BufferedWriter(new OutputStreamWriter(System.out));
        int case_count = Integer.parseInt(br.readLine());
        String[] inputs;
        List<Integer> documents;
        int target = 0;
        int max = 0;
        int j;
        Deque<Printer_queue> queue = new ArrayDeque<>();
        Printer_queue temp;
        for(int i=0;i<case_count;i++){
            inputs = br.readLine().split(" ");
            documents = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            for(int x=0;x<documents.size();x++){
                queue.add(new Printer_queue(documents.get(x), x));
            }
            target = Integer.parseInt(inputs[1]);
            j = 0;
            while(!queue.isEmpty()){
                max = Collections.max(queue).getPriority();
                temp = queue.poll();
                if (max == temp.getPriority()){
                    j++;
                    if (temp.getIndex() == target){
                        ber.write(Integer.toString(j));
                        ber.newLine();
                        break;
                    }
                } else{
                    queue.addLast(temp);
                }
            }
            queue.clear();
        }
        ber.flush();
    }
}
