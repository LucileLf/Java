import java.util.LinkedList;

public class MazeSolver {
	static Maze m = new Maze(); //static in order to be accessed in the main without creating an instance
	
	public static void main(String[] args) {
		
		int[][] maze = { 
				{2, 1, 1, 1},
				{0, 0, 1, 1},
				{0, 0, 0, 1}
		};
		m.maze = maze;
		m.start = new Position(0, 3); //starting position
		m.path = new LinkedList<Position>();  //storing the visited path
				
		if (solveMaze(m.start)) {
			System.out.println("You won!!");
		} else {
			System.out.println("No path...");
		}

	}
		
		private static boolean solveMaze(Position p) {
			m.path.push(p); //using a stack in order to be able to backtrack
			
			while(true) {
				//getting the most recent position
				int y = m.path.peek().y;
				int x = m.path.peek().x;
				
				//changing each visited spot to a 0
				m.maze[y][x]  = 0;
					
						
			//going down	
			if (isValid(y+1, x)) {
				if(m.maze[y+1][x] == 2) { 		
					System.out.println("Moved down.");
					return true;
				} else if(m.maze[y+1][x] == 1) {
					System.out.println("Moved down");
					m.path.push(new Position(y+1, x)); //adding a position
					continue;
				}
			}
			
			//going left
			if (isValid(y, x-1)) {
				if(m.maze[y][x-1] == 2) { 		
					System.out.println("Moved left.");
					return true;
				} else if(m.maze[y][x-1] == 1) {
					System.out.println("Moved left");
					m.path.push(new Position(y, x-1)); //adding a position
					continue;
				}
			}
			
			//going up
			if (isValid(y-1, x)) {
				if(m.maze[y-1][x] == 2) { 		
					System.out.println("Moved up.");
					return true;
				} else if(m.maze[y-1][x] == 1) {
					System.out.println("Moved up");
					m.path.push(new Position(y-1, x)); //adding a position
					continue;
				}
			}
			
			//going right
			if (isValid(y, x+1)) {
				if(m.maze[y][x+1] == 2) { 		
					System.out.println("Moved right.");
					return true;
				} else if(m.maze[y][x+1] == 1) {
					System.out.println("Moved right");
					m.path.push(new Position(y, x+1)); //adding a position
					continue;
				}
			}
				
			m.path.pop();//if unable to move in any direction, backtrack: remove current spot from stack
			System.out.println("Moved back!");
			if(m.path.size() <= 0) { //
				System.out.println("No path");
				return false;
			}
				
		}
		
	}

	public static boolean isValid(int y, int x) { //checking for outer bounds
		if(y < 0 || 
		   y >= m.maze.length ||
		   x < 0 ||
		   x >= m.maze[y].length //for x, need to check the length of the current row
		) {
			return false;
		}
		return true;
	}
	
}

//REFACTORING

/*
private static boolean solveMaze(Position p) {
	path.push(p); //using a stack in order to be able to backtrack
	
	while(true) {
		//getting the most recent position
		int y = path.peek().y;
		int x = path.peek().x;
		
		//changing each visited spot to a 0
		maze[y][x]  = 0;
		*/

/*
System.out.println("Moved down.");
if (move(y+1, x)) {
	return true;
} else {
	System.out.println("Moved left.");
	if (move(y, x-1)) {
		return true;
	} else {
		System.out.println("Moved up.");	
		if (move(y-1, x)) {
			return true;
		} else {
			System.out.println("Moved right.");	
			if (move(y, x+1)) {
				return true;
			} else {
				path.pop();//if unable to move in any direction, backtrack: remove current spot from stack
				System.out.println("Moved back!");
				if(path.size() <= 0) { //
					System.out.println("No path");
					return false;
				}
			}
		}
	}
} 
}
}
	
private static boolean move(int y, int x) {
if (isValid(y, x)) {
	if(maze[y][x] == 2) { 		
		return true;
	} else if(maze[y][x] == 1) {
		path.push(new Position(y, x)); //adding a position
		return false;
	}
}
return false;
}

public static boolean isValid(int y, int x) { //checking for outer bounds
if(y < 0 || 
   y >= maze.length ||
   x < 0 ||
   x >= maze[y].length //for x, need to check the length of the current row
) {
	return false;
}
return true;
}
*/
