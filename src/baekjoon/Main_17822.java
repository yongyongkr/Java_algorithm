/**
 * 백준 17822번
 * 원판 돌리기
 * https://www.acmicpc.net/problem/17822
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17822 {

	static int n, m, t;
	static int[][] arr;
	static List<Integer> list;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static boolean flag;

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			flag = false;
			if (d == 0) {
				moveRight(x, k);
			} else if (d == 1) {
				moveLeft(x, k);
			}
		}

		System.out.println(getSum());
	}

	private static int getSum() {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sum += arr[i][j];
			}
		}
		return sum;
	}

	private static void moveLeft(int x, int k) {
		for (int i = x - 1; i < n; i += x) {
			rotateLeft(i, k);
		}
		removeAdjacent();
	}

	private static void moveRight(int x, int k) {
		for (int i = x - 1; i < n; i += x) {
			rotateRight(i, k);
		}
		removeAdjacent();
	}

	private static void removeAdjacent() {
		boolean[][] needRemove = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (needRemove[i][j] || arr[i][j] == 0)
					continue;
				bfs(needRemove, i, j);
			}
		}
		if (flag) {
			remove(needRemove);
		} else {
			double avg = getAvg();
			plusMinus(avg);
		}
	}

	private static void plusMinus(double avg) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0)
					continue;
				if (arr[i][j] < avg)
					arr[i][j]++;
				else if (arr[i][j] > avg)
					arr[i][j]--;
			}
		}
	}

	private static double getAvg() {
		int sum = 0;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0)
					continue;
				sum += arr[i][j];
				cnt++;
			}
		}
		return (double)sum / cnt;
	}

	private static void remove(boolean[][] needRemove) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (needRemove[i][j]) {
					arr[i][j] = 0;
				}
			}
		}
	}

	private static void bfs(boolean[][] needRemove, int i, int j) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(i, j));
		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int l = 0; l < 4; l++) {
				int nx = cur.x + dx[l];
				int ny = cur.y + dy[l];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || needRemove[nx][ny] || arr[cur.x][cur.y] != arr[nx][ny])
					continue;
				flag = true;
				needRemove[cur.x][cur.y] = true;
				needRemove[nx][ny] = true;
				q.offer(new Point(nx, ny));
			}
			if (cur.y == 0 && arr[cur.x][cur.y] == arr[cur.x][m - 1] && arr[cur.x][cur.y] != 0 && !needRemove[cur.x][m
				- 1]) {
				flag = true;
				needRemove[cur.x][0] = true;
				needRemove[cur.x][m - 1] = true;
				q.offer(new Point(cur.x, m - 1));
			} else if (cur.y == m - 1 && arr[cur.x][cur.y] == arr[cur.x][0] && arr[cur.x][cur.y] != 0
				&& !needRemove[cur.x][0]) {
				flag = true;
				needRemove[cur.x][0] = true;
				needRemove[cur.x][m - 1] = true;
				q.offer(new Point(cur.x, 0));
			}
		}
	}

	private static void rotateRight(int row, int rotate) {
		list = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			list.add(arr[row][i]);
		}
		int start = m - rotate;
		for (int i = 0; i < m; i++) {
			arr[row][i] = list.get(start++ % m);
		}
	}

	private static void rotateLeft(int row, int rotate) {
		list = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			list.add(arr[row][i]);
		}
		int start = rotate;
		for (int i = 0; i < m; i++) {
			arr[row][i] = list.get(start++ % m);
		}
	}
}
