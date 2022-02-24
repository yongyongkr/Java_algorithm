/**
 * 백준 1753번
 * 최단 경로
 * https://www.acmicpc.net/problem/1753
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1753 {

	static class Node implements Comparable<Node> {
		int to;
		int cost;

		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node node) {
			return Integer.compare(this.cost, node.cost);
		}
	}

	static int v, e;
	static List<List<Node>> nodeList;
	static int[] dist;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());

		nodeList = new ArrayList<>();
		for (int i = 0; i <= v; i++) {
			nodeList.add(new ArrayList<>());
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			nodeList.get(from).add(new Node(to, weight));
		}

		dist = new int[v + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		dijkstra(start);

		for (int i = 1; i <= v; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
	}

	private static void dijkstra(int start) {
		Queue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[v + 1];
		pq.offer(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (visited[cur.to])
				continue;
			visited[cur.to] = true;

			for (Node next : nodeList.get(cur.to)) {
				if (dist[next.to] > dist[cur.to] + next.cost) {
					dist[next.to] = dist[cur.to] + next.cost;
					pq.offer(new Node(next.to, dist[next.to]));
				}
			}
		}
	}
}
