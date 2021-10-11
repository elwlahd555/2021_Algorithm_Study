package com.study.algorithm.swea.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class swea_2117_홈_방범_서비스 {
	private static int N, map[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			int ans = -1;
			int ans_house = 0;
			int ans_K = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int K = 1;
			while (K != N + 2) {
				int fee = K * K + (K - 1) * (K - 1);
				int house = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						house = check(K, i, j);
						if (house * M - fee > 0) {
							ans_house = Math.max(ans_house, house);
							ans_K = K;
						}
						ans = Math.max(ans, house * M - fee);
					}
				}
				K++;
			}
			System.out.println("#" + t + " " + ans_house);
		}
	}

	private static int check(int k, int x, int y) {
		int cnt = 0;
		int house = 0;
		for (int i = x - k + 1; i < x; i++) {
			if (i < 0 || i >= N) {
				cnt++;
				continue;
			}
			for (int j = y - cnt; j < y + cnt + 1; j++) {
				if (j < 0 || j >= N) {
					continue;
				}
				if (map[i][j] == 1) {
					house++;
				}
			}
			cnt++;
		}
		for (int i = x; i < x + k; i++) {
			if (i < 0 || i >= N) {
				cnt++;
				continue;
			}
			for (int j = y - cnt; j < y + cnt + 1; j++) {
				if (j < 0 || j >= N) {
					continue;
				}
				if (map[i][j] == 1) {
					house++;
				}
			}
			cnt--;
		}
		return house;
	}
}
