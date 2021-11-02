import java.io.*;
import java.util.*;
class Main {
	
	static int l;
	static int[] destination;
	static int[] start;
	static boolean[][] visited;
	static int[][] map;
	static Queue<int []> queue;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		l = Integer.parseInt(br.readLine());
		visited = new boolean[l][l];
	  map = new int[l][l];
		String input1 = br.readLine();
		String[] split1 = input1.split(" ");
		start = new int[2];
		start[0] = Integer.parseInt(split1[0]);
		start[1] = Integer.parseInt(split1[1]);
		String input2 = br.readLine();
		destination = new int[2];
		String[] split2 = input2.split(" ");
		destination[0] = Integer.parseInt(split2[0]);
		destination[1] = Integer.parseInt(split2[1]);
		queue = new LinkedList<int []>();
		queue.add(start);
		visited[start[0]][start[1]] = true;
		
		bfs();
		System.out.println(map[destination[0]][destination[1]]);
	}
	
	static void bfs(){
		int[] dx = {-2,-1, 1, 2, 2, 1, -1,-2};
		int[] dy = { 1, 2, 2, 1,-1, -2,-2,-1};
		
		while(!queue.isEmpty()){
			int[] target = queue.poll();
			for(int i=0; i<dx.length; i++){
				int targetX = target[0] + dx[i];
				int targetY = target[1] + dy[i];
				
				if(targetX>=0 &&targetX<l && targetY >=0 &&targetY<l && !visited[targetX][targetY]){
					visited[targetX][targetY] = true;
					queue.add(new int[] {targetX, targetY});
					map[targetX][targetY] = map[target[0]][target[1]] + 1;
					if(targetX==destination[0] && targetY==destination[1]){
						System.out.println(map[targetX][targetY]);
						queue.clear();
						break;
					}
				}
			}
		}
	}
}