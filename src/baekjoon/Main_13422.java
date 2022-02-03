/**
 * 백준 13422번
 * 도둑
 * https://www.acmicpc.net/problem/13422
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13422 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int[] house = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				house[i] = Integer.parseInt(st.nextToken());
			}

			int sum = 0;
			int answer = 0;
			for (int i = 0; i < m - 1; i++) {
				sum += house[i];
			}

			if (n == m) {
				if (sum + house[m - 1] < k) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				continue;
			}

			for (int i = 0; i < n; i++) {
				sum += house[(i + m - 1) % n];
				if (sum < k) {
					answer += 1;
				}
				sum -= house[i];
			}

			System.out.println(answer);
		}
	}
}
