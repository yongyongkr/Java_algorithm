/**
 * 백준 17136번
 * 색종이 붙이기
 * https://www.acmicpc.net/problem/17136
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17136 {

	static int ans;
	static int[][] map;
	static int[] paper = {0, 5, 5, 5, 5, 5};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[10][10];

		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = Integer.MAX_VALUE;

		dfs(0, 0, 0);

		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}

	private static void dfs(int x, int y, int cnt) {
		if (x >= 9 && y > 9) {
			ans = Math.min(ans, cnt);
			return;
		}

		if (ans <= cnt) {
			return;
		}

		if (y > 9) {
			dfs(x + 1, 0, cnt);
			return;
		}

		if (map[x][y] == 1) {
			for (int i = 5; i >= 1; i--) {
				if (paper[i] > 0 && isValid(x, y, i)) {
					attach(x, y, i, 0);
					paper[i]--;
					dfs(x, y + 1, cnt + 1);
					attach(x, y, i, 1);
					paper[i]++;
				}
			}
		} else {
			dfs(x, y + 1, cnt);
		}
	}

	private static void attach(int x, int y, int len, int state) {
		for (int row = x; row < x + len; row++) {
			for (int col = y; col < y + len; col++) {
				map[row][col] = state;
			}
		}
	}

	private static boolean isValid(int x, int y, int len) {
		for (int row = x; row < x + len; row++) {
			for (int col = y; col < y + len; col++) {
				if (row < 0 || row >= 10 || col < 0 || col >= 10 || map[row][col] != 1)
					return false;
			}
		}
		return true;
	}
}
