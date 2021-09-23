package com.study.algorithm.swea.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class swea_2383_점심_식사시간 {
	private static class Point {
		int x, y, time, stair, length;

		public Point(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}

		public Point(int x, int y, int time, int stair, int length) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
			this.stair = stair;
			this.length = length;
		}

	}

	private static int arr[][];
	private static LinkedList<Point> person;
	private static Point stair[];
	private static int dt[];
	private static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			person = new LinkedList<Point>();
			stair = new Point[2];
			answer = Integer.MAX_VALUE;
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 1) {
						person.add(new Point(i, j, 0));
					} else if (arr[i][j] > 1) {
						stair[cnt] = new Point(i, j, arr[i][j]);
						cnt++;
					}
				}
			}
			dt = new int[person.size()];
			dfs(0);
			System.out.println("#" + t + " " + answer);
		}
	}

	private static void dfs(int cnt) {
		if (cnt == dt.length) {
			bfs();
			return;
		}
		dt[cnt] = 0;
		dfs(cnt + 1);
		dt[cnt] = 1;
		dfs(cnt + 1);
	}

	private static void bfs() {
		int temp_answer = 1;
		LinkedList<Point> temp_person = new LinkedList<Point>();
		for (int i = 0; i < person.size(); i++) {
			temp_person.add(new Point(person.get(i).x, person.get(i).y, person.get(i).time, dt[i],
					Math.abs(stair[dt[i]].x - person.get(i).x) + Math.abs(stair[dt[i]].y - person.get(i).y)));
		}
		LinkedList<Point> stair01 = new LinkedList<Point>();
		LinkedList<Point> stair02 = new LinkedList<Point>();
		while (true) {
			if (stair01.size() > 0 || stair02.size() > 0) {
				if (!stair01.isEmpty()) {
					int stair_size = stair01.size();
					for (int i = 0; i < stair_size; i++) {
						Point p = stair01.poll();
						p.time--;
						if (p.time > 0) {
							stair01.add(p);
						}
					}
				}
				if (!stair02.isEmpty()) {
					int stair_size = stair02.size();
					for (int i = 0; i < stair_size; i++) {
						Point p = stair02.poll();
						p.time--;
						if (p.time > 0) {
							stair02.add(p);
						}
					}
				}
			}
			int size = temp_person.size();
			for (int i = 0; i < size; i++) {
				Point p = temp_person.poll();
				if (p.length > 0) {
					p.length--;
				}
				if (p.length > 0) {
					temp_person.add(p);
				} else if (p.length == 0) {
					if (p.stair == 0) {
						if (stair01.size() < 3) {
							p.time = stair[p.stair].time;
							stair01.add(p);
						} else {
							temp_person.add(p);
						}
					} else if (p.stair == 1) {
						if (stair02.size() < 3) {
							p.time = stair[p.stair].time;
							stair02.add(p);
						} else {
							temp_person.add(p);
						}
					}
				}
			}
			temp_answer++;
			if (temp_person.isEmpty() && stair01.isEmpty() && stair02.isEmpty()) {
				break;
			}
		}
		answer = Math.min(temp_answer, answer);
	}
}
