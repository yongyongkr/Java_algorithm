/**
 * 백준 2573번
 * 빙산
 * https://www.acmicpc.net/problem/2573
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

public class Main_2573 {

	static int row, col;
	static int[][] map;
	static boolean[][] visited;
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};

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
		map = new int[row][col];

		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = 0;
		int pieces = checkPieces();
		while (pieces < 2) {
			if (pieces == 0) {
				result = 0;
				break;
			}
			melt();
			result += 1;
			pieces = checkPieces();
		}

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		br.close();
	}

	private static int checkPieces() {
		int cnt = 0;
		visited = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (map[i][j] == 0 || visited[i][j])
					continue;
				dfs(i, j);
				cnt += 1;
			}
		}
		return cnt;
	}

	private static void dfs(int x, int y) {
		visited[x][y] = true;

		for (int k = 0; k < dx.length; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if (nx < 0 || ny < 0 || nx >= row || ny >= col || visited[nx][ny] || map[nx][ny] == 0)
				continue;
			dfs(nx, ny);
		}
	}

	private static void melt() {
		Queue<Point> q = new LinkedList<>();
		boolean[][] wasLand = new boolean[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (map[i][j] != 0) {
					q.offer(new Point(i, j));
					wasLand[i][j] = true;
				}
			}
		}

		while (!q.isEmpty()) {
			Point cur = q.poll();
			int cnt = 0;
			for (int i = 0; i < dx.length; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (wasLand[nx][ny] || map[nx][ny] != 0)
					continue;
				cnt += 1;
			}
			map[cur.x][cur.y] -= cnt;
			if (map[cur.x][cur.y] < 0) {
				map[cur.x][cur.y] = 0;
			}
		}
	}
}
