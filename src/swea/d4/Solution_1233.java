/**
 * SWEA 1233번
 * 사칙연산 유효성 검사
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV141176AIwCFAYD
 */

package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1233 {

	static int n;
	static char[] bt;
	static final List<Character> operators = Arrays.asList('+', '-', '*', '/');

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String line = "";
		int tc = 0;
		while ((line = br.readLine()) != null && !line.equals("")) {
			tc++;
			n = Integer.parseInt(line);
			bt = new char[n + 1];
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				bt[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
			}

			int ans = dfs(1);
			System.out.printf("#%d %d\n", tc, ans);
		}
	}

	private static int dfs(int current) {
		if (current > n) return 1;
		if ('0' <= bt[current] && bt[current] <= '9' && current * 2 <= n
			|| operators.contains(bt[current]) && current * 2 + 1 > n) {
			return 0;
		}

		return dfs(current * 2) * dfs(current * 2 + 1);
	}
}
