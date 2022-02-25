/**
 * 백준 17144번
 * 미세먼지 안녕!
 * https://www.acmicpc.net/problem/17144
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17144 {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int r, c;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static Point upperCleaner;
	static Point lowerCleaner;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		map = new int[r][c];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					if (upperCleaner == null) {
						upperCleaner = new Point(i, j);
					} else {
						lowerCleaner = new Point(i, j);
					}
				}
			}
		}

		while (t-- > 0) {
			diffusion();
			cycle();
		}

		System.out.println(getSum());
	}

	private static int getSum() {
		int sum = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == -1)
					continue;
				sum += map[i][j];
			}
		}
		return sum;
	}

	private static void diffusion() {
		int[][] temp = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == 0 || map[i][j] == -1)
					continue;
				int cnt = 0;
				int part = map[i][j] / 5;
				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if (nx < 0 || ny < 0 || nx >= r || ny >= c || map[nx][ny] == -1)
						continue;
					cnt++;
					temp[nx][ny] += part;
				}
				temp[i][j] += map[i][j] - part * cnt;
			}
		}
		map = temp;
	}

	private static void cycle() {
		upperCycle();
		lowerCycle();
	}

	private static void upperCycle() {
		int x = upperCleaner.x;
		int y = upperCleaner.y;
		for (int row = x - 1; row >= 0; row--) {
			map[row + 1][y] = map[row][y];
		}
		for (int col = 1; col < c; col++) {
			map[0][col - 1] = map[0][col];
		}
		for (int row = 0; row < x; row++) {
			map[row][c - 1] = map[row + 1][c - 1];
		}
		for (int col = c - 2; col >= 0; col--) {
			map[x][col + 1] = map[x][col];
		}
		map[x][y] = -1;
		map[x][y + 1] = 0;
	}

	private static void lowerCycle() {
		int x = lowerCleaner.x;
		int y = lowerCleaner.y;
		for (int row = x + 1; row < r; row++) {
			map[row - 1][y] = map[row][y];
		}
		for (int col = 1; col < c; col++) {
			map[r - 1][col - 1] = map[r - 1][col];
		}
		for (int row = r - 2; row >= x; row--) {
			map[row + 1][c - 1] = map[row][c - 1];
		}
		for (int col = c - 2; col >= 0; col--) {
			map[x][col + 1] = map[x][col];
		}
		map[x][y] = -1;
		map[x][y + 1] = 0;
	}
}
