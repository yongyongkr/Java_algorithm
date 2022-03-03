/**
 * 백준 9370번
 * 미확인 도착지
 * https://www.acmicpc.net/problem/9370
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9370 {

	static class Edge implements Comparable<Edge> {
		int to;
		int cost;

		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge edge) {
			return Integer.compare(this.cost, edge.cost);
		}
	}

	static final int INF = 100_000_000;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int intersect = Integer.parseInt(st.nextToken());
			int road = Integer.parseInt(st.nextToken());
			int destination = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int visit1 = Integer.parseInt(st.nextToken());
			int visit2 = Integer.parseInt(st.nextToken());

			List<List<Edge>> graph = new ArrayList<>();
			for (int i = 0; i <= intersect; i++) {
				graph.add(new ArrayList<>());
			}

			for (int i = 0; i < road; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				graph.get(from).add(new Edge(to, cost));
				graph.get(to).add(new Edge(from, cost));
			}

			List<Integer> destinations = new ArrayList<>();
			for (int i = 0; i < destination; i++) {
				destinations.add(Integer.parseInt(br.readLine()));
			}

			int[] dist = new int[intersect + 1];
			Arrays.fill(dist, INF);
			dijkstra(graph, dist, start);

			int[] dist2 = new int[intersect + 1];
			Arrays.fill(dist2, INF);
			int tempDistance = 0;

			if (dist[visit1] < dist[visit2]) {
				dijkstra(graph, dist2, visit2);
				tempDistance = dist[visit1] + dist2[visit1];
			} else if (dist[visit1] > dist[visit2]) {
				dijkstra(graph, dist2, visit1);
				tempDistance = dist[visit2] + dist2[visit2];
			}

			Collections.sort(destinations);
			for (int town : destinations) {
				if (tempDistance + dist2[town] == dist[town]) {
					sb.append(town).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	private static void dijkstra(List<List<Edge>> graph, int[] dist, int start) {
		Queue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			int curNode = cur.to;

			for (Edge next : graph.get(curNode)) {
				if (dist[next.to] > dist[curNode] + next.cost) {
					dist[next.to] = dist[curNode] + next.cost;
					pq.offer(next);
				}
			}
		}
	}
}
