/**
 * 백준 18119번
 * 단어 암기
 * https://www.acmicpc.net/problem/18119
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18119 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int alphabet = (1 << 27) - 1;
		int[] words = new int[n];
		for (int i = 0; i < n; i++) {
			char[] chars = br.readLine().toCharArray();
			for (char c : chars) {
				words[i] |= 1 << (c - 'a');
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int idx = st.nextToken().charAt(0) - 'a';

			if (command == 1) {
				alphabet &= ~(1 << idx);
			} else if (command == 2) {
				alphabet |= 1 << idx;
			}

			int cnt = 0;
			for (int word : words) {
				if ((alphabet & word) == word)
					cnt++;
			}

			sb.append(cnt).append("\n");
		}

		System.out.print(sb);
	}
}
