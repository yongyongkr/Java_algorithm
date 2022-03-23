/**
 * 백준 14867번
 * 물통
 * https://www.acmicpc.net/problem/14867
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_14867 {

	static int a, b, goalA, goalB;
	static Set<String> set;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		goalA = Integer.parseInt(st.nextToken());
		goalB = Integer.parseInt(st.nextToken());

		set = new HashSet<>();
		int ans = bfs(0, 0);

		System.out.println(ans);
	}

	private static int bfs(int curA, int curB) {
		int cnt = 0;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {curA, curB});
		set.add(curA + " " + curB);

		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int[] cur = q.poll();
				if (cur[0] == goalA && cur[1] == goalB) {
					return cnt;
				}

				// fill A
				if (cur[0] != a) {
					String nextStr = a + " " + cur[1];
					if (!set.contains(nextStr)) {
						q.offer(new int[] {a, cur[1]});
						set.add(nextStr);
					}
				}
				// fill B
				if (cur[1] != b) {
					String nextStr = cur[0] + " " + b;
					if (!set.contains(nextStr)) {
						q.offer(new int[] {cur[0], b});
						set.add(nextStr);
					}
				}
				// A to B
				if (cur[0] != 0 && cur[1] != b) {
					if (cur[0] <= b - cur[1]) {
						int nextB = cur[0] + cur[1];
						String nextStr = 0 + " " + nextB;
						if (!set.contains(nextStr)) {
							q.offer(new int[] {0, nextB});
							set.add(nextStr);
						}
					} else {
						int nextA = cur[0] - b + cur[1];
						String nextStr = nextA + " " + b;
						if (!set.contains(nextStr)) {
							q.offer(new int[] {nextA, b});
							set.add(nextStr);
						}
					}
				}
				// B to A
				if (cur[0] != a && cur[1] != 0) {
					if (cur[1] <= a - cur[0]) {
						int nextA = cur[0] + cur[1];
						String nextStr = nextA + " " + 0;
						if (!set.contains(nextStr)) {
							q.offer(new int[] {nextA, 0});
							set.add(nextStr);
						}
					} else {
						int nextB = cur[1] - a + cur[0];
						String nextStr = a + " " + nextB;
						if (!set.contains(nextStr)) {
							q.offer(new int[] {a, nextB});
							set.add(nextStr);
						}
					}
				}

				// empty A
				if (cur[0] != 0) {
					String nextStr = 0 + " " + cur[1];
					if (!set.contains(nextStr)) {
						q.offer(new int[] {0, cur[1]});
						set.add(nextStr);
					}
				}

				// empty B
				if (cur[1] != 0) {
					String nextStr = cur[0] + " " + 0;
					if (!set.contains(nextStr)) {
						q.offer(new int[] {cur[0], 0});
						set.add(nextStr);
					}
				}
			}
			cnt++;
		}
		return -1;
	}
}
