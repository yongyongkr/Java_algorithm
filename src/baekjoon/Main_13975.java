/**
 * 백준 13975번
 * 파일 합치기 3
 * https://www.acmicpc.net/problem/13975
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13975 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int k = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<Long> q = new PriorityQueue<>();

			for (int i = 0; i < k; i++) {
				q.offer(Long.parseLong(st.nextToken()));
			}

			long sum = 0;
			while (q.size() > 1) {
				long cost = q.poll() + q.poll();
				sum += cost;
				q.offer(cost);
			}

			System.out.println(sum);
		}
	}
}
