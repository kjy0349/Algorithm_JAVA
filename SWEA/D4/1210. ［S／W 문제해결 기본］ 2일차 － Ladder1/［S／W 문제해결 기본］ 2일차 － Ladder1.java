import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] map = new int[100][100];
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < 10; t++) {
            int T = Integer.parseInt(br.readLine());
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) map[i][j] = Integer.parseInt(st.nextToken());  
            }
            int answer = -1;
            outLoop:
            for (int i = 0; i < 100; i++) {
                if (map[0][i] == 1) {
                    int x = 0;
                    int y = i;
                    while (x < map.length) {
                        if (map[x][y] == 2) {
                            answer = i;
                            break outLoop;
                        }
                        if (y + 1 < map[0].length && map[x][y + 1] == 1) {
                            while (y + 1 < map[0].length && map[x][y + 1] == 1) y++;
                            x++;
                        } else if (y - 1 >= 0 && map[x][y - 1] == 1) {
                            while (y - 1 >= 0 && map[x][y - 1] == 1) y--;
                            x++;
                        } else x++;         
                    }
                }
            }
            sb.append("#");
            sb.append(T);
            sb.append(" ");
            sb.append(answer);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}