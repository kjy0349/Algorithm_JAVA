import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	// 나중에 있는 일이 라면을 더 많이 주는 경우
	static class Ramen {
		int dead;
		int price;
		Ramen(int dead, int price) {
			this.dead = dead;
			this.price = price;
		}
//		@Override
//		public String toString() {
//			return "Ramen [dead=" + dead + ", price=" + price + "]";
//		}
		
	}
//	static String[] input = {"7\r\n" + 
//			"1 6\r\n" + 
//			"1 7\r\n" + 
//			"3 2\r\n" + 
//			"3 1\r\n" + 
//			"2 4\r\n" + 
//			"2 5\r\n" + 
//			"6 1",
//			
//			"3\r\n" +
//			"1 6\r\n" + 
//			"1 7\r\n" +
//			"6 100",
//			
//			"3\r\n" + 
//			"1 6\r\n" + 
//			"2 50\r\n" +  
//			"2 100"};
	// 제일 큰걸 선택하면서, 최선의 시간에 잡아야 한다...
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int answer = 0;
		// 제일 큰걸 갖고온다.
		// 그걸, 가장 늦게 있는 인덱스에 넣어준다.
		PriorityQueue<Ramen> pq = new PriorityQueue<>((Ramen a, Ramen b) -> {
			if (a.dead != b.dead) {
				return Integer.compare(a.dead, b.dead);
			} else {
				return Integer.compare(b.price, a.price);
			}
		});
		
		PriorityQueue<Ramen> solvedpq = new PriorityQueue<>((Ramen a, Ramen b) ->  {
			return Integer.compare(a.price, b.price);
		});
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.offer(new Ramen(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		int time = 1;
		while (!pq.isEmpty()) {
			Ramen target = pq.poll();
			if (target.dead >= time) {
				solvedpq.offer(target);
				time++;
			} else {
				if (!solvedpq.isEmpty()) {
					Ramen least = solvedpq.peek();
					if (least.price < target.price) {
						solvedpq.poll();
						solvedpq.offer(target);
					}
				}
			}
		}
		while (!solvedpq.isEmpty()) answer += solvedpq.poll().price;
		System.out.println(answer);
	}
}