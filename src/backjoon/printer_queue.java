package backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;

public class printer_queue {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter ber = new BufferedWriter(new OutputStreamWriter(System.out));
        int case_count = Integer.parseInt(br.readLine());
        String[] inputs;
        List<Integer> documents;
        int target = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<case_count;i++){
            inputs = br.readLine().split(" ");
            documents = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            queue.addAll(documents);
            target = documents.get(Integer.parseInt(inputs[1]));
            for(int j=0;j<queue.size();j++){
                if(queue.poll() == target){
                    ber.write(Integer.toString(j+1));
                    ber.newLine();
                    break;
                } else{

                }
            }
        }
        ber.flush();
    }
}
