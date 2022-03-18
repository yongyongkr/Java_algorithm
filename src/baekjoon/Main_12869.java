/**
 * 백준 12869번
 * 뮤탈리스크
 * https://www.acmicpc.net/problem/12869
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12869 {

	static int n, result;
	static int[][][] dp;
	static int[] arrA = {9, 9, 3, 3, 1, 1};
	static int[] arrB = {3, 1, 9, 1, 9, 3};
	static int[] arrC = {1, 3, 1, 9, 3, 9};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[3];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[61][61][61];
		result = Integer.MAX_VALUE;

		dfs(arr, 0);
		System.out.println(result);
	}

	private static void dfs(int[] arr, int cnt) {
		int a = arr[0];
		int b = arr[1];
		int c = arr[2];

		if (dp[a][b][c] <= cnt && dp[a][b][c] != 0) {
			return;
		}

		if (a == 0 && b == 0 && c == 0) {
			result = Math.min(result, cnt);
			return;
		}

		dp[a][b][c] = cnt;

		int nA, nB, nC;
		for (int i = 0; i < 6; i++) {
			nA = a - arrA[i];
			nB = b - arrB[i];
			nC = c - arrC[i];
			if (nA < 0) nA = 0;
			if (nB < 0) nB = 0;
			if (nC < 0) nC = 0;
			dfs(new int[] {nA, nB, nC}, cnt + 1);
		}
	}
}
