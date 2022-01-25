/**
 * 백준 11509번
 * 풍선 맞추기
 * https://www.acmicpc.net/problem/11509
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_11509 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int arrow = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Map<Integer, Integer> countMap = new HashMap<>();
		for (int balloon : arr) {
			if (countMap.getOrDefault(balloon, 0) == 0) {
				countMap.put(balloon - 1, countMap.getOrDefault(balloon - 1, 0) + 1);
				arrow += 1;
			} else {
				countMap.put(balloon, countMap.get(balloon) - 1);
				countMap.put(balloon - 1, countMap.getOrDefault(balloon - 1, 0) + 1);
			}
		}

		bw.write(String.valueOf(arrow));
		bw.flush();
		bw.close();
		br.close();
	}
}
