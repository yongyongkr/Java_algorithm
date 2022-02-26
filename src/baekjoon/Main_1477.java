/**
 * 백준 1477번
 * 휴게소 세우기
 * https://www.acmicpc.net/problem/1477
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1477 {

	static int n, m, l;
	static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		arr = new int[n + 2];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		arr[0] = 0;
		arr[n + 1] = l;
		Arrays.sort(arr);

		System.out.println(binarySearch());
	}

	private static int binarySearch() {
		int left = 1;
		int right = l;

		while (left <= right) {
			int mid = (left + right) / 2;
			int sum = 0;

			for (int i = 1; i < n + 2; i++) {
				sum += (arr[i] - arr[i - 1] - 1) / mid;
			}

			if (sum > m) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}
}
