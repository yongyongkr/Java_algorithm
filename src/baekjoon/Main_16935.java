/**
 * 백준 16935번
 * 배열 돌리기 3
 * https://www.acmicpc.net/problem/16935
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16935 {

	static int[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < r; i++) {
			int command = Integer.parseInt(st.nextToken());
			if (command == 1) {
				upsideDown();
			} else if (command == 2) {
				reverseLeftRight();
			} else if (command == 3) {
				map = turnClockwise();
			} else if (command == 4) {
				map = turnCounterClockwise();
			} else if (command == 5) {
				turnPartClockWise();
			} else if (command == 6) {
				turnPartCounterClockWise();
			}
		}

		for (int[] ints : map) {
			for (int num : ints) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	private static void upsideDown() {
		int n = map.length;
		int m = map[0].length;
		for (int col = 0; col < m; col++) {
			for (int row = 0; row < n / 2; row++) {
				int temp = map[row][col];
				map[row][col] = map[n - 1 - row][col];
				map[n - 1 - row][col] = temp;
			}
		}
	}

	private static void reverseLeftRight() {
		int n = map.length;
		int m = map[0].length;
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m / 2; col++) {
				int temp = map[row][col];
				map[row][col] = map[row][m - 1 - col];
				map[row][m - 1 - col] = temp;
			}
		}
	}

	private static int[][] turnClockwise() {
		int n = map.length;
		int m = map[0].length;
		int[][] newMap = new int[m][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				newMap[j][n - 1 - i] = map[i][j];
			}
		}
		return newMap;
	}

	private static int[][] turnCounterClockwise() {
		int n = map.length;
		int m = map[0].length;
		int[][] newMap = new int[m][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				newMap[m - 1 - j][i] = map[i][j];
			}
		}
		return newMap;
	}

	private static void turnPartClockWise() {
		int n = map.length;
		int m = map[0].length;
		int rowRange = (n + 1) / 2;
		int colRange = (m + 1) / 2;
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m / 2; j++) {
				int temp = map[i][j];
				map[i][j] = map[i + rowRange][j];
				map[i + rowRange][j] = map[i + rowRange][j + colRange];
				map[i + rowRange][j + colRange] = map[i][j + colRange];
				map[i][j + colRange] = temp;
			}
		}
	}

	private static void turnPartCounterClockWise() {
		int n = map.length;
		int m = map[0].length;
		int rowRange = (n + 1) / 2;
		int colRange = (m + 1) / 2;
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m / 2; j++) {
				int temp = map[i][j];
				map[i][j] = map[i][j + colRange];
				map[i][j + colRange] = map[i + rowRange][j + colRange];
				map[i + rowRange][j + colRange] = map[i + rowRange][j];
				map[i + rowRange][j] = temp;
			}
		}
	}
}
