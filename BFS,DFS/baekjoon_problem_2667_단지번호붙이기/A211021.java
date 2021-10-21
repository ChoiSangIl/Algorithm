import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A211021 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map = new int[n][n];
		boolean[][] visited = new boolean[n][n];
		Queue<Position> q =  new LinkedList<>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for(int i=0; i<n;i ++) {
			String tmp = sc.next();
			for(int j=0; j<n; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}
		
		for(int i=0; i<n;i ++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					Position po = new Position(i, j);
					q.add(po);
					result.add(bfs(map, visited, q));
				}
			}
		}
		
		System.out.println(result.size());
		Collections.sort(result);
		for(int i:result) {
			System.out.println(i);
		}
		
		
	}
	
	public static int bfs(int[][] map, boolean[][] visited, Queue<Position> q) {
		int[] searchX = {0,1,0, -1};
		int[] searchY = {1,0,-1, 0};
		int result = 0;
		
		while(!q.isEmpty()) {
			Position po = q.remove();
			visited[po.x][po.y] = true;
			result ++;
			
			for(int i=0; i<4; i ++) {
				Position target = new Position(po.x, po.y);
				target.x = target.x + searchX[i];
				target.y = target.y + searchY[i];
				
				if(target.x >= 0 && target.y >= 0 && target.x < map.length && target.y < map.length ) {
					if(map[target.x][target.y] ==1 && !visited[target.x][target.y]) {
						Position targetPosition = new Position(target.x, target.y);
						q.add(targetPosition);
						visited[target.x][target.y] = true;
					}
				}
				
			}
		}
		
		return result;
	}
	
    public static class Position{
    	int x;
    	int y;
    	
    	public Position(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    	
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
    	
    	
    }
}
