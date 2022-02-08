package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2616 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int part = Integer.parseInt(br.readLine());
		int[] guests = new int[part + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= part; i++) {
			guests[i] = Integer.parseInt(st.nextToken());
		}

		int limit = Integer.parseInt(br.readLine());

		for (int i = 1; i <= part; i++) {
			guests[i] += guests[i - 1];
		}

		int[][] dp = new int[4][50001];

		for (int i = 1; i <= 3; i++) {
			for (int j = i * limit; j <= part; j++) {
				dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - limit] + guests[j] - guests[j - limit]);
			}
		}
		System.out.println(dp[3][part]);
	}
}
