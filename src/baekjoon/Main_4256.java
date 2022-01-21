/**
 * 백준 4256번
 * 트리
 * https://www.acmicpc.net/problem/4256
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_4256 {

	static int[] pre, in;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			pre = new int[n];
			in = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				pre[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				in[i] = Integer.parseInt(st.nextToken());
			}

			post(0, n, 0, bw);
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static void post(int start, int end, int cur, BufferedWriter bw) throws IOException {
		for (int i = start; i < end; i++) {
			if (in[i] == pre[cur]) {
				post(start, i, cur + 1, bw);
				post(i + 1, end, cur + 1 + i - start, bw);
				bw.write(pre[cur] + " ");
			}
		}
	}
}
