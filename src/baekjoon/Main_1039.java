/**
 * 백준 1039번
 * 교환
 * https://www.acmicpc.net/problem/1039
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1039 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String num = st.nextToken();
		int k = Integer.parseInt(st.nextToken());

		if (num.length() == 1) {
			System.out.println(-1);
			return;
		}

		String ans = bfs(num, k);

		System.out.println(ans);
	}

	private static String bfs(String num, int k) {
		Queue<String> q = new LinkedList<>();
		q.offer(num);
		while (k-- > 0) {
			int size = q.size();
			if (size == 0)
				return "-1";
			Set<String> set = new HashSet<>();

			while (size-- > 0) {
				String cur = q.poll();
				for (int i = 0; i < cur.length() - 1; i++) {
					for (int j = i + 1; j < cur.length(); j++) {
						if (i == 0 && cur.charAt(j) == '0') {
							continue;
						}
						StringBuilder sb = new StringBuilder();
						for (int l = 0; l < i; l++) {
							sb.append(cur.charAt(l));
						}
						sb.append(cur.charAt(j));
						for (int l = i + 1; l < j; l++) {
							sb.append(cur.charAt(l));
						}
						sb.append(cur.charAt(i));
						for (int l = j + 1; l < cur.length(); l++) {
							sb.append(cur.charAt(l));
						}
						if (!set.contains(sb.toString())) {
							q.offer(sb.toString());
							set.add(sb.toString());
						}
					}
				}
			}
		}
		if (q.isEmpty()) {
			return "-1";
		}
		Queue<String> pq = new PriorityQueue<>(Comparator.reverseOrder());
		pq.addAll(q);
		return pq.poll();
	}
}
