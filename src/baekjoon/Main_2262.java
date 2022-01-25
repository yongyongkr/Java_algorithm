/**
 * 백준 2262번
 * 토너먼트 만들기
 * https://www.acmicpc.net/problem/2262
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2262 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		List<Integer> players = new ArrayList<>();
		Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			players.add(Integer.parseInt(st.nextToken()));
			queue.offer(players.get(i));
		}

		while (queue.size() > 1) {
			Integer last = queue.poll();
			int index = players.indexOf(last);
			if (index == 0) {
				answer += last - players.get(index + 1);
			} else if (index == players.size() - 1) {
				answer += last - players.get(index - 1);
			} else {
				answer += Math.min(last - players.get(index + 1), last - players.get(index - 1));
			}

			players.remove(index);
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
		br.close();
	}
}
