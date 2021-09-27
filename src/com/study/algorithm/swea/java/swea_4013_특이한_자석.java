package com.study.algorithm.swea.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_4013_특이한_자석 {
	private static int wheel[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int K = Integer.parseInt(br.readLine());
			wheel = new int[5][8];
			StringTokenizer st;
			for (int i = 1; i < 5; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 8; j++) {
					wheel[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine(), " ");
				int num = Integer.parseInt(st.nextToken());
				int lotate = Integer.parseInt(st.nextToken());

				int lot[] = new int[5];
				lot[num] = lotate;
				for (int i = num + 1; i < 5; i++) {
					if (wheel[i - 1][2] != wheel[i][6]) {
						lot[i] = lot[i - 1] * (-1);
					} else {
						break;
					}
				}
				for (int i = num - 1; i >= 1; i--) {
					if (wheel[i + 1][6] != wheel[i][2]) {
						lot[i] = lot[i + 1] * (-1);
					} else {
						break;
					}
				}
				lotation(lot);
			}
			int ans = 0;
			for (int i = 1; i < 5; i++) {
				if (wheel[i][0] == 1) {
					ans += Math.pow(2, i - 1);
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}

	private static void lotation(int lot[]) {
		int temp = 0;
		int temptemp = 0;
		for (int i = 1; i < 5; i++) {
			if (lot[i] == 1) {
				temp = wheel[i][7];
				for (int j = 0; j < 8; j++) {
					temptemp = wheel[i][j];
					wheel[i][j] = temp;
					temp = temptemp;
				}

			} else if (lot[i] == -1) {
				temp = wheel[i][0];
				for (int j = 7; j >= 0; j--) {
					temptemp = wheel[i][j];
					wheel[i][j] = temp;
					temp = temptemp;
				}
			}
		}
	}
}
