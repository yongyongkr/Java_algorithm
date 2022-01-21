/**
 * 백준 1922번
 * 네트워크 연결
 * https://www.acmicpc.net/problem/1922
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main_1922 {

	static class Edge implements Comparable<Edge> {
		int v1;
		int v2;
		int cost;

		public Edge(int v1, int v2, int cost) {
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge c) {
			return Integer.compare(this.cost, c.cost);
		}
	}

	static int[] parent;
	static List<Edge> edges = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			edges.add(new Edge(Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken())));
		}

		Collections.sort(edges);

		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		int sum = 0;
		for (int i = 0; i < edges.size(); i++) {
			Edge edge = edges.get(i);
			if (find(edge.v1) != find(edge.v2)) {
				sum += edge.cost;
				union(edge.v1, edge.v2);
			}
		}

		bw.write(sum + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	private static void union(int v1, int v2) {
		v1 = find(v1);
		v2 = find(v2);
		if (v1 != v2) {
			parent[v2] = v1;
		}
	}
}
