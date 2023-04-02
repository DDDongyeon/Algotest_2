package KB3반_알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class KB3반_알고리즘3번_고동연 {
	static int[] dr= {-1,0,1};
	static int dc= 1;
	static String[][] map;
	static int r,c;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		map=new String[r][c];
		visited=new boolean[r][c];
		for (int i = 0; i < r; i++) {
			st=new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for (int j = 0; j < c; j++) {
				map[i][j] =line.substring(j, j + 1);
			}
		}
		System.out.println(map[0][1]);
		for (int i = 0; i < r; i++) {
			BFS(i,0);
		}
		int count=0;
		for (int i = 0; i < r; i++) {
			char object='.';
			System.out.println(map[c-1][i]);
			if(map[c-1][i].equals(object)) {
				count++;
			}
		}
		
		System.out.println(count);
	}
	private static void BFS(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { i, j });// 살펴볼 좌표 추가
		visited[i][j] = true;

		while (!q.isEmpty()) {// 큐에 값이 있는 동안 동작
			int now[] = q.poll();// 큐에서 맨앞 요소 삭제, 반환
			for (int k = 0; k < 3; k++) {// 네 방향의 좌표값을 확인
				int x = now[0] + dr[k];
				int y = now[1] + dc;// 접근할 변수 값
				// 다음 좌표가 방문안한 좌표이고 0이 아니면
				if (x >= 0 && y >= 0 && x < r && y < c) {// 경계검사
					char anObject = '.';
					if (map[x][y].equals(anObject) && !visited[x][y]) {
						visited[x][y] = true;
						map[x][y] = map[now[0]][now[1]] + 1;// 시작 좌표에서 떨어져 있는 거리
						q.add(new int[] { x, y });
					}
				}
			}
		}
	}

}
