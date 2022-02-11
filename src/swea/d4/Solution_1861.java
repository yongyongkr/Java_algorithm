/**
 * SWEA 1861번
 * 정사각형 방
 */

package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1861 {

	static int[][] map;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int n, room, cnt;

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
		StringTokenizer st;
		int testcase = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testcase; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			room = Integer.MAX_VALUE;
			cnt = 1;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					bfs(i, j);
				}
			}

			System.out.printf("#%d %d %d\n", tc, room, cnt);
		}
	}

	private static void bfs(int i, int j) {
		int curRoom = map[i][j];
		int count = 0;
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(i, j));
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				Point cur = q.poll();
				for (int k = 0; k < 4; k++) {
					int nx = cur.x + dx[k];
					int ny = cur.y + dy[k];

					if (nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] != map[cur.x][cur.y] + 1)
						continue;

					q.offer(new Point(nx, ny));
				}
			}
			count++;
		}
		if (cnt < count) {
			cnt = count;
			room = curRoom;
		} else if (cnt == count) {
			room = Math.min(room, curRoom);
		}
	}
}
