/**
 * 백준 15686번
 * 치킨 배달
 * https://www.acmicpc.net/problem/15686
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15686 {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n, m, ans;
	static int[][] map;
	static List<Point> chickens = new ArrayList<>();
	static List<Point> homes = new ArrayList<>();
	static int[] selected;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		selected = new int[m];
		ans = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					homes.add(new Point(i, j));
				} else if (map[i][j] == 2) {
					chickens.add(new Point(i, j));
				}
			}
		}

		dfs(0, 0);
		System.out.println(ans);
	}

	private static void dfs(int start, int lvl) {
		if (lvl == m) {
			int sum = 0;
			for (Point home : homes) {
				int min = Integer.MAX_VALUE;
				for (int chick : selected) {
					Point chicken = chickens.get(chick);
					min = Math.min(min, getDistance(chicken, home));
				}

				sum += min;
				if (sum >= ans) {
					return;
				}
			}
			ans = Math.min(ans, sum);
		} else {
			for (int i = start; i < chickens.size(); i++) {
				selected[lvl] = i;
				dfs(i + 1, lvl + 1);
			}
		}
	}

	private static int getDistance(Point from, Point to) {
		return Math.abs(from.x - to.x) + Math.abs(from.y - to.y);
	}
}
