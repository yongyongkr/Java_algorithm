/**
 * 백준 1992번
 * 쿼드 트리
 * https://www.acmicpc.net/problem/1992
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1992 {

	static int n;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = line.charAt(j) - '0';
			}
		}

		divideAndConquer(0, 0, n);
		System.out.println(sb);
	}

	private static void divideAndConquer(int r, int c, int len) {
		int sum = getSum(r, c, len);
		if (sum == len * len) {
			sb.append(1);
			return;
		} else if (sum == 0) {
			sb.append(0);
			return;
		}
		if (len == 2) {
			sb.append("(");
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					sb.append(arr[r + i][c + j]);
				}
			}
			sb.append(")");
			return;
		}

		sb.append("(");
		divideAndConquer(r, c, len / 2);
		divideAndConquer(r, c + len / 2, len / 2);
		divideAndConquer(r + len / 2, c, len / 2);
		divideAndConquer(r + len / 2, c + len / 2, len / 2);
		sb.append(")");
	}

	private static int getSum(int r, int c, int len) {
		int sum = 0;
		for (int i = r; i < r + len; i++) {
			for (int j = c; j < c + len; j++) {
				sum += arr[i][j];
			}
		}
		return sum;
	}
}
