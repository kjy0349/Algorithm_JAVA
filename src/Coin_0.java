import java.util.*;
import java.util.stream.Collectors;

public class Coin_0 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int N = nums.get(0);
        int K = nums.get(1);
        int result = 0;
        ArrayList<Integer> coins = new ArrayList<>();
        for(int i=0; i<N; i++){
            coins.add(scan.nextInt());
        }
        coins.sort(Collections.reverseOrder());
        int i = 0;
        while (K > 0 && i < coins.size()){
            if (coins.get(i) < K){
                result += K / coins.get(i);
                K -= K / coins.get(i) * coins.get(i);
            }
            i += 1;
        }
        System.out.print(result);
    }
}
