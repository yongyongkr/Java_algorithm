package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1247 {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n, ans;
	static Point com, home;
	static List<Point> points;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testcase = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testcase; tc++) {
			n = Integer.parseInt(br.readLine());
			points = new ArrayList<>();

			st = new StringTokenizer(br.readLine());

			com = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for (int i = 0; i < n; i++) {
				points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			ans = Integer.MAX_VALUE;
			visited = new boolean[n];

			dfs(com.x, com.y, 0, 0);
			System.out.printf("#%d %d\n", tc, ans);
		}
	}

	private static void dfs(int x, int y, int depth, int dist) {
		if (depth == n) {
			dist += getDistance(x, y, home.x, home.y);
			ans = Math.min(ans, dist);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			Point np = points.get(i);
			dfs(np.x, np.y, depth + 1, dist + getDistance(x, y, np.x, np.y));
			visited[i] = false;
		}
	}

	private static int getDistance(int fromX, int fromY, int toX, int toY) {
		return Math.abs(fromX - toX) + Math.abs(fromY - toY);
	}
}
