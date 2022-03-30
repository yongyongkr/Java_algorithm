package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_2636 {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int row, col;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		int cheese = 0;
		int time = 0;

		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					cheese++;
			}
		}

		while (true) {
			time++;

			Set<Point> border = bfs(0, 0);
			if (cheese == border.size()) {
				System.out.println(time);
				System.out.println(cheese);
				return;
			}
			cheese -= border.size();
			removeBorder(border);

		}
	}

	private static void removeBorder(Set<Point> border) {
		for (Point point : border) {
			map[point.x][point.y] = 0;
		}
	}

	private static Set<Point> bfs(int r, int c) {
		Set<Point> set = new HashSet<>();
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[row][col];
		q.offer(new Point(r, c));
		visited[r][c] = true;

		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (notIn(nx, ny) || visited[nx][ny])
					continue;
				if (map[nx][ny] == 1) {
					set.add(new Point(nx, ny));
					visited[nx][ny] = true;
					continue;
				}
				q.offer(new Point(nx, ny));
				visited[nx][ny] = true;
			}
		}
		return set;
	}

	private static boolean notIn(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= row || ny >= col;
	}
}
