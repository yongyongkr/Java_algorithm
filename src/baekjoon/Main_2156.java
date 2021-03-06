/**
 * 백준 2156번
 * 포도주 시식
 * https://www.acmicpc.net/problem/2156
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main_2156 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] wine = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(wine[0]);
        } else if (n == 2) {
            System.out.println(wine[0] + wine[1]);
        } else {
            dp[0] = wine[0];
            dp[1] = dp[0] + wine[1];
            dp[2] = dp[1] + wine[2];
            if (wine[0] <= wine[1] && wine[0] <= wine[2]) {
                dp[2] -= wine[0];
            } else if (wine[1] <= wine[0] && wine[1] <= wine[2]) {
                dp[2] -= wine[1];
            } else {
                dp[2] -= wine[2];
            }

            for (int i = 3; i < n; i++) {
                int notSelectLeft = dp[i - 2] + wine[i];
                int selectLeft = dp[i - 3] + wine[i - 1] + wine[i];
                dp[i] = Math.max(selectLeft, notSelectLeft);
                if (dp[i] < dp[i - 1]) {
                    dp[i] = dp[i - 1];
                }
            }
            System.out.println(dp[n - 1]);
        }
    }
}
