/**
 * 백준 2285번
 * 우체국
 * https://www.acmicpc.net/problem/2285
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2285 {

	static class Town implements Comparable<Town> {
		int loc;
		long ppl;

		public Town(int loc, long ppl) {
			this.loc = loc;
			this.ppl = ppl;
		}

		@Override
		public int compareTo(Town o) {
			if (this.loc == o.loc) {
				return Long.compare(this.ppl, o.ppl);
			}
			return Integer.compare(this.loc, o.loc);
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		Queue<Town> pq = new PriorityQueue<>();
		long population = 0L;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int loc = Integer.parseInt(st.nextToken());
			long ppl = Long.parseLong(st.nextToken());
			pq.offer(new Town(loc, ppl));
			population += ppl;
		}

		long curSum = 0L;
		while (!pq.isEmpty()) {
			Town cur = pq.poll();
			curSum += cur.ppl;
			if (curSum >= (population + 1) / 2) {
				System.out.println(cur.loc);
				break;
			}
		}
	}
}
