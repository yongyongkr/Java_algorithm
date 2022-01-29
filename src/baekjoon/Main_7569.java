/**
 * 백준 7569번
 * 토마토
 * https://www.acmicpc.net/problem/7569
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569 {

	static int n, m, h;
	static int[][][] arr, dist;
	static int[] dx = {1, 0, 0, 0, 0, -1};
	static int[] dy = {0, 1, 0, 0, -1, 0};
	static int[] dz = {0, 0, 1, -1, 0, 0};

	static class Point {
		int x;
		int y;
		int z;

		public Point(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		arr = new int[n][m][h];
		dist = new int[n][m][h];

		Queue<Point> wellTomatoes = new LinkedList<>();

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < n; k++) {
					arr[k][j][i] = Integer.parseInt(st.nextToken());
					if (arr[k][j][i] == 1) {
						wellTomatoes.offer(new Point(k, j, i));
					}
				}
			}
		}

		bfs(wellTomatoes);

		int max = 0;
		Outer:
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < h; k++) {
					if (arr[i][j][k] == 0 && dist[i][j][k] == 0) {
						max = -1;
						break Outer;
					}
					max = Math.max(max, dist[i][j][k]);
				}
			}
		}

		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
		br.close();
	}

	private static void bfs(Queue<Point> queue) {
		while (!queue.isEmpty()) {
			Point tomato = queue.poll();
			for (int i = 0; i < 6; i++) {
				int nx = tomato.x + dx[i];
				int ny = tomato.y + dy[i];
				int nz = tomato.z + dz[i];

				if (0 <= nx && nx < n && 0 <= ny && ny < m && 0 <= nz && nz < h && arr[nx][ny][nz] == 0
					&& dist[nx][ny][nz] == 0) {
					queue.offer(new Point(nx, ny, nz));
					dist[nx][ny][nz] = dist[tomato.x][tomato.y][tomato.z] + 1;
				}
			}
		}
	}
}
