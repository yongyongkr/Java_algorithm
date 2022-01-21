/**
 * 백준 1520번
 * 내리막 길
 * https://www.acmicpc.net/problem/1520
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1520 {

	static int n, m;
	static int[][] map, dp;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n + 1][m + 1];
		dp = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}

		System.out.println(dfs(1, 1));
	}

	private static int dfs(int x, int y) {
		if (x == n && y == m) {
			return 1;
		}
		if (dp[x][y] != -1) {
			return dp[x][y];
		} else {
			dp[x][y] = 0;
			for (int i = 0; i < dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 1 || ny < 1 || nx > n || ny > m) {
					continue;
				}

				if (map[x][y] > map[nx][ny]) {
					dp[x][y] += dfs(nx, ny);
				}
			}
		}
		return dp[x][y];
	}
}
