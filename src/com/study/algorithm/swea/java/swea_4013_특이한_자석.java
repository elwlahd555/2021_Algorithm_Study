package com.study.algorithm.swea.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_4013_특이한_자석 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int K=Integer.parseInt(br.readLine());
			int wheel[][]=new int[5][8];
			StringTokenizer st;
			for (int i = 1; i < 5; i++) {				
				st=new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < 8; j++) {
				wheel[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			for (int k = 0; k < K; k++) {
				st=new StringTokenizer(br.readLine()," ");
				int num = Integer.parseInt(st.nextToken());
				int lotate = Integer.parseInt(st.nextToken());
			}
		}
	}
}
