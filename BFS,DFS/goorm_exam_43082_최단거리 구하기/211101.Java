import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		
		for(int i=0; i<N; i++){
			String input = br.readLine();	
			String[] split = input.split(" ");
			for(int j=0; j<N; j++){
				map[i][j] = Integer.parseInt(split[j]);
			}
		}
		
		//System.out.println(Arrays.deepToString(map));
		bfs(map, visited, N);
		System.exit(0); 
	}
	
	static void bfs(int[][] map, boolean[][] visited, int N){
		int[] moveX = {-1,0,1,0};  //위 오른쪽 아래 왼쪽
		int[] moveY = {0,1,0,-1};   //위 오른쪽 아래 왼쪽
		Queue<Position> queue = new LinkedList<>();
		
		Position position = new Position(0,0);
		visited[0][0] = true;
		queue.add(position);
		
		while(!queue.isEmpty()){
			Position target = queue.poll();
			
			for(int i=0; i<moveX.length; i++){
				int movingX = target.getX() + moveX[i];
				int movingY = target.getY() + moveY[i];
				if(movingX >=0 && movingX < N && movingY >=0 && movingY < N && !visited[movingX][movingY] && map[movingX][movingY] == 1 ){
					//System.out.println(movingX + "_" + movingY);
				
					map[movingX][movingY] = map[movingX][movingY] + map[target.getX()][target.getY()];
					if(movingX == N-1 && movingY == N-1) {
						System.out.println(map[N-1][N-1]);
						queue.clear();
						break;
					}else{
						visited[movingX][movingY] = true;
						queue.add(new Position(movingX, movingY));
					}
				}
			}
		}
	}
	
	public static class Position{
		int x;
		int y;
		
		public Position(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		int getX(){
			return this.x;
		}
		int getY(){
			return this.y;
		}
	}
}