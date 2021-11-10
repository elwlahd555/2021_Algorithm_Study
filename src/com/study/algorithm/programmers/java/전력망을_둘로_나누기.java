package com.study.algorithm.programmers.java;

public class 전력망을_둘로_나누기 {
	private static int[] parent;

	public static int solution(int n, int[][] wires) {
		int answer = 100;
		parent = new int[n + 1];
		for (int k = 0; k < wires.length; k++) {
			for (int i = 0; i < parent.length; i++) {
				parent[i] = i;
			}
			for (int i = 0; i < wires.length; i++) {
				if (i == k) {
					continue;
				}
				union(wires[i][0], wires[i][1]);
			}
			int size = 0;
			for (int i = 1; i < n + 1; i++) {
				if (find(parent[i]) != 1) {
					size++;
				}
			}
			if (answer > Math.abs(n - size * 2)) {
				answer = Math.abs(n - size * 2);
			}
		}
		return answer;
	}

	public static void union(int a, int b) {
		int ra = find(a);
		int rb = find(b);
		if (rb < ra) {
			int tmp = ra;
			ra = rb;
			rb = tmp;
		}
		if (ra != rb) {
			parent[rb] = ra;
		}
	}

	private static int find(int x) {
		if (parent[x] == x)
			return x;
		return find(parent[x]);
	}

	public static void main(String[] args) {

		int[][] wires = { { 1, 3 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 4, 6 }, { 4, 7 }, { 7, 8 }, { 7, 9 } };
		System.out.println(solution(9, wires));

	}
}
