import java.util.LinkedList;

public class MazeSolver {
	static int[][] maze = { //static in order to be accessed in the main without creating an instance
		{2, 0, 1, 1},
		{1, 1, 1, 0},
		{0, 0, 0, 1}
	};
	//0: wall	1:path	2:destination
	
	static LinkedList <Position> path = new LinkedList<Position>(); //storing the visited path
	
	public static void main(String[] args) {
		Position p = new Position(0, 3); //starting position
		path.push(p); //using a stack in order to be able to backtrack
	
		while(true) {
			//getting the most recent position
			int y = path.peek().y;
			int x = path.peek().x;
			
			//changing each visited spot to a 0
			maze[y][x]  = 0;
			
			
			//going down
			if(maze[y+1][x] == 2) { 		
				System.out.println("Moved down. You won!!");
				return;
			} else if(maze[y+1][x] == 1) {
				System.out.println("Moved down");
				path.push(new Position(y+1, x)); //adding a position
				continue;
			}
			
			//going left
			if(maze[y][x-1] == 2) { 		
				System.out.println("Moved left. You won!!");
				return;
			} else if(maze[y][x-1] == 1) {
				System.out.println("Moved left");
				path.push(new Position(y, x-1)); //adding a position
				continue;
			}
			
			//going up
			if(maze[y-1][x] == 2) { 		
				System.out.println("Moved up. You won!!");
				return;
			} else if(maze[y-1][x] == 1) {
				System.out.println("Moved up");
				path.push(new Position(y-1, x)); //adding a position
				continue;
			}
			
			//going right
			if(maze[y][x+1] == 2) { 		
				System.out.println("Moved right. You won!!");
				return;
			} else if(maze[y][x+1] == 1) {
				System.out.println("Moved right");
				path.push(new Position(y, x+1)); //adding a position
				continue;
			}
		}

		
	
	
	};
	
	
}