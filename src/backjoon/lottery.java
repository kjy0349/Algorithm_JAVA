package backjoon;
import java.io.*;
import java.util.*;
public class lottery {
    public static BufferedWriter ber = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void find_solution(HashSet<Integer> array, ArrayList<Integer> answer, int depth, boolean[] visited) throws IOException {
        if (depth == 6){
            Collections.sort(answer);
            for(int temp:answer) {
                ber.write(temp + " ");
            }
            ber.newLine();
        } else{
            Iterator<Integer> it = array.iterator();
            int i = 0;
            while(it.hasNext()){
                int elem = it.next();
                if(!visited[i]){
                    visited[i] = true;
                    answer.add(elem);
                    find_solution(array, answer ,depth+1, visited);
                    answer.remove(answer.indexOf(elem));
                    visited[i] = false;
                }
                i++;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String[] input = br.readLine().split(" ");
            if (input[0].equals("0")){
                break;
            } else{
                HashSet<Integer> nums = new HashSet<>();
                for(int i=0;i<input.length;i++){
                    nums.add(Integer.parseInt(input[i]));
                }
                System.out.println(nums);
                find_solution(nums, new ArrayList<>(), 0, new boolean[nums.size()]);
            }
            ber.newLine();
        }
    }

}
