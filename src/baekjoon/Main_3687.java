/**
 * 백준 3687번
 * 성냥개비
 * https://www.acmicpc.net/problem/3687
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_3687 {

	static long[] dp = new long[101];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		Arrays.fill(dp, Long.MAX_VALUE);
		setMin();

		while (tc-- > 0) {
			int n = Integer.parseInt(br.readLine());

			String max = getMax(n);
			long min = dp[n];

			sb.append(min).append(" ").append(max).append("\n");
		}
		System.out.print(sb);
	}

	private static String getMax(int n) {
		StringBuilder sb = new StringBuilder();

		if (n % 2 == 0) {
			sb.append(1);
		} else {
			sb.append(7);
		}

		for (int i = 0; i < n / 2 - 1; i++) {
			sb.append(1);
		}

		return sb.toString();
	}

	private static void setMin() {
		dp[2] = 1;
		dp[3] = 7;
		dp[4] = 4;
		dp[5] = 2;
		dp[6] = 6;
		dp[7] = 8;
		dp[8] = 10;
		String[] add = {"1", "7", "4", "2", "0", "8"};

		for (int i = 9; i <= 100; i++) {
			for (int j = 2; j <= 7; j++) {
				String curr = dp[i - j] + add[j - 2];
				dp[i] = Math.min(dp[i], Long.parseLong(curr));
			}
		}
	}
}
