/**
 * 백준 2589번
 * 보물섬
 * https://www.acmicpc.net/problem/2589
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

public class Main_2589 {

	static int row, col, max;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

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
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new char[row][col];

		for (int i = 0; i < row; i++) {
			map[i] = br.readLine().toCharArray();
		}

		max = 0;
		bfs();
		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
		br.close();
	}

	private static void bfs() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (map[i][j] == 'W')
					continue;
				visited = new boolean[row][col];
				Queue<Point> q = new LinkedList<>();
				q.offer(new Point(i, j));
				visited[i][j] = true;
				int count = 0;

				while (!q.isEmpty()) {
					int size = q.size();
					while(size-- > 0) {
						Point cur = q.poll();
						for (int k = 0; k < dx.length; k++) {
							int nx = cur.x + dx[k];
							int ny = cur.y + dy[k];

							if (nx < 0 || ny < 0 || nx >= row || ny >= col || visited[nx][ny] || map[nx][ny] == 'W')
								continue;

							q.offer(new Point(nx, ny));
							visited[nx][ny] = true;
						}
					}
					count++;
				}
				max = Math.max(count - 1, max);
			}
		}
	}
}
