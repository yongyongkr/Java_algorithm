/**
 * 백준 11054번
 * 가장 긴 바이토닉 부분 수열
 * https://www.acmicpc.net/problem/11054
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11054 {

	static int[] arr, dp1, dp2;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp1 = new int[n];
		dp2 = new int[n];

		for (int i = 0; i < n; i++) {
			LIS(i);
			LDS(i);
		}

		int max = -1;
		for (int i = 0; i < n; i++) {
			max = Math.max(dp1[i] + dp2[i], max);
		}
		System.out.println(max - 1);
	}

	private static int LIS(int n) {
		if (dp1[n] == 0) {
			dp1[n] = 1;

			for (int i = n - 1; i >= 0; i--) {
				if (arr[i] < arr[n]) {
					dp1[n] = Math.max(dp1[n], LIS(i) + 1);
				}
			}
		}
		return dp1[n];
	}

	private static int LDS(int n) {
		if (dp2[n] == 0) {
			dp2[n] = 1;

			for (int i = n + 1; i < dp2.length; i++) {
				if (arr[i] < arr[n]) {
					dp2[n] = Math.max(dp2[n], LDS(i) + 1);
				}
			}
		}
		return dp2[n];
	}
}
