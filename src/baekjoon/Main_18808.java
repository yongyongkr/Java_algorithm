/**
 * 백준 18808번
 * 스티커 붙이기
 * https://www.acmicpc.net/problem/18808
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_18808 {

	static class Sticker {
		int row;
		int col;
		private int[][] shape;

		public Sticker(int row, int col, int[][] shape) {
			this.row = row;
			this.col = col;
			this.shape = shape;
		}

		public boolean isValid(int x, int y) {
			if (x > n - row || y > m - col)
				return false;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (shape[i][j] == 1 && map[i + x][j + y] == 1)
						return false;
				}
			}
			return true;
		}

		public void turnClockwise() {
			int[][] newShape = new int[col][row];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					newShape[j][row - i - 1] = shape[i][j];
				}
			}
			int temp = row;
			row = col;
			col = temp;
			shape = newShape;
		}
	}

	static int n, m, ans;
	static int[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(map[i], 0);
		}

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int[][] given = new int[r][c];

			for (int j = 0; j < r; j++) {
				st = new StringTokenizer(br.readLine());
				for (int l = 0; l < c; l++) {
					given[j][l] = Integer.parseInt(st.nextToken());
				}
			}

			Sticker sticker = new Sticker(r, c, given);
			bfs(sticker);
		}

		System.out.println(ans);
	}

	private static void bfs(Sticker sticker) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j <= n - sticker.row; j++) {
				for (int k = 0; k <= m - sticker.col; k++) {
					if (sticker.isValid(j, k)) {
						attach(sticker, j, k);
						return;
					}
				}
			}
			if (i != 3)
				sticker.turnClockwise();
		}
	}

	private static void attach(Sticker sticker, int row, int col) {
		for (int i = 0; i < sticker.row; i++) {
			for (int j = 0; j < sticker.col; j++) {
				if (sticker.shape[i][j] == 1) {
					map[i + row][j + col] = 1;
					ans++;
				}
			}
		}
	}
}
