/**
 * 백준 15685번
 * 드래곤 커브
 * https://www.acmicpc.net/problem/15685
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15685 {

	static int row, col, d, g;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	static boolean[][] visited = new boolean[101][101];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int answer = 0;

		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			col = Integer.parseInt(st.nextToken());
			row = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());

			dragonCurve();
		}

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (visited[i][j] && visited[i + 1][j] && visited[i][j + 1] && visited[i + 1][j + 1]) {
					answer += 1;
				}
			}
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
		br.close();
	}

	private static void dragonCurve() {
		List<Integer> list = new ArrayList<>();
		list.add(d);

		for (int i = 0; i < g; i++) {
			for (int j = list.size() - 1; j >= 0; j--) {
				list.add((list.get(j) + 1) % 4);
			}
		}

		visited[row][col] = true;
		for (Integer dir : list) {
			row += dx[dir];
			col += dy[dir];
			visited[row][col] = true;
		}
	}
}
