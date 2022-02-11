/**
 * 백준 21939번
 * 문제 추천 시스템 Version 1
 * https://www.acmicpc.net/problem/21939
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main_21939 {

	static class Problem implements Comparable<Problem> {
		int num;
		int lvl;

		public Problem(int num, int lvl) {
			this.num = num;
			this.lvl = lvl;
		}

		@Override
		public int compareTo(Problem o) {
			if (this.lvl == o.lvl) {
				return Integer.compare(this.num, o.num);
			}
			return Integer.compare(this.lvl, o.lvl);
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		TreeSet<Problem> ts = new TreeSet<>();
		Map<Integer, Integer> map = new HashMap<>();

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int lvl = Integer.parseInt(st.nextToken());
			ts.add(new Problem(idx, lvl));
			map.put(idx, lvl);
		}

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();

			if (command.equals("add")) {
				int idx = Integer.parseInt(st.nextToken());
				int lvl = Integer.parseInt(st.nextToken());
				ts.add(new Problem(idx, lvl));
				map.put(idx, lvl);
			} else if (command.equals("recommend")) {
				int order = Integer.parseInt(st.nextToken());
				if (order == 1) {
					System.out.println(ts.last().num);
				} else if (order == -1) {
					System.out.println(ts.first().num);
				}
			} else if (command.equals("solved")) {
				int sol = Integer.parseInt(st.nextToken());
				ts.remove(new Problem(sol, map.get(sol)));
				map.remove(sol);
			}
		}
	}
}
