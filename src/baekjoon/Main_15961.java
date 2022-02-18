/**
 * 백준 15961번
 * 회전 초밥
 * https://www.acmicpc.net/problem/15961
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_15961 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int plates = Integer.parseInt(st.nextToken());
		int types = Integer.parseInt(st.nextToken());
		int continuous = Integer.parseInt(st.nextToken());
		int coupon = Integer.parseInt(st.nextToken());
		int max = Integer.MIN_VALUE;

		int[] arr = new int[plates];
		for (int i = 0; i < plates; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Queue<Integer> window = new LinkedList<>();
		int[] visited = new int[types + 1];
		int cnt = 0;
		for (int i = 0; i < continuous; i++) {
			if (visited[arr[i]]++ == 0)
				cnt++;
			window.offer(arr[i]);
		}

		max = Math.max(max, (visited[coupon] == 0) ? cnt + 1 : cnt);

		for (int i = 0; i < plates; i++) {
			int idx = (continuous + i) % plates;
			int polled = window.poll();
			if (--visited[polled] == 0)
				cnt--;
			window.offer(arr[idx]);
			if (visited[arr[idx]]++ == 0)
				cnt++;
			max = Math.max(max, (visited[coupon] == 0) ? cnt + 1 : cnt);
		}

		System.out.println(max);
	}
}
