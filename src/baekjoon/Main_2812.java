/**
 * 백준 2812번
 * 크게 만들기
 * https://www.acmicpc.net/problem/2812
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2812 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		String number = br.readLine();

		Stack<Character> stack = new Stack<>();
		stack.push(number.charAt(0));
		int count = 0;

		for (int i = 1; i < n; i++) {
			char c = number.charAt(i);
			while (!stack.isEmpty() && count < k) {
				if (stack.peek() < c) {
					stack.pop();
					count++;
				} else {
					break;
				}
			}
			stack.push(c);
		}

		for (int i = 0; i < n - k; i++) {
			bw.write(stack.get(i));
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
