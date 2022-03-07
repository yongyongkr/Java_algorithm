/**
 * 백준 1525번
 * 퍼즐
 * https://www.acmicpc.net/problem/1525
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1525 {

	static final String goal = "123456780";
	static Map<String, Integer> map = new HashMap<>();
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				sb.append(st.nextToken());
			}
		}

		map.put(sb.toString(), 0);
		int depth = bfs(sb.toString());
		System.out.println(depth);
	}

	private static int bfs(String start) {
		Queue<String> q = new LinkedList<>();
		q.offer(start);
		while (!q.isEmpty()) {
			String cur = q.poll();
			int move = map.get(cur);
			int blank = cur.indexOf('0');
			int curX = blank / 3;
			int curY = blank % 3;

			if (cur.equals(goal))
				return move;

			for (int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				if (isIn(nx, ny)) {
					int nIdx = nx * 3 + ny;
					char ch = cur.charAt(nIdx);
					StringBuilder sb = new StringBuilder(cur);
					sb.replace(blank, blank + 1, String.valueOf(ch));
					sb.replace(nIdx, nIdx + 1, String.valueOf(0));

					String next = sb.toString();
					if (!map.containsKey(next)) {
						q.offer(next);
						map.put(next, move + 1);
					}
				}
			}
		}
		return -1;
	}

	private static boolean isIn(int nx, int ny) {
		return 0 <= nx && nx < 3 && 0 <= ny && ny < 3;
	}
}
