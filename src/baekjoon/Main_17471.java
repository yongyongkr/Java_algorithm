/**
 * 백준 17471번
 * 게리맨더링
 * https://www.acmicpc.net/problem/17471
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17471 {

	static int n, min, totalPopulation;
	static List<List<Integer>> graph;
	static int[] population;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;

		population = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			population[i] = Integer.parseInt(st.nextToken());
			totalPopulation += population[i];
		}

		graph = new ArrayList<>();
		graph.add(new ArrayList<>());
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());

			List<Integer> temp = new ArrayList<>();
			for (int j = 0; j < num; j++) {
				temp.add(Integer.parseInt(st.nextToken()));
			}

			graph.add(i, temp);
		}

		visited = new boolean[1 << (n + 1)];
		subset(1, 0);

		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	private static void subset(int start, int check) {
		if (start > n) {
			if (visited[check] || check == 0 || check == 1 << (n + 1) - 1 || !isConnected(check))
				return;

			visited[check] = true;
			visited[1 << (n + 1) - 1 & ~check] = true;

			int sum = 0;
			for (int i = 0; i < n; i++) {
				if ((check & 1 << i) != 0)
					sum += population[i + 1];
			}

			int diff = Math.abs(totalPopulation - 2 * sum);
			if (diff < min) {
				min = diff;
			}
			return;
		}

		subset(start + 1, check | 1 << start);
		subset(start + 1, check);
	}

	private static boolean isConnected(int check) {
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if ((check & 1 << i) != 0) {
				left.add(i + 1);
			} else {
				right.add(i + 1);
			}
		}

		return checkConnection(left) && checkConnection(right);
	}

	private static boolean checkConnection(List<Integer> list) {
		boolean[] visits = new boolean[n + 1];
		dfs(list.get(0), visits, list);
		int connectCnt = 0;
		for (int i = 0; i < visits.length; i++) {
			if (visits[i])
				connectCnt++;
		}
		return connectCnt == list.size();
	}

	private static void dfs(int start, boolean[] visits, List<Integer> list) {
		if (visits[start])
			return;
		visits[start] = true;
		for (int next : graph.get(start)) {
			if (list.contains(next)) {
				dfs(next, visits, list);
			}
		}
	}
}
