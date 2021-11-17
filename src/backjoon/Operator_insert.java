package backjoon;
import java.util.*;
import java.io.*;

public class Operator_insert {
    public static ArrayList<String> possibles = new ArrayList<>();
    public static void find_possible(int[] operator, int depth, String answer, int operator_sum){
        if (depth == operator_sum){
            possibles.add(answer);
        } else{
            for(int i=0;i < operator.length; i++) {
                if (operator[i] > 0) {
                    operator[i] -= 1;
                    answer += convert(i);
                    find_possible(operator, depth + 1, answer, operator_sum);
                    answer = answer.substring(0, answer.length()-1);
                    operator[i] += 1;
                }
            }
        }
    }
    public static void print_max_min(int[] nums){
        ArrayList<Integer> sums = new ArrayList<>();
        for(int i=0;i< possibles.size();i++){
            int temp = 0;
            int index = 0;
            while(index < possibles.get(i).length()){
                if (index == 0){
                    temp += calculate(nums[index], nums[index+1], possibles.get(i).charAt(index));
                } else{
                    temp = calculate(temp, nums[index+1], possibles.get(i).charAt(index));
                }
                index += 1;
            }
            sums.add(temp);
        }
        System.out.println(Collections.max(sums));
        System.out.println(Collections.min(sums));
    }
    public static int calculate(int operand1, int operand2, char operator){
        if (operator == '+'){
            return operand1 + operand2;
        } else if (operator == '-'){
            return operand1 - operand2;
        } else if (operator == '*'){
            return operand1 * operand2;
        } else{
            return operand1 / operand2;
        }
    }
    public static String convert(int index){
        if (index == 0){
            return "+";
        } else if(index == 1){
            return "-";
        } else if(index == 2){
            return "*";
        } else{
            return "/";
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        /* 들어오는 숫자들 */
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        /* 각 연산자별 개수들 */
        int[] operators = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        find_possible(operators, 0, "", Arrays.stream(operators).sum());
        print_max_min(nums);
    }
}
