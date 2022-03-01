/**
 * 백준 1062번
 * 가르침
 * https://www.acmicpc.net/problem/1062
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1062 {

	static int n, k;
	static String[] words;
	static int flag = 0;
	static int max = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		k = Integer.parseInt(s[1]);
		words = new String[n];

		if (k < 5) {
			System.out.println(0);
		} else if (k == 26) {
			System.out.println(n);
		} else {
			for (int i = 0; i < n; i++) {
				String s1 = br.readLine();
				words[i] = s1.substring(4, s1.length() - 4);
			}
			flag |= 1 << 'a' - 'a';
			flag |= 1 << 'n' - 'a';
			flag |= 1 << 't' - 'a';
			flag |= 1 << 'i' - 'a';
			flag |= 1 << 'c' - 'a';
			func(0, 0, flag);
			System.out.println(max);
		}
	}

	public static void func(int idx, int start, int flag) {
		if (idx == k - 5) {
			int count = n;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < words[i].length(); j++) {
					if ((flag & 1 << words[i].charAt(j) - 'a') == 0) {
						count--;
						break;
					}
				}
			}
			max = Math.max(count, max);
			return;
		}
		for (int i = start; i < 26; i++) {
			if ((flag & 1 << i) != 0)
				continue;
			func(idx + 1, i + 1, flag | 1 << i);
		}
	}
}
