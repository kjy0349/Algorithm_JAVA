package backjoon;
import java.io.*;
import java.util.*;
public class lottery {
    public static BufferedWriter ber = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void find_solution(ArrayList<Integer> array, ArrayList<Integer> answer,int R,int start, int depth, boolean[] visited) throws IOException {
        if (R == 0){
            for(int i=0;i< answer.size();i++) {
                ber.write(answer.get(i) + " ");
            }
            ber.newLine();
        } else{
            for(int i=start;i< array.size();i++){
                if(!visited[i]){
                    visited[i] = true;
                    answer.add(array.get(i));
                    find_solution(array, answer ,R - 1,i + 1,depth+1, visited);
                    answer.remove(array.get(i));
                    visited[i] = false;
                }
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
                ArrayList<Integer> nums = new ArrayList<>();
                for(int i=1;i<input.length;i++){
                    nums.add(Integer.parseInt(input[i]));
                }
                find_solution(nums, new ArrayList<>(), 6, 0,0 , new boolean[nums.size()]);
            }
            ber.flush();
            ber.newLine();
        }
    }

}
