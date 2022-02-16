/**
 * 백준 2839번
 * 설탕 배달
 * https://www.acmicpc.net/problem/2839
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2839 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[5001];
		Arrays.fill(dp, Integer.MAX_VALUE);

		for (int i = 0; i < 5001; i++) {
			if (i % 5 == 0) {
				dp[i] = i / 5;
			} else if (i % 3 == 0) {
				dp[i] = i / 3;
			}
		}

		for (int i = 1; i < 2500; i++) {
			if (dp[i] == Integer.MAX_VALUE) continue;
			for (int j = i + 1; j < 5000 && i + j < 5001; j++) {
				if (dp[j] == Integer.MAX_VALUE) continue;
				dp[i + j] = Math.min(dp[i + j], dp[i] + dp[j]);
			}
		}

		if (dp[n] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(dp[n]);
		}
	}
}
