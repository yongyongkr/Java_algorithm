/**
 * 백준 13397번
 * 구간 나누기 2
 * https://www.acmicpc.net/problem/13397
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13397 {

	static int n, m;
	static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];

		int left = 0;
		int right = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, arr[i]);
		}

		while (left < right) {
			int mid = (left + right) / 2;
			if (solve(mid) <= m) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(right);
	}

	private static int solve(int mid) {
		int cnt = 1;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
			if (max - min > mid) {
				cnt++;
				max = Integer.MIN_VALUE;
				min = Integer.MAX_VALUE;
				i--;
			}
		}
		return cnt;
	}
}
