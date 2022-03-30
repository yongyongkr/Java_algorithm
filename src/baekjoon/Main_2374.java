/**
 * 백준 2374번
 * 같은 수로 만들기
 * https://www.acmicpc.net/problem/2374
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2374 {

	static long answer = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		while (true) {
			int idx = findMin(arr);
			if (idx == -1) {
				break;
			}
			increase(arr, idx);
		}
		System.out.println(answer);
	}

	private static void increase(int[] arr, int idx) {
		int left = idx - 1;
		int right = idx + 1;
		while (left >= 0 && arr[left] == arr[idx]) {
			left--;
		}
		while (right < arr.length && arr[right] == arr[idx]) {
			right++;
		}
		if (left == -1) {
			left = 0;
		}
		if (right == arr.length) {
			right = arr.length - 1;
		}

		int change;
		if (arr[left] == arr[idx]) {
			change = arr[right];
		} else if (arr[right] == arr[idx]) {
			change = arr[left];
		} else {
			change = Math.min(arr[left], arr[right]);
		}

		answer += change - arr[idx];
		int before = arr[idx];
		for (int i = left; i <= right; i++) {
			if (arr[i] == before) {
				arr[i] = change;
			}
		}
	}

	private static int findMin(int[] arr) {
		int idx = 0;
		boolean flag = true;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] > arr[i]) {
				idx = i;
			}
			if (arr[i - 1] != arr[i]) {
				flag = false;
			}
		}

		if (flag) {
			return -1;
		}
		return idx;
	}
}
