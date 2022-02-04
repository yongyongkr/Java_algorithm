/**
 * 백준 2230번
 * 수 고르기
 * https://www.acmicpc.net/problem/2230
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2230 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		int diff = Integer.MAX_VALUE;
		int left = 0;
		int right = 1;
		while (left < right) {
			if (right >= arr.length) {
				break;
			}

			int curDiff = arr[right] - arr[left];

			if (curDiff == m) {
				diff = curDiff;
				break;
			} else if (curDiff < m) {
				right++;
			} else if (left + 1 == right) {
				diff = Math.min(diff, curDiff);
				right++;
			} else {
				diff = Math.min(diff, curDiff);
				left++;
			}
		}

		System.out.println(diff);
	}
}
