/**
 * 백준 16768번
 * Mooyo Mooyo
 * https://www.acmicpc.net/problem/16768
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16768 {

	static int n, k;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1, 0, 0, -1};
	static int[] dy = {0, 1, -1, 0};

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][10];

		for (int i = 0; i < map.length; i++) {
			String line = br.readLine();
			for (int j = 0; j < line.length(); j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		boolean changed = true;
		while (changed) {
			changed = false;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					if (map[i][j] == 0)
						continue;
					if (moreThanK(i, j)) {
						changed = true;
						remove(i, j);
					}
				}
			}
			down();
		}

		for (int[] ints : map) {
			for (int j = 0; j < map[0].length; j++) {
				sb.append(ints[j]);
			}
			sb.append("\n");
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
	}

	private static void down() {
		for (int col = 0; col < map[0].length; col++) {
			for (int row = map.length - 1; row >= 0; row--) {
				if (map[row][col] != 0) {
					int nr = row;
					while (nr + 1 < map.length && map[nr + 1][col] == 0) {
						nr++;
					}
					if (nr != row) {
						map[nr][col] = map[row][col];
						map[row][col] = 0;
					}
				}
			}
		}
	}

	private static void remove(int x, int y) {
		visited = new boolean[n][10];
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y));
		visited[x][y] = true;
		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < dx.length; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (notIn(nx, ny) || map[nx][ny] != map[x][y] || visited[nx][ny])
					continue;

				map[nx][ny] = 0;
				visited[nx][ny] = true;
				q.offer(new Point(nx, ny));
			}
		}
		map[x][y] = 0;
	}

	private static boolean moreThanK(int x, int y) {
		visited = new boolean[n][10];
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y));
		visited[x][y] = true;
		int cnt = 1;

		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < dx.length; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (notIn(nx, ny) || visited[nx][ny] || map[nx][ny] != map[x][y])
					continue;

				visited[nx][ny] = true;
				q.offer(new Point(nx, ny));
				if (++cnt >= k) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean notIn(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= n || ny >= 10;
	}
}
