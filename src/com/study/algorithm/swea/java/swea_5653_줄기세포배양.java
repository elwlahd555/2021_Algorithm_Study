package com.study.algorithm.swea.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class swea_5653_줄기세포배양 {
	private static class Point {
		int x, y, start, cell;

		public Point(int x, int y, int start, int cell) {
			super();
			this.x = x;
			this.y = y;
			this.start = start;
			this.cell = cell;
		}

	}

	private static int dx[] = { -1, 1, 0, 0 };
	private static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int answer = 0;
			LinkedList<Point> que = new LinkedList<Point>();
			HashSet<String> visited = new HashSet<String>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					int num = Integer.parseInt(st.nextToken());
					if (num == 0) {
						continue;
					}
					visited.add(String.valueOf(i) + String.valueOf(j));
					que.add(new Point(i, j, num, num));
				}
			}
			while (K > 0) {
				int size = que.size();
				HashSet<String> tempSet = new HashSet<String>();
				LinkedList<Point> tempQue = new LinkedList<Point>();
				for (int i = 0; i < size; i++) {
					Point p = que.poll();
					if (p.cell > 0) {
						p.cell--;
						que.add(p);
					} else if (p.cell == 0) {
						for (int k = 0; k < 4; k++) {
							int x = p.x + dx[k];
							int y = p.y + dy[k];
							String keys = String.valueOf(x) + String.valueOf(y);
							if (!visited.contains(keys)) {
								if (tempSet.contains(keys)) {
									for (int j = 0; j < tempQue.size(); j++) {
										if (tempQue.get(j).x == x && tempQue.get(j).y == y) {
											if (tempQue.get(j).start < p.start) {
												tempQue.get(j).start = p.start;
												tempQue.get(j).cell = p.start;
											}
											break;
										}
									}
								} else {
									tempSet.add(keys);
									tempQue.add(new Point(x, y, p.start, p.start));
								}
							}
						}
					}
				}
				for (Point point : tempQue) {
					que.add(point);
				}
				for (String s : tempSet) {
					visited.add(s);
				}
				K--;
			}
			answer = que.size();
			System.out.println("#" + t + " " + answer);
		}
	}
}
