/**
 * 백준 10942번
 * 팰린드롬?
 * https://www.acmicpc.net/problem/10942
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10942 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		boolean[][] dp = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			dp[i][i] = true;
		}

		for (int i = 1; i < n; i++) {
			if (arr[i - 1] == arr[i])
				dp[i - 1][i] = true;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				if (dp[j + 1][j + i - 1] && arr[j] == arr[j + i]) {
					dp[j][j + i] = true;
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;

			if (dp[start][end]) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}

		System.out.print(sb);
	}
}
