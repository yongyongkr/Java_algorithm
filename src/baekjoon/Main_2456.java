/**
 * 백준 2456번
 * 나는 학급회장이다
 * https://www.acmicpc.net/problem/2456
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2456 {

	static class Candidate implements Comparable<Candidate> {
		int number;
		int threeP;
		int twoP;
		int oneP;

		public Candidate(int number) {
			this.number = number;
		}

		public void vote(int point) {
			if (point == 3) {
				threeP++;
			} else if (point == 2) {
				twoP++;
			} else if (point == 1) {
				oneP++;
			}
		}

		public int getSum() {
			return 3 * this.threeP + 2 * this.twoP + this.oneP;
		}

		@Override
		public int compareTo(Candidate c) {
			if (this.getSum() != c.getSum()) {
				return Integer.compare(c.getSum(), this.getSum());
			} else if (this.threeP != c.threeP) {
				return Integer.compare(c.threeP, this.threeP);
			}
			return Integer.compare(c.twoP, this.twoP);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Candidate candidate = (Candidate)o;
			return threeP == candidate.threeP && twoP == candidate.twoP && oneP == candidate.oneP;
		}

		@Override
		public int hashCode() {
			return Objects.hash(threeP, twoP, oneP);
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		Queue<Candidate> queue = new PriorityQueue<>();

		Candidate first = new Candidate(1);
		Candidate second = new Candidate(2);
		Candidate third = new Candidate(3);

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			first.vote(Integer.parseInt(st.nextToken()));
			second.vote(Integer.parseInt(st.nextToken()));
			third.vote(Integer.parseInt(st.nextToken()));
		}

		queue.addAll(Arrays.asList(first, second, third));

		Candidate president = queue.poll();
		if (president.equals(queue.peek())) {
			System.out.printf("%d %d\n", 0, president.getSum());
			return;
		}
		System.out.printf("%d %d\n", president.number, president.getSum());
	}
}
