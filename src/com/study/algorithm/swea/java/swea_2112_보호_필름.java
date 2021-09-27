package com.study.algorithm.swea.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_2112_보호_필름 {
	private static int D, W, K, answer, change;
	private static int map[][];
	private static int chMap[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			answer = Integer.MAX_VALUE;
			map = new int[D][W];
			chMap = new int[D][W];
			change = 0;
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					int k = Integer.parseInt(st.nextToken());
					chMap[i][j] = k;
					map[i][j] = k;
				}
			}
			dfs(0, 0);
			System.out.println("#" + t + " " + answer);
		}

	}

	private static void dfs(int cnt, int change) {
		if (check()) {
			answer = Math.min(answer, change);
		}
		if (cnt == D) {
			return;
		}
		if (change >= answer) {
			return;
		}
		dfs(cnt + 1, change);
		for (int i = 0; i < W; i++) {
			chMap[cnt][i] = 0;
		}
		dfs(cnt + 1, change + 1);
		for (int i = 0; i < W; i++) {
			chMap[cnt][i] = 1;
		}
		dfs(cnt + 1, change + 1);
		chMap[cnt] = map[cnt].clone();
	}

	private static boolean check() {
		for (int i = 0; i < W; i++) {
			int num = 0;
			int now = 0;
			for (int j = 0; j < D; j++) {
				if (chMap[j][i] == now) {
					num++;
				} else {
					now = chMap[j][i];
					num = 1;
				}
				if (num == K) {
					break;
				}
			}
			if (num < K) {
				return false;
			}
		}
		return true;
	}

}
