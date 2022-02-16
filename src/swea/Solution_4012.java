/**
 * SWEA 4012번
 * 요리사
 */

package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4012 {

	static int n, min;
	static int[] temp;
	static int[][] synergy;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testcase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testcase; tc++) {

			n = Integer.parseInt(br.readLine());
			synergy = new int[n + 1][n + 1];
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			min = Integer.MAX_VALUE;
			temp = new int[n + 1];
			solve(1, 0);

			System.out.printf("#%d %d\n", tc, min);
		}
	}

	private static void solve(int start, int cnt) {
		if (start == n + 1)
			return;
		if (cnt == n / 2) {
			int diff = Math.abs(getSum(0) - getSum(1));
			min = Math.min(diff, min);
			return;
		}
		temp[start] = 1;
		solve(start + 1, cnt + 1);
		temp[start] = 0;
		solve(start + 1, cnt);
	}

	private static int getSum(int val) {
		int sum = 0;
		for (int i = 1; i < temp.length; i++) {
			if (temp[i] != val)
				continue;
			for (int j = i + 1; j < temp.length; j++) {
				if (temp[j] != val)
					continue;
				sum += synergy[i][j] + synergy[j][i];
			}
		}
		return sum;
	}
}
