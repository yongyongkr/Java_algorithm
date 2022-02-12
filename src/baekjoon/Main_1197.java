/**
 * 백준 1197번
 * 최소 스패닝 트리
 * https://www.acmicpc.net/problem/1197
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1197 {

	static int[] parent;
	static int cost;

	static class Edge implements Comparable<Edge> {
		int node1;
		int node2;
		int weight;

		public Edge(int node1, int node2, int weight) {
			this.node1 = node1;
			this.node2 = node2;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		parent = new int[v + 1];
		cost = 0;
		Queue<Edge> pq = new PriorityQueue<>();

		for (int i = 1; i <= v; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			pq.offer(new Edge(Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken())));
		}

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			union(cur.node1, cur.node2, cur.weight);
		}

		System.out.println(cost);
	}

	private static int find(int n) {
		if (n == parent[n]) {
			return n;
		}
		return parent[n] = find(parent[n]);
	}

	private static void union(int x, int y, int weight) {
		x = find(x);
		y = find(y);
		if (x < y) {
			parent[y] = x;
			cost += weight;
		} else if (x > y) {
			parent[x] = y;
			cost += weight;
		}
	}
}
