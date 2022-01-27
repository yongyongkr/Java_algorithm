/**
 * 백준 1916번
 * 최소비용 구하기
 * https://www.acmicpc.net/problem/1916
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1916 {

	static class Node implements Comparable<Node> {
		int end;
		int cost;

		public Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	static int n, m;
	static List<List<Node>> list;
	static int[] dist;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		dist = new int[n + 1];
		visited = new boolean[n + 1];

		Arrays.fill(dist, Integer.MAX_VALUE);
		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int city1 = Integer.parseInt(st.nextToken());
			int city2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list.get(city1).add(new Node(city2, cost));
		}

		st = new StringTokenizer(br.readLine());
		int departure = Integer.parseInt(st.nextToken());
		int arrival = Integer.parseInt(st.nextToken());

		int result = dijkstra(departure, arrival);
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		br.close();
	}

	private static int dijkstra(int from, int to) {
		Queue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(from, 0));
		dist[from] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int start = cur.end;
			if (!visited[start]) {
				visited[start] = true;
				for (Node node : list.get(start)) {
					if (!visited[node.end] && dist[node.end] > dist[start] + node.cost) {
						dist[node.end] = dist[start] + node.cost;
						pq.offer(new Node(node.end, dist[node.end]));
					}
				}
			}
		}
		return dist[to];
	}
}
