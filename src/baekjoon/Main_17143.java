/**
 * 백준 17143번
 * 낚시왕
 * https://www.acmicpc.net/problem/17143
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17143 {

	static class Shark {
		int speed;
		int dir;
		int size;

		public Shark(int speed, int dir, int size) {
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}
	}

	static int r, c, m, ans, fisher;
	static Shark[][] map;
	static int[] dx = {0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, 1, -1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new Shark[r][c];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken()) - 1;
			int col = Integer.parseInt(st.nextToken()) - 1;
			int speed = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			map[row][col] = new Shark(speed, dir, size);
		}

		ans = 0;
		fisher = -1;

		while (++fisher < c) {
			catchShark();
			moveShark();
		}

		System.out.println(ans);
	}

	private static void moveShark() {
		Shark[][] temp = new Shark[r][c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {

				if (map[i][j] == null)
					continue;

				Shark shark = map[i][j];
				int speed = shark.speed;
				int nx = i;
				int ny = j;

				while (speed-- > 0) {
					turnAround(nx, ny, shark);
					nx += dx[shark.dir];
					ny += dy[shark.dir];
				}

				if (temp[nx][ny] == null || temp[nx][ny].size < shark.size) {
					temp[nx][ny] = shark;
				}
			}
		}

		map = temp;
	}

	private static void turnAround(int i, int j, Shark shark) {
		if (i == 0 && shark.dir == 1) {
			shark.dir = 2;
		} else if (i == r - 1 && shark.dir == 2) {
			shark.dir = 1;
		} else if (j == 0 && shark.dir == 4) {
			shark.dir = 3;
		} else if (j == c - 1 && shark.dir == 3) {
			shark.dir = 4;
		}
	}

	private static void catchShark() {
		for (int row = 0; row < r; row++) {
			if (map[row][fisher] != null) {
				ans += map[row][fisher].size;
				map[row][fisher] = null;
				return;
			}
		}
	}
}
