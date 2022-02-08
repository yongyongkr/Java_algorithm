/**
 * 백준 13904번
 * 과제
 * https://www.acmicpc.net/problem/13904
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13904 {

	static class Task implements Comparable<Task> {
		int dueDate;
		int score;

		public Task(int dueDate, int score) {
			this.dueDate = dueDate;
			this.score = score;
		}

		@Override
		public int compareTo(Task o) {
			return Integer.compare(o.score, this.score);
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Queue<Task> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.offer(new Task(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		int[] dp = new int[1001];

		while (!pq.isEmpty()) {
			Task task = pq.poll();
			int temp = task.dueDate;
			while (temp > 0 && dp[temp] != 0) {
				temp--;
			}
			if (temp == 0) continue;
			dp[temp] = task.score;
		}

		int totalScore = 0;
		for (int i = 1; i < dp.length; i++) {
			totalScore += dp[i];
		}

		System.out.println(totalScore);
	}
}
