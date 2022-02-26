/**
 * 백준 1300번
 * K번째 수
 * https://www.acmicpc.net/problem/1300
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1300 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		int left = 1;
		int right = k;

		while (left < right) {
			int mid = (left + right) / 2;
			int cnt = 0;

			for (int i = 1; i <= n; i++) {
				cnt += Math.min(mid / i, n);
			}

			if (cnt >= k) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		System.out.println(left);
	}
}
