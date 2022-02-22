/**
 * SWEA 7465번
 * 창용 마을 무리의 개수
 */

package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7465 {

	static int n, m;
	static int[] parents;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int testcase = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testcase; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			parents = new int[n + 1];
			for (int i = 0; i < n + 1; i++) {
				parents[i] = i;
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int one = Integer.parseInt(st.nextToken());
				int another = Integer.parseInt(st.nextToken());
				union(one, another);
			}

			int sum = 0;
			for (int i = 1; i < n + 1; i++) {
				if (parents[i] == i)
					sum++;
			}

			sb.append(sum).append("\n");
		}

		System.out.print(sb);
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			parents[y] = x;
		}
	}

	private static int find(int x) {
		if (x == parents[x]) {
			return x;
		}
		return parents[x] = find(parents[x]);
	}
}
