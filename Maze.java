
//Ogaddinma Enwereji
//4-18-19
//Assignment No. 7

import java.util.*;
import java.awt.Point;
import java.util.LinkedList;

public class Maze {
	private InputGraphicMaze maze;
	private int R, C;
	// YOU'LL NEED TO ADD MORE CODE HERE!!!!!!!
	private boolean V[][]; //visited array

	public Maze() {
		// an R rows x C columns maze
		maze = new InputGraphicMaze();
		R = maze.Rows();
		C = maze.Cols();
		V=new boolean[R+1][C+1];
		for(int i=1; i<=R; i++)
			for(int j=1; j<=C; j++)
				V[i][j]=false;
		// YOU'LL NEED TO ADD MORE CODE HERE!!!!!!!
		// Path holds the cells of the path
		LinkedList<Point> Path = new LinkedList<Point>();
		// Create the path
		CreatePath(maze, 1, 1, R, C, Path);
		// show the path in the maze
		maze.showPath(Path);
	}

	// Creates the path through maze, starting at cell (srow, scol)
	// and ending at cell (erow and ecol), in L
	public boolean CreatePath(InputGraphicMaze maze, int srow, int scol, int erow, int ecol, LinkedList<Point> L)
    {
          //YOUR CODE FOR THE PATH GENERATION GOES HERE!!!!!!!
		int r=srow, c=scol, R=maze.Rows(), C=maze.Cols();
		boolean done=false; V[r][c]=true;
		L.add(new Point(r, c)); //add point to linkedlist
		
		if ((r==erow)&&(c==ecol)) { //if starting rows/columns equal ending rows/columns
			L.add(new Point (r, c)); //add final point to linkedlist
			done=true; //set 'done' to true
		}else{
			
			if ((r>1)&&!(V[r-1][c])&&(maze.can_go(r, c,'U'))) //condition for upper cells
			{
				V[r-1][c]=true; //set coordinate of visited array to true
				if(CreatePath(maze, r-1, c, R, C, L)) //re-call method
					return V[r-1][c]; //return boolean value
				}
			if ((c<C)&&!(V[r][c+1])&&(maze.can_go(r, c,'R'))) //condition for right cells
			{
				V[r][c+1]=true;
				if(CreatePath(maze, r, c+1, R, C, L))
					return V[r][c+1];
				}
			if ((r<R)&&!(V[r+1][c])&&(maze.can_go(r, c, 'D')) )//condition for lower cells
			{
				V[r+1][c]=true;
				if(CreatePath(maze, r+1, c, R, C, L))
					return V[r+1][c];
				}
			if ((c>1)&&!(V[r][c-1])&&(maze.can_go(r, c, 'L'))) //condition for left cells
			{
				V[r][c-1]=true;
				if(CreatePath(maze, r, c-1, R, C, L))
					return V[r][c-1];
				}
			}
		
		//if blocked, remove point from linkedlist
		L.remove(new Point(r, c));
		
		return done;
    }

	public static void main(String[] args) {
		new Maze();
	}
}