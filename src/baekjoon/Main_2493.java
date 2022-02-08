/**
 * 백준 2493번
 * 탑
 * https://www.acmicpc.net/problem/2493
 */

package baekjoon;

import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.PriorityQueue;
	import java.util.Queue;
	import java.util.Stack;
	import java.util.StringTokenizer;

public class Main_2493 {

	static class Tower implements Comparable<Tower> {
		int index;
		int height;

		public Tower(int index, int height) {
			super();
			this.index = index;
			this.height = height;
		}

		@Override
		public int compareTo(Tower o) {
			return Integer.compare(this.height, o.height);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] answer = new int[n];

		Stack<Tower> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			stack.push(new Tower(i + 1, Integer.parseInt(st.nextToken())));
		}

		Queue<Tower> pq = new PriorityQueue<>();

		while (!stack.isEmpty()) {
			Tower receiver = stack.pop();
			while (!pq.isEmpty() && pq.peek().height <= receiver.height) {
				Tower sender = pq.poll();
				answer[sender.index - 1] = receiver.index;
			}
			pq.offer(receiver);
		}

		StringBuilder sb = new StringBuilder();
		for (int j : answer) {
			sb.append(j).append(" ");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
