/**
 * 백준 3109
 * 빵집
 * https://www.acmicpc.net/problem/3109
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109 {

	static int r, c, ans;
	static boolean flag;
	static char[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		ans = 0;

		map = new char[r][c];
		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}

		visited = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			if (map[i][0] == '.') {
				flag = false;
				dfs(i, 0);
			}
		}

		System.out.println(ans);
	}

	private static void dfs(int row, int col) {
		if (row < 0 || row >= r || visited[row][col] || map[row][col] == 'x')
			return;
		if (col == c - 1) {
			visited[row][col] = true;
			flag = true;
			ans++;
			return;
		}
		visited[row][col] = true;
		if (flag)
			return;
		dfs(row - 1, col + 1);
		if (flag)
			return;
		dfs(row, col + 1);
		if (flag)
			return;
		dfs(row + 1, col + 1);
	}
}
