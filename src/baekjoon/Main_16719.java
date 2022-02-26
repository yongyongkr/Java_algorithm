/**
 * 백준 16719번
 * ZOAC
 * https://www.acmicpc.net/problem/16719
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16719 {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		divide(str, 0);
	}

	private static void divide(String str, int putIndex) {
		if (str == null || str.length() == 0) {
			return;
		}

		int idx = 0;
		char c = str.charAt(0);
		for (int i = 1; i < str.length(); i++) {
			if (c > str.charAt(i)) {
				c = str.charAt(i);
				idx = i;
			}
		}

		sb.insert(putIndex, c);
		System.out.println(sb);
		divide(str.substring(idx + 1), putIndex + 1);
		divide(str.substring(0, idx), putIndex);
	}
}
