/**
 * 백준 5502번
 * 팰린드롬
 * https://www.acmicpc.net/problem/5502
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5502 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String str1 = br.readLine();
		String str2 = new StringBuilder(str1).reverse().toString();

		int[][] dp = new int[n + 1][n + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (str1.charAt(i) == str2.charAt(j)) {
					dp[i + 1][j + 1] = dp[i][j] + 1;
				} else {
					dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
				}
			}
		}

		System.out.println(n - dp[n][n]);
	}
}
