/**
 * 백준 1043번
 * 거짓말
 * https://www.acmicpc.net/problem/1043
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1043 {

	static int N;
	static int[] truth;
	static int[] parent;
	static List<List<Integer>> parties = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int kNum = Integer.parseInt(st.nextToken());

		if (kNum == 0) {
			System.out.println(M);
			return;
		}

		truth = new int[kNum];
		for (int i = 0; i < kNum; i++) {
			truth[i] = Integer.parseInt(st.nextToken());
		}

		parent = new int[N + 1];
		init();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int pNum = Integer.parseInt(st.nextToken());

			List<Integer> party = new ArrayList<>();
			party.add(Integer.parseInt(st.nextToken()));

			for (int j = 1; j < pNum; j++) {
				party.add(Integer.parseInt(st.nextToken()));
				if (party.get(0) < party.get(j))
					union(party.get(0), party.get(j));
				else
					union(party.get(j), party.get(0));
			}
			parties.add(party);
		}
		int ans = 0;

		for (List<Integer> party : parties) {
			boolean flag = false;
			for (int member : party) {
				if (!check(member)) {
					flag = true;
					break;
				}
			}
			if (!flag)
				ans++;
		}
		System.out.println(ans);

	}

	static public void init() {
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}

	static public int find(int x) {
		if (x == parent[x])
			return x;
		else
			return parent[x] = find(parent[x]);
	}

	static public void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y)
			parent[y] = x;
	}

	static public boolean check(int x) {
		x = find(x);
		for (int item : truth) {
			if (x == find(item))
				return false;
		}
		return true;
	}
}
