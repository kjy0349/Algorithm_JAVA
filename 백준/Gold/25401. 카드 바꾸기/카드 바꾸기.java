import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        int minAnswer = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) nums[i] = Integer.parseInt(st.nextToken());
        Set<Integer> possDiff = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) possDiff.add(nums[i + 1] - nums[i]);
        possDiff.add(0);
        for (int diff : possDiff) { // diff : targetDiff. 해당 등차로 만들어야 함.
            for (int i = 0; i < nums.length; i++) { // 중심이 될 수
                int[] tempNums = nums.clone();
                int subAnswer = 0;
                for (int j = i; j < nums.length - 1; j++) {
                    if (tempNums[j] + diff != tempNums[j + 1]) {
                        subAnswer++;
                        tempNums[j + 1] = tempNums[j] + diff;
                    }
                }
                for (int j = i; j > 0; j--) {
                    if (tempNums[j] - diff != tempNums[j - 1]) {
                        subAnswer++;
                        tempNums[j - 1] = tempNums[j] - diff;
                    }
                }
                if (subAnswer < minAnswer) minAnswer = subAnswer;
                if (diff == 0) break;
            }
        }
        System.out.println(minAnswer);
    }
}