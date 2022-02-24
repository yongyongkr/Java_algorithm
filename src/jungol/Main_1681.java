/**
 * 정올 1681번
 * 해밀턴 순환회로
 */

package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1681 {

	static int n;
	static int[][] arr, dp;
	static final int INF = 100_000_000;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[n][(1 << n) - 1];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], INF);
		}

		System.out.println(dfs(0, 1));
	}

	private static int dfs(int start, int visited) {
		if (visited == (1 << n) - 1) {
			if (arr[start][0] == 0) {
				return INF;
			}
			return arr[start][0];
		}

		if (dp[start][visited] != INF)
			return dp[start][visited];

		for (int i = 0; i < n; i++) {
			if ((visited & (1 << i)) == 0 && arr[start][i] != 0) {
				dp[start][visited] = Math.min(dp[start][visited], dfs(i, visited | (1 << i)) + arr[start][i]);
			}
		}
		return dp[start][visited];
	}
}
