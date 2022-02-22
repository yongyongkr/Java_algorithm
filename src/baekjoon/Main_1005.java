/**
 * 백준 1005번
 * ACM Craft
 * https://www.acmicpc.net/problem/1005
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1005 {

	static int buildings, orders, goal;
	static int[] times, degrees;
	static List<List<Integer>> graph;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			buildings = Integer.parseInt(st.nextToken());
			orders = Integer.parseInt(st.nextToken());

			times = new int[buildings + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= buildings; i++) {
				times[i] = Integer.parseInt(st.nextToken());
			}

			degrees = new int[buildings + 1];

			graph = new ArrayList<>();
			for (int i = 0; i <= buildings; i++) {
				graph.add(new ArrayList<>());
			}

			for (int i = 0; i < orders; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				graph.get(from).add(to);
				degrees[to] += 1;
			}

			goal = Integer.parseInt(br.readLine());

			topologicalSort();
		}
	}

	private static void topologicalSort() {
		Queue<Integer> q = new LinkedList<>();
		int[] result = new int[buildings + 1];

		for (int i = 1; i <= buildings; i++) {
			result[i] = times[i];

			if (degrees[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int node = q.poll();

			for (int next : graph.get(node)) {
				result[next] = Math.max(result[next], result[node] + times[next]);
				degrees[next] -= 1;

				if (degrees[next] == 0) {
					q.offer(next);
				}
			}
		}

		System.out.println(result[goal]);
	}
}
