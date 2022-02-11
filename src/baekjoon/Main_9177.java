/**
 * 백준 9177번
 * 단어 섞기
 * https://www.acmicpc.net/problem/9177
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9177 {

	static String first, second, third;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= n; tc++) {
			st = new StringTokenizer(br.readLine());
			first = st.nextToken();
			second = st.nextToken();
			third = st.nextToken();

			visited = new boolean[201][201];
			sb.append("Data set ").append(tc).append(": ");
			sb.append(func(0, 0, 0) ? "yes\n" : "no\n");
		}
		System.out.print(sb);
	}

	private static boolean func(int i, int j, int cnt) {
		if (cnt == third.length())
			return true;
		if (visited[i][j])
			return false;
		visited[i][j] = true;

		boolean flag = false;
		if (i < first.length() && first.charAt(i) == third.charAt(cnt))
			flag |= func(i + 1, j, cnt + 1);
		if (j < second.length() && second.charAt(j) == third.charAt(cnt))
			flag |= func(i, j + 1, cnt + 1);

		return flag;
	}
}
