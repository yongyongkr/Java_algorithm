/**
 * 1744번
 * 수 묶기
 * https://www.acmicpc.net/problem/1744
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_1744 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> negative = new PriorityQueue<>();
		Queue<Integer> positive = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
		int zeros = 0;

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num < 0) {
				negative.offer(num);
			} else if (num > 0) {
				positive.offer(num);
			} else {
				zeros++;
			}
		}

		int answer = 0;
		while (positive.size() >= 2) {
			Integer first = positive.poll();
			Integer second = positive.poll();
			if (second != 1) {
				answer += first * second;
			} else {
				answer += first + second;
			}
		}
		while (!positive.isEmpty()) {
			answer += positive.poll();
		}

		while (negative.size() >= 2) {
			answer += negative.poll() * negative.poll();
		}
		while (!negative.isEmpty()) {
			if (zeros != 0) {
				zeros--;
				negative.poll();
			} else {
				answer += negative.poll();
			}
		}

		bw.write(answer + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
