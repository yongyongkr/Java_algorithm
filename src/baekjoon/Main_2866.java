/**
 * 백준 2866번
 * 문자열 잘라내기
 * https://www.acmicpc.net/problem/2866
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2866 {

	static int r, c;
	static char[][] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		arr = new char[r][c];

		for (int i = 0; i < c; i++) {
			char[] chars = br.readLine().toCharArray();
			for (int j = 0; j < r; j++) {
				arr[j][i] = chars[j];
			}
		}

		int ans = binarySearch();
		System.out.println(ans);
	}

	private static int binarySearch() {
		int ans = 0;
		int left = 1;
		int right = c - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (check(mid)) {
				ans = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return ans;
	}

	private static boolean check(int start) {
		String[] strings = new String[r];
		for (int i = 0; i < r; i++) {
			strings[i] = String.valueOf(Arrays.copyOfRange(arr[i], start, c));
		}
		Arrays.sort(strings);

		for (int i = 0; i < r - 1; i++) {
			if (strings[i].equals(strings[i + 1])) {
				return false;
			}
		}
		return true;
	}
}
