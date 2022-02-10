/**
 * 백준 2563번
 * 색종이
 * https://www.acmicpc.net/problem/2563
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		int[][] whitePaper = new int[102][102];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken()) + 1;
			int col = Integer.parseInt(st.nextToken()) + 1;

			whitePaper[row][col] += 1;
			whitePaper[row + 10][col] -= 1;
			whitePaper[row][col + 10] -= 1;
			whitePaper[row + 10][col + 10] += 1;
		}

		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				whitePaper[i][j] += whitePaper[i][j - 1];
				whitePaper[i][j] += whitePaper[i - 1][j];
				whitePaper[i][j] -= whitePaper[i - 1][j - 1];
			}
		}

		int duplicateArea = 0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if (whitePaper[i][j] >= 2) {
					duplicateArea += whitePaper[i][j] - 1;
				}
			}
		}

		System.out.println(100 * n - duplicateArea);
	}
}
