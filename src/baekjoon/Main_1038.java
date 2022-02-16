/**
 * 백준 1038번
 * 감소하는 수
 * https://www.acmicpc.net/problem/1038
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1038 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		if (n > 1022) {
			System.out.println(-1);
		} else if (n < 10) {
			System.out.println(n);
		} else {
			Queue<Long> q = new LinkedList<>();
			int cnt = 0;
			for (int i = 1; i < 10; i++) {
				q.offer(Long.valueOf(i));
				cnt++;
			}
			while (cnt < n) {
				long cur = q.poll();
				long units = cur % 10;
				for (int i = 0; i < units; i++) {
					q.offer(cur * 10 + i);
					cnt++;
					if (cnt == n) {
						System.out.println(cur * 10 + i);
						return;
					}
				}
			}
		}
	}
}
