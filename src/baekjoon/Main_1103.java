/**
 * 백준 1103번
 * 게임
 * https://www.acmicpc.net/problem/1103
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1103 {

	static int max, r, c;
	static boolean flag;
	static boolean[][] visited;
	static int[][] map, dp;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		dp = new int[r][c];

		for (int i = 0; i < r; i++) {
			String line = br.readLine();
			for (int j = 0; j < c; j++) {
				if (line.charAt(j) == 'H') {
					map[i][j] = 10;
				} else {
					map[i][j] = line.charAt(j) - '0';
				}
			}
		}

		visited = new boolean[r][c];
		visited[0][0] = true;
		dfs(0, 0, 1);

		if (flag) {
			System.out.println(-1);
		} else {
			System.out.println(max);
		}
	}

	private static void dfs(int x, int y, int depth) {
		if (depth > max) {
			max = depth;
		}
		dp[x][y] = depth;
		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i] * map[x][y];
			int ny = y + dy[i] * map[x][y];
			if (nx < 0 || ny < 0 || nx >= r || ny >= c || map[nx][ny] == 10) {
				continue;
			}
			if (visited[nx][ny]) {
				flag = true;
				return;
			}
			if (dp[nx][ny] > depth)
				continue;
			visited[nx][ny] = true;
			dfs(nx, ny, depth + 1);
			visited[nx][ny] = false;
		}
	}
}
