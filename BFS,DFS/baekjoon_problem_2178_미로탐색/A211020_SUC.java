import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A211020 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] array = new int[n+2][m+2];
        boolean[][] visited = new boolean[n+2][m+2];
        Queue<Position> queue = new LinkedList<>(); 

        for(int i = 1;i<=n;i++){
            String tmp = sc.next();
            for(int j = 1;j<=m;j++){
            	array[i][j] = tmp.charAt(j-1) - '0';
            }
        }
		
//		for(int i=0; i<n+2; i++){
//			 for(int j=0; j<m+2; j++) { 
//				 System.out.print(array[i][j]); 
//			 }
//			 System.out.println(""); 
//		}

		Position position = new Position(1, 1);
		queue.add(position);
		bfs(visited, queue, array);
		
//		for(int i=0; i<n+2; i++){
//			 for(int j=0; j<m+2; j++) { 
//				 System.out.print(array[i][j]);
//				 System.out.print("   |   "); 
//			 }
//			 System.out.println(""); 
//		}
		
		System.out.print(array[n][m]);
		
	}
	
	public static void bfs(boolean[][] visited, Queue<Position> queue, int [][] array) {
		int[] search = {0,-1,0,1,1,0,-1,0}; 
		visited[1][1] = true;
		
		while(!queue.isEmpty()) {
			Position target = queue.poll();
			
			for(int i=0; i<search.length; i=i+2) {
				int searchX = target.getX() + search[i];
				int searchY = target.getY() + search[i+1];
				
				if(!visited[searchX][searchY] && array[searchX][searchY] != 0) {
					array[searchX][searchY] = array[searchX][searchY] + array[target.getX()][target.getY()];
					Position position = new Position(searchX, searchY);
					visited[searchX][searchY] = true;
					queue.offer(position);

					//아래와 같이 조건을 주면 틀림...
//					if(searchX == destinationX & searchY== destinationY) {
//						queue.clear();
//					}else {
//						Position position = new Position(searchX, searchY);
//						visited[searchX][searchY] = true;
//						queue.offer(position);
//					}
				}
			}
		}
		
	}
	

	public static class Position{
		int x;
		int y;
		
		public Position(int x, int y) {
			this.x=x;
			this.y=y;
		}
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
	}

}

