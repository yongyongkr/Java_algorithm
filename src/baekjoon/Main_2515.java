/**
 * 백준 2515번
 * 전시장
 * https://www.acmicpc.net/problem/2515
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2515 {

	static class Painting implements Comparable<Painting> {
		int height;
		int price;

		public Painting(int height, int price) {
			this.height = height;
			this.price = price;
		}

		@Override
		public int compareTo(Painting o) {
			if (this.height == o.height) {
				return Integer.compare(this.price, o.price);
			}
			return Integer.compare(this.height, o.height);
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int piece = Integer.parseInt(st.nextToken());
		int least = Integer.parseInt(st.nextToken());
		int[] dp = new int[20_000_001];

		Queue<Painting> pq = new PriorityQueue<>();
		for (int i = 0; i < piece; i++) {
			st = new StringTokenizer(br.readLine());
			pq.offer(new Painting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		for (int i = 1; i < 20_000_001; i++) {
			Painting cur = pq.poll();
			while (!pq.isEmpty() && pq.peek().height == cur.height) {
				cur = pq.poll();
			}
			if (cur.height < least) {
				continue;
			}
			while (i < cur.height) {
				dp[i] = dp[i - 1];
				i++;
			}

			dp[i] = Math.max(dp[i - least] + cur.price, dp[i - 1]);

			if (pq.isEmpty()) {
				System.out.println(dp[i]);
				break;
			}
		}
	}
}
