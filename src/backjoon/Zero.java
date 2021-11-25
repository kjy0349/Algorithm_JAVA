package backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class Zero {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int answer = 0;
        int num = 0;
        Stack<Integer> numbers = new Stack<>();
        for(int i=0;i<K;i++) {
            num = Integer.parseInt(br.readLine());
            if (num == 0) {
                numbers.pop();
            } else{
                numbers.add(num);
            }
        }
        while (numbers.size() > 0) answer += numbers.pop();
        System.out.println(answer);
    }
}
