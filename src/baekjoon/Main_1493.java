/**
 * 백준 1493번
 * 박스 채우기
 * https://www.acmicpc.net/problem/1493
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1493 {


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int len = Integer.parseInt(st.nextToken());
		int wid = Integer.parseInt(st.nextToken());
		int hei = Integer.parseInt(st.nextToken());

		int n = Integer.parseInt(br.readLine());
		int[] cubes = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			cubes[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}

		long total = 0;
		long count = 0;

		for (int i = n - 1; i >= 0; i--) {
			total <<= 3;
			long temp = Math.min(cubes[i], (long)(len >> i) * (wid >> i) * (hei >> i) - total);
			total += temp;
			count += temp;
		}

		if (total == (long)len * wid * hei) {
			System.out.println(count);
		} else {
			System.out.println(-1);
		}
	}
}
