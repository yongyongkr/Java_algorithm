package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1828 {

	static class Chemical implements Comparable<Chemical> {
		int low;
		int high;

		public Chemical(int low, int high) {
			this.low = low;
			this.high = high;
		}

		@Override
		public int compareTo(Chemical o) {
			return Integer.compare(this.high, o.high);
		}
	}

	static int cnt = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		Queue<Chemical> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			pq.offer(new Chemical(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		while (!pq.isEmpty()) {
			Chemical cur = pq.poll();
			while (!pq.isEmpty() && pq.peek().low <= cur.high) {
				pq.poll();
			}
			cnt++;
		}

		System.out.println(cnt);
	}
}
