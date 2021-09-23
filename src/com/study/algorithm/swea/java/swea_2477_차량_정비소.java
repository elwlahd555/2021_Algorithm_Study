package com.study.algorithm.swea.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class swea_2477_차량_정비소 {
	public static class People {
		int num, time, in, final_A, final_B;

		public People(int num, int time, int in, int final_A, int final_B) {
			super();
			this.num = num;
			this.time = time;
			this.in = in;
			this.final_A = final_A;
			this.final_B = final_B;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int answer = 0;
			int arr_N[] = new int[N + 1];
			int arr_M[] = new int[M + 1];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr_N[i + 1] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				arr_M[i + 1] = Integer.parseInt(st.nextToken());
			}
			int person[] = new int[K];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < K; i++) {
				person[i] = Integer.parseInt(st.nextToken());
			}
			LinkedList<People> que = new LinkedList<People>();
			for (int i = 0; i < person.length; i++) {
				que.add(new People(i + 1, 0, person[i], 0, 0));
			}
			LinkedList<People> result = new LinkedList<People>();
			int result_size = que.size();
			LinkedList<People> list_N = new LinkedList<People>();
			LinkedList<People> list_M = new LinkedList<People>();
			LinkedList<People> wait = new LinkedList<People>();
			boolean check_N[] = new boolean[N + 1];
			boolean check_M[] = new boolean[M + 1];
			int tempsize = que.size();
			for (int i = 0; i < tempsize; i++) {
				People p = que.poll();
				if (p.in == 0 && list_N.size() < N) {
					for (int j = 1; j < check_N.length; j++) {
						if (!check_N[j]) {
							check_N[j] = true;
							p.time = arr_N[j];
							p.final_A = j;
							list_N.add(p);
							break;
						}
					}
				} else {
					que.add(p);
				}
			}
			while (result_size > result.size()) {
				int size = list_M.size();
				for (int i = 0; i < size; i++) {
					People p = list_M.poll();
					if (p.time > 0) {
						p.time--;
					}
					if (p.time == 0) {
						check_M[p.final_B] = false;
						result.add(p);
					} else {
						list_M.add(p);
					}
				}
				size = wait.size();
				for (int i = 0; i < size; i++) {
					People p = wait.poll();
					if (list_M.size() < M) {
						for (int j = 1; j < check_M.length; j++) {
							if (!check_M[j]) {
								check_M[j] = true;
								p.time = arr_M[j];
								p.final_B = j;
								list_M.add(p);
								break;
							}
						}
					} else {
						wait.add(p);
					}
				}

				size = list_N.size();
				for (int i = 0; i < size; i++) {
					People p = list_N.poll();
					if (p.time > 0) {
						p.time--;
					}
					if (p.time == 0 && list_M.size() < M) {
						check_N[p.final_A] = false;
						for (int j = 1; j < check_M.length; j++) {
							if (!check_M[j]) {
								check_M[j] = true;
								p.time = arr_M[j];
								p.final_B = j;
								list_M.add(p);
								break;
							}
						}
					} else if (p.time == 0) {
						check_N[p.final_A] = false;
						wait.add(p);
					} else {
						list_N.add(p);
					}
				}
				
				size = que.size();
				for (int i = 0; i < size; i++) {
					People p = que.poll();
					if (p.in > 0) {
						p.in--;
					}
					if (p.in == 0 && list_N.size() < N) {
						for (int j = 1; j < check_N.length; j++) {
							if (!check_N[j]) {
								check_N[j] = true;
								p.time = arr_N[j];
								p.final_A = j;
								list_N.add(p);
								break;
							}
						}
					} else {
						que.add(p);
					}
				}

			}
			int size = result.size();
			for (int i = 0; i < size; i++) {
				People p = result.poll();
				if (p.final_A == A && p.final_B == B) {
					answer += p.num;
				}
			}
			System.out.println("#" + t + " " + answer);
		}
	}
}
