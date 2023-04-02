package KB3반_알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class KB3반_알고리즘2번_고동연 {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int n, m, a, b, novirus,maxVal;
	static int[][] arr;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m][n];
		visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(line.substring(j, j + 1));
			}
		}
		// 최초 감염자 좌표 (b-1,a-1)
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		a = a - 1;
		b = b - 1;
		BFS(b, a);
		
		maxVal = 0;
		novirus = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				maxVal = Math.max(maxVal, arr[i][j]);
				if (arr[i][j] == 1 && visited[i][j] != true)
					novirus++;
			}
		}
		System.out.println(maxVal + 2);
		System.out.println(novirus);
	}

	// BFS 정의
	private static void BFS(int b, int a) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { b, a });// 살펴볼 좌표 추가
		visited[b][a] = true;

		while (!q.isEmpty()) {// 큐에 값이 있는 동안 동작
			int now[] = q.poll();// 큐에서 맨앞 요소 삭제, 반환
			for (int k = 0; k < 4; k++) {// 네 방향의 좌표값을 확인
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];// 접근할 변수 값
				// 다음 좌표가 방문안한 좌표이고 0이 아니면
				if (x >= 0 && y >= 0 && x < m && y < n) {// 경계검사
					if (arr[x][y] != 0 && !visited[x][y]) {
						visited[x][y] = true;
						arr[x][y] = arr[now[0]][now[1]] + 1;// 시작 좌표에서 떨어져 있는 거리
						q.add(new int[] { x, y });
					}
				}
			}
		}
	}

}
