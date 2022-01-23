/**
 * 백준 5582번
 * 공통 부분 문자열
 * https://www.acmicpc.net/problem/5582
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_5582 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String first = br.readLine();
		String second = br.readLine();
		int[][] dp = new int[first.length() + 1][second.length() + 1];
		int answer = 0;

		for (int i = 1; i <= first.length(); i++) {
			for (int j = 1; j <= second.length(); j++) {
				if (first.charAt(i - 1) == second.charAt(j - 1)) {
					dp[i][j] += dp[i - 1][j - 1] + 1;
					answer = Math.max(dp[i][j], answer);
				}
			}
		}
		bw.write(answer + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
