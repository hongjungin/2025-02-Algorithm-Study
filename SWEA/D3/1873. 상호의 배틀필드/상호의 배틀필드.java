import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, H, W, N, dir;
	static int tankX, tankY;
	static char[][] field;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static char[] command;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			field = new char[H][W];
			dir = 0;
			tankX = 0; tankY = 0;
			for (int i = 0; i < H; i++) {
				String line = br.readLine();
				for (int j = 0; j < W; j++) {
					field[i][j] = line.charAt(j);
					if (field[i][j] == '^') {
						dir = 0;
						tankX = i;
						tankY = j;
					} else if (field[i][j] == '>') {
						dir = 1;
						tankX = i;
						tankY = j;
					} else if (field[i][j] == 'v') {
						dir = 2;
						tankX = i;
						tankY = j;
					} else if (field[i][j] == '<') {
						dir = 3;
						tankX = i;
						tankY = j;
					}
				}
			} 
			
			N = Integer.parseInt(br.readLine());
			command = new char[N];
			String str = br.readLine();
			command = str.toCharArray();
			
//			for (char c : command) {
//				System.out.print(c + " ");
//			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			for (int i = 0; i < N; i++) {
				char c = command[i];
				if (c == 'U') {
					dir = 0;
					field[tankX][tankY] = '^';
					
					int nx = tankX + dx[dir];
					int ny = tankY + dy[dir];
					if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
					if (field[nx][ny] == '.') {
						field[nx][ny] = '^';
						field[tankX][tankY] = '.';
						tankX = nx; tankY = ny;
					}
				} else if (c == 'D') {
					dir = 2;
					field[tankX][tankY] = 'v';
					
					int nx = tankX + dx[dir];
					int ny = tankY + dy[dir];
					if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
					if (field[nx][ny] == '.') {
						field[nx][ny] = 'v';
						field[tankX][tankY] = '.';
						tankX = nx; tankY = ny;
					}
					
				} else if (c == 'L') {
					dir = 3;
					field[tankX][tankY] = '<';
					
					int nx = tankX + dx[dir];
					int ny = tankY + dy[dir];
					if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
					if (field[nx][ny] == '.') {
						field[nx][ny] = '<';
						field[tankX][tankY] = '.';
						tankX = nx; tankY = ny;
					}
					
				} else if (c == 'R') {
					dir = 1;
					field[tankX][tankY] = '>';
					
					int nx = tankX + dx[dir];
					int ny = tankY + dy[dir];
					if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
					if (field[nx][ny] == '.') {
						field[nx][ny] = '>';
						field[tankX][tankY] = '.';
						tankX = nx; tankY = ny;
					}
					
				} else {   // S일 떄
					int nx = tankX;
					int ny = tankY;
					while (true) {
					     nx += dx[dir];
					    ny += dy[dir];
					    if (nx < 0 || nx >= H || ny < 0 || ny >= W) break;
					    if (field[nx][ny] == '#') break;
					    if (field[nx][ny] == '*') {
					        field[nx][ny] = '.';
					        break;
					    }
					}

				}
			}
			for (int i = 0; i < H; i++) {
				sb.append(field[i]).append("\n");
			}
			System.out.print(sb);
		}
	}
 
}
