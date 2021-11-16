package backjoon;
import java.util.*;
import java.io.*;

public class Operator_insert {
    public static ArrayList<Integer> possible = new ArrayList<>();
    public static void find_possible(int[] num, int[] operator, int depth, int answer, boolean[] visited){
        if (depth == num.length - 1){
            possible.add(answer);
        } else{
            for(int i=0;i<num.length-1;i++){
                if (!visited[i]){
                    for(int j=0;j<operator.length;j++){
                        if (depth == 0 && operator[j] > 0){
                            visited[i] = visited[i+1] = true;
                            operator[j] -= 1;
                            answer = calculate(num[i], num[i+1], j);
                            find_possible(num, operator, depth + 1, answer, visited);
                            visited[i] = visited[i+1] = false;
                            operator[j] += 1;
                        } else if(depth > 0 && operator[j] > 0){
                            visited[i] = true;
                            operator[j] -= 1;
                            answer = calculate(answer, num[i], j);
                            find_possible(num, operator, depth + 1, answer, visited);
                            visited[i] = false;
                            operator[j] += 1;
                        }
                    }
                }
            }
        }
    }
    public static int calculate(int operand1, int operand2, int index){
        if (index == 0){
            return operand1 + operand2;
        } else if(index == 1){
            return operand1 - operand2;
        } else if(index == 2){
            return operand1 * operand2;
        } else{
            return operand1 / operand2;
        }
    }
    public static void main(String[] args) throws IOException{
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            /* 들어오는 숫자들 */
            int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            /* 각 연산자별 개수들 */
            int[] operators = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            boolean[] visited = new boolean[N];
            find_possible(nums, operators, 0, 0,visited);
            System.out.println(Collections.max(possible));
            System.out.println(Collections.min(possible));
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
