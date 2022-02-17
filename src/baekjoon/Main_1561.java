/**
 * 백준 1561번
 * 놀이 공원
 * https://www.acmicpc.net/problem/1561
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1561 {

	static long n;
	static int m;
	static int[] time;
	static int max;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Long.parseLong(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		time = new int[m + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= m; i++) {
			time[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, time[i]);
		}

		if (n <= m) {
			System.out.println(n);
			return;
		}

		long t = binarySearch(0, (n / m) * max);
		long cnt = m;
		for (int i = 1; i <= m; i++) {
			cnt += (t - 1) / time[i];
		}

		for (int i = 1; i <= m; i++) {
			if (t % time[i] == 0) {
				cnt++;
			}
			if (cnt == n) {
				System.out.println(i);
				return;
			}
		}
	}

	private static long binarySearch(long left, long right) {
		while (left <= right) {
			long mid = (left + right) / 2;
			long sum = m;
			for (int i = 1; i <= m; i++) {
				sum += mid / time[i];
			}

			if (sum < n) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}
}
