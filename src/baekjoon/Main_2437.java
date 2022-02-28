/**
 * 백준 2437번
 * 저울
 * https://www.acmicpc.net/problem/2437
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2437 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] scales = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			scales[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(scales);

		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (sum + 1 < scales[i]) {
				break;
			}
			sum += scales[i];
		}

		System.out.println(sum + 1);
	}
}
