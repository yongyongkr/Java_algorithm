/**
 * 종만북
 * 외발 뛰기
 * https://algospot.com/judge/problem/read/JUMPGAME
 */

package jongmanbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JumpGame_MyTrial {

	static int r, c;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1, 0};
	static int[] dy = {0, 1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new int[r][c];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[r][c];
		dfs(0, 0);

		System.out.println(visited[r - 1][c - 1]);
	}

	private static void dfs(int row, int col) {
		if (visited[row][col]) {
			return;
		}

		if (map[row][col] == 0) {
			visited[row][col] = true;
			return;
		}

		visited[row][col] = true;

		for (int i = 0; i < 2; i++) {
			int nx = row + dx[i] * map[row][col];
			int ny = col + dy[i] * map[row][col];
			if (nx >= r || ny >= c)
				continue;
			dfs(nx, ny);
		}
	}
}
