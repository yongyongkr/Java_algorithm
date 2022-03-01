/**
 * 종만북
 * 215페이지
 * 외발 뛰기
 */

/*
입력 값
7 7
2 5 1 6 1 4 1
6 1 1 2 2 9 3
7 2 3 2 1 3 1
1 1 3 1 7 1 2
4 1 2 3 4 1 2
3 3 1 2 3 4 1
1 5 2 9 4 7 0

출력 값
true

입력 값
7 7
2 5 1 6 1 4 1
6 1 1 2 2 9 3
7 2 3 2 1 3 1
1 1 3 1 7 1 2
4 1 2 3 4 1 3
3 3 1 2 3 4 1
1 5 2 9 4 7 0

출력 값
false
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
