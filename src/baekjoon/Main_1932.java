/**
 * 백준 1932번
 * 정수 삼각형
 * https://www.acmicpc.net/problem/1932
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main_1932 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < n - 1; i++) {
            dp[i + 1][0] += dp[i][0];
            for (int j = 0; j < i; j++) {
                dp[i + 1][j + 1] += Math.max(dp[i][j], dp[i][j + 1]);
            }
            dp[i + 1][i + 1] += dp[i][i];
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (dp[n - 1][i] > max) {
                max = dp[n - 1][i];
            }
        }

        System.out.println(max);
    }
}
