/**
 * 백준 1202번
 * 보석 도둑
 * https://www.acmicpc.net/problem/1202
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1202 {

	static class Jewel implements Comparable<Jewel> {
		int mass;
		int price;

		public Jewel(int mass, int price) {
			this.mass = mass;
			this.price = price;
		}

		@Override
		public int compareTo(Jewel o) {
			if (this.mass == o.mass) {
				return Integer.compare(o.price, this.price);
			}
			return Integer.compare(this.mass, o.mass);
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Queue<Jewel> jewels = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			jewels.add(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		Queue<Integer> bags = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			bags.offer(Integer.parseInt(br.readLine()));
		}

		Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		long answer = 0L;
		while (!bags.isEmpty()) {
			int bag = bags.poll();
			while (!jewels.isEmpty() && jewels.peek().mass <= bag) {
				pq.offer(jewels.poll().price);
			}

			if (!pq.isEmpty()) {
				answer += pq.poll();
			}
		}

		System.out.println(answer);
	}
}
