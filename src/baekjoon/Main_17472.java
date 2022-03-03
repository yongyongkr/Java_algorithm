/**
 * 백준 17472번
 * 다리 만들기 2
 * https://www.acmicpc.net/problem/17472
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17472 {

	static class Node implements Comparable<Node> {
		int from;
		int to;
		int cost;

		public Node(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node node) {
			return Integer.compare(this.cost, node.cost);
		}
	}

	static class Land {
		int num;
		List<Point> points = new ArrayList<>();

		public Land(int num) {
			this.num = num;
		}

		public void addPoint(Point point) {
			this.points.add(point);
		}

		public boolean find(Point point) {
			for (Point p : points) {
				if (p.x == point.x && p.y == point.y)
					return true;
			}
			return false;
		}
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n, m, result;
	static int[][] map, distance;
	static int[] parent;
	static boolean[][] visited;
	static List<Land> lands;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		lands = new ArrayList<>();

		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0 || visited[i][j])
					continue;
				bfs(i, j);
			}
		}

		distance = new int[lands.size()][lands.size()];
		for (int[] ints : distance) {
			Arrays.fill(ints, Integer.MAX_VALUE);
		}

		for (int i = 0; i < lands.size(); i++) {
			for (Point point : lands.get(i).points) {
				for (int j = 0; j < 4; j++) {
					buildBridge(point, i, 0, j);
				}
			}
		}

		parent = new int[lands.size()];
		Queue<Node> pq = new PriorityQueue<>();
		result = 0;

		for (int i = 0; i < lands.size(); i++) {
			parent[i] = i;
		}

		for (int i = 0; i < lands.size(); i++) {
			for (int j = i + 1; j < lands.size(); j++) {
				pq.offer(new Node(i, j, distance[i][j]));
			}
		}

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			if (node.cost == Integer.MAX_VALUE)
				continue;
			int start = node.from;
			int end = node.to;
			union(start, end, node.cost);
		}

		for (int i = 0; i < parent.length; i++) {
			find(i);
		}

		boolean flag = false;
		int root = parent[0];
		for (int i = 1; i < parent.length; i++) {
			if (root != parent[i]) {
				flag = true;
				break;
			}
		}

		if (flag) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}

	private static void union(int x, int y, int cost) {
		x = find(x);
		y = find(y);
		if (x != y) {
			parent[x] = y;
			result += cost;
		}
	}

	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	private static void buildBridge(Point cur, int from, int dist, int dir) {
		cur.x += dx[dir];
		cur.y += dy[dir];
		if (isNotIn(cur.x, cur.y))
			return;
		if (map[cur.x][cur.y] == 1) {
			if (dist == 0 || dist == 1)
				return;
			for (int i = 0; i < lands.size(); i++) {
				if (lands.get(i).find(cur)) {
					distance[from][i] = Math.min(distance[from][i], dist);
					distance[i][from] = distance[from][i];
				}
			}
			return;
		}
		buildBridge(cur, from, dist + 1, dir);
	}

	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		Point start = new Point(x, y);
		q.offer(start);
		visited[x][y] = true;

		int landIdx = lands.size();
		Land land = new Land(landIdx);
		land.addPoint(start);
		lands.add(land);

		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (isNotIn(nx, ny) || visited[nx][ny] || map[nx][ny] == 0)
					continue;

				Point next = new Point(nx, ny);
				q.offer(next);
				visited[nx][ny] = true;

				land.addPoint(next);
			}
		}
	}

	private static boolean isNotIn(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= n || ny >= m;
	}
}
