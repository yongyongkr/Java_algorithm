/**
 * 백준 13164번
 * 행복 유치원
 * https://www.acmicpc.net/problem/13164
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main_13164 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] children = new int[n];
        for (int i = 0; i < n; i++) {
            children[i] = Integer.parseInt(st.nextToken());
        }

        int[] diff = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diff[i] = children[i + 1] - children[i];
        }

        Arrays.sort(diff);

        int cost = 0;
        for (int i = 0; i < n - k; i++) {
            cost += diff[i];
        }

        System.out.println(cost);
    }
}
