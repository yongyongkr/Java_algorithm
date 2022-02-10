/**
 * 백준 1158번
 * 요세푸스 문제
 * https://www.acmicpc.net/problem/1158
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1158 {

	static List<Integer> list;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		list = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}

		sb.append("<");
		pop(k - 1, k - 1);
		sb.setLength(sb.length() - 2);
		sb.append(">");
		System.out.println(sb);
	}

	private static void pop(int idx, int range) {
		sb.append(list.get(idx)).append(", ");
		list.remove(idx);
		if (list.isEmpty())
			return;
		pop((idx + range) % list.size(), range);
	}
}
