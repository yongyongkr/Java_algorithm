/**
 * 백준 2252번
 * 줄 세우기
 * https://www.acmicpc.net/problem/2252
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

public class Main_2252 {

	static int n, m;
	static List<List<Integer>> graph;
	static int[] degrees;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		degrees = new int[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int forward = Integer.parseInt(st.nextToken());
			int backward = Integer.parseInt(st.nextToken());
			graph.get(forward).add(backward);
			degrees[backward]++;
		}

		topologySort();
		sb.deleteCharAt(sb.length() - 1);

		System.out.println(sb);
	}

	private static void topologySort() {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			if (degrees[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int start = q.poll();
			for (int next : graph.get(start)) {
				if (--degrees[next] == 0) {
					q.offer(next);
				}
			}
			sb.append(start).append(" ");
		}
	}
}
