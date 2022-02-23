/**
 * 백준 2098
 * 외판원 순회
 * https://www.acmicpc.net/problem/2098
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2098 {

	static int n;
	static int[][] arr, dp;
	static final int INF = 17_000_000;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[n][(1 << n) - 1];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], INF);
		}

		System.out.println(travel(0, 1));
	}

	private static int travel(int from, int visited) {
		if (visited == (1 << n) - 1) {
			if (arr[from][0] == 0) {
				return INF;
			}
			return arr[from][0];
		}

		if (dp[from][visited] != INF) {
			return dp[from][visited];
		}

		for (int i = 0; i < n; i++) {
			if ((visited & (1 << i)) == 0 && arr[from][i] != 0) {
				dp[from][visited] = Math.min(dp[from][visited], travel(i, visited | (1 << i)) + arr[from][i]);
			}
		}

		return dp[from][visited];
	}
}
