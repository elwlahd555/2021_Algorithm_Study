package com.study.algorithm.swea.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_4014_활주로_건설 {
	private static int N, X, map[][];

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			int ans = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				if (check(i, true)) {
					ans++;
				}
				if (check(i, false)) {
					ans++;
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}

	private static boolean check(int idx, boolean row) {
		boolean[] visited = new boolean[N];
		int cnt = 0;
		int before = -1;
		if (row) {
			before = map[idx][0];
			for (int i = 0; i < N; i++) {
				int cur = map[idx][i];
				if (cur == before) {
					cnt++;
				} else {
					if (cur == before + 1) {
						if (cnt >= X) {
							for (int j = i - X; j < i; j++) {
								if (visited[j])
									return false;
								visited[j] = true;
							}
							cnt = 1;
						} else {
							return false;
						}
					} else if (cur == before - 1) {
						if (i + X - 1 < N) {
							for (int j = i; j < i + X; j++) {
								if (visited[j] || map[idx][j] != cur)
									return false;
								visited[j] = true;
							}
							cnt = 0;
							i = i + X - 1;
						} else {
							return false;
						}
					} else {
						return false;
					}
					before = cur;
				}
			}
		} else {
			before = map[0][idx];
			for (int i = 0; i < N; i++) {
				int cur = map[i][idx];
				if (cur == before) {
					cnt++;
				} else {
					if (cur == before + 1) {
						if (cnt >= X) {
							for (int j = i - X; j < i; j++) {
								if (visited[j])
									return false;
								visited[j] = true;
							}
							cnt = 1;
						} else {
							return false;
						}
					} else if (cur == before - 1) {
						if (i + X - 1 < N) {
							for (int j = i; j < i + X; j++) {
								if (visited[j] || map[j][idx] != cur)
									return false;
								visited[j] = true;
							}
							cnt = 0;
							i = i + X - 1;
						} else {
							return false;
						}
					} else {
						return false;
					}
					before = cur;
				}
			}
		}
		return true;
	}
}
