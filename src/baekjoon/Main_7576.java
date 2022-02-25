/**
 * 백준 7576번
 * 토마토
 * https://www.acmicpc.net/problem/7576
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576 {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n, m, cnt, blank, ans;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static Queue<Point> lastModified = new LinkedList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					lastModified.offer(new Point(i, j));
				} else if (map[i][j] == -1) {
					blank++;
				}
			}
		}

		while (!lastModified.isEmpty()) {
			ans++;
			bfs();
		}

		if (cnt == n * m - blank) {
			System.out.println(ans - 1);
		} else {
			System.out.println(-1);
		}
	}

	private static void bfs() {
		int size = lastModified.size();
		cnt += size;
		while (size-- > 0) {
			Point cur = lastModified.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (isIn(nx, ny) && map[nx][ny] == 0) {
					lastModified.offer(new Point(nx, ny));
					map[nx][ny] = 1;
				}
			}
		}
	}

	private static boolean isIn(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < n && ny < m;
	}
}
