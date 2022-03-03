/**
 * 백준 1516번
 * 게임 개발
 * https://www.acmicpc.net/problem/1516
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1516 {

	static int n;
	static List<List<Integer>> graph = new ArrayList<>();
	static int[] degrees, requireTime;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		degrees = new int[n + 1];
		requireTime = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int prerequisite = Integer.parseInt(st.nextToken());
			if (prerequisite == -1) {
				requireTime[i] = time;
				continue;
			}
			do {
				graph.get(prerequisite).add(i);
				degrees[i]++;
				requireTime[i] = time;

				prerequisite = Integer.parseInt(st.nextToken());
			} while (prerequisite != -1);
		}

		topologicalSort();

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(requireTime[i]).append("\n");
		}
		System.out.print(sb);
	}

	private static void topologicalSort() {
		Queue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(o -> requireTime[o]));
		for (int i = 1; i <= n; i++) {
			if (degrees[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int curIdx = q.poll();
			for (int nextIdx : graph.get(curIdx)) {
				if (--degrees[nextIdx] == 0) {
					requireTime[nextIdx] += requireTime[curIdx];
					q.offer(nextIdx);
				}
			}
		}
	}
}
