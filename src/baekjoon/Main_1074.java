/**
 * 백준 1074번
 * Z
 * https://www.acmicpc.net/problem/1074
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074 {

	static int r, c;
	static long cnt;
	static boolean flag;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int n = (int)Math.pow(2, N);
		cnt = - 1;

		divideConquer(n, 0, 0);
		System.out.println(cnt);
	}

	private static void divideConquer(int x, int sr, int sc) {
		if (flag) return;

		if (sr == r && sc == c) {
			cnt++;
			flag = true;
			return;
		}

		if (x == 1) {
			cnt++;
			return;
		}

		if (r < sr + x / 2 && c < sc + x / 2) {
			divideConquer(x / 2, sr, sc);
		} else if (r < sr + x / 2 && sc + x / 2 <= c && c < sc + x) {
			cnt += (long)x * x / 4;
			divideConquer(x / 2, sr, sc + x / 2);
		} else if (sr + x / 2 <= r && r < sr + x && c < sc + x / 2) {
			cnt += (long)x * x / 2;
			divideConquer(x / 2, sr + x / 2, sc);
		} else {
			cnt += (long)x * x * 3 / 4;
			divideConquer(x / 2, sr + x / 2, sc + x / 2);
		}
	}
}
