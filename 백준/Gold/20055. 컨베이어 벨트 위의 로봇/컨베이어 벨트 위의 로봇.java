import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] stream = new int[2 * N];
        boolean[] is_robot = new boolean[2 * N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) stream[i] = Integer.parseInt(st.nextToken());
        int z_count = 0;
        int gen = 0;
        while (z_count < K)
        {
            int temp = stream[2 * N - 1];
            System.arraycopy(stream, 0, stream, 1, stream.length - 1);
            stream[0] = temp;
            boolean temp1 = is_robot[2 * N - 1];
            System.arraycopy(is_robot, 0, is_robot, 1, is_robot.length - 1);
            is_robot[0] = temp1;
            if (is_robot[N - 1]) is_robot[N - 1] = false;
            for (int i = N - 2; i >= 0; i--) {
                boolean elem = is_robot[i];
                if (elem && !is_robot[i + 1] && stream[i + 1] > 0) {
                    is_robot[i] = false;
                    is_robot[i + 1] = true;
                    stream[i + 1]--;
                    if (stream[i + 1] == 0) z_count++;
                }
            }
            if (is_robot[N - 1]) is_robot[N - 1] = false;
            if (stream[0] > 0) {
                is_robot[0] = true;
                stream[0]--;
                if (stream[0] == 0) z_count++;
            }
            gen++;
        }
        System.out.println(gen);
    }
}
