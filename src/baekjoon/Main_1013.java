/**
 * 백준 1013번
 * Contact
 * https://www.acmicpc.net/problem/1013
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1013 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String pattern = br.readLine();
			if (pattern.matches("(100+1+|01)+")) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
