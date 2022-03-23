/**
 * 백준 14500번
 * 테트로미노
 * https://www.acmicpc.net/problem/14500
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500 {

	static int n, m;
	static int max = Integer.MIN_VALUE;
	static int dx[] = {0, 0, 1, -1}, dy[] = {1, -1, 0, 0};
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		visited = new boolean[n][m];
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = true;
				dfs(i, j, map[i][j], 1);
				visited[i][j] = false;
				checkLastPiece(i, j);
			}
		}

		System.out.println(max);
	}

	private static void checkLastPiece(int row, int col) {
		int wing = 4;
		int min = Integer.MAX_VALUE;
		int sum = map[row][col];
		for (int i = 0; i < 4; i++) {
			int nx = row + dx[i];
			int ny = col + dy[i];
			if (wing <= 2)
				return;
			if (notIn(nx, ny)) {
				wing--;
				continue;
			}
			min = Math.min(min, map[nx][ny]);
			sum += map[nx][ny];
		}
		if (wing == 4) {
			sum -= min;
		}
		max = Math.max(max, sum);
	}

	private static void dfs(int row, int col, int sum, int depth) {
		if (depth == 4) {
			max = Math.max(sum, max);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nx = row + dx[i];
			int ny = col + dy[i];
			if (notIn(nx, ny))
				continue;
			if (visited[nx][ny])
				continue;
			visited[nx][ny] = true;
			dfs(nx, ny, sum + map[nx][ny], depth + 1);
			visited[nx][ny] = false;
		}
	}

	private static boolean notIn(int row, int col) {
		return row < 0 || col < 0 || row >= n || col >= m;
	}
}
