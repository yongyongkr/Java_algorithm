/**
 * 백준 10026번
 * 적록색약
 * https://www.acmicpc.net/problem/10026
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_10026 {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n;
	static boolean[][] visited;
	static char[][] map;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		StringBuilder sb = new StringBuilder();
		visited = new boolean[n][n];
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		sb.append(cnt).append(" ");

		visited = new boolean[n][n];
		cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					bfs2(i, j);
					cnt++;
				}
			}
		}
		sb.append(cnt);

		System.out.println(sb);
	}

	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y));
		visited[x][y] = true;
		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] || map[x][y] != map[nx][ny])
					continue;
				visited[nx][ny] = true;
				q.offer(new Point(nx, ny));
			}
		}
	}

	private static void bfs2(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y));
		visited[x][y] = true;
		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny])
					continue;
				if (map[x][y] == map[nx][ny] || map[x][y] == 'R' && map[nx][ny] == 'G' || map[x][y] == 'G' && map[nx][ny] == 'R') {
					visited[nx][ny] = true;
					q.offer(new Point(nx, ny));
				}
			}
		}
	}
}
