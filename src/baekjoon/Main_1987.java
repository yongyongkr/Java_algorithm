/**
 * 백준 1987번
 * 알파벳
 * https://www.acmicpc.net/problem/1987
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987 {

	static int r, c, visited, cnt;
	static int[][] map;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		visited = 0;
		cnt = 0;

		map = new int[r][c];
		for (int i = 0; i < r; i++) {
			char[] chars = br.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				map[i][j] = chars[j] - 'A';
			}
		}

		visited |= 1 << map[0][0];
		dfs(0, 0, 1);
		System.out.println(cnt);
	}

	private static void dfs(int x, int y, int depth) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= r || ny < 0 || ny >= c || (visited & (1 << map[nx][ny])) != 0) {
				cnt = Math.max(cnt, depth);
				continue;
			}
			visited |= 1 << map[nx][ny];
			dfs(nx, ny, depth + 1);
			visited &= ~(1 << map[nx][ny]);
		}
	}
}
