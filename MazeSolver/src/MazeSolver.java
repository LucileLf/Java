import java.util.LinkedList;

public class MazeSolver {
	static int[][] maze = { //static in order to be accessed in the main without creating an instance
		{2, 0, 1, 1},
		{1, 1, 0, 1},
		{0, 1, 1, 1}
	};
	//0: wall	1:path	2:destination
	
	static LinkedList <Position> path = new LinkedList<Position>();
	
	public static void main(String[] args) {
		Position p = new Position(3, 0); //starting position
		path.push(p); //using a stack in order to be able to backtrack
	
	
	//maze[path.peek().y][path.peek().x] //getting the most recent position
			System.out.println(maze[path.peek().y][path.peek().x]);	
			//when getting to a cul-de-sac, changing the spot to a 0
	 
	};
}