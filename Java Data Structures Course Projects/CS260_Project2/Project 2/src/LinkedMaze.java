//Project 2, Traversing a linked maze
//Student: Garrett Leckrone
//Class: CS260
//Description:
//The class LinkedMaze holds the main method that the program runs from.
//The program begins by creating the maze and printing it to the console
//The program then finds the shortest path and returns if the maze can be traversed.
//If the maze can be traversed, a list of tiles is printed that sequentially path through the maze.
//Resources: http://www.dsalgo.com/

//Imports
import java.util.LinkedList;
import java.util.List;

//Main method inside of the LinkedMaze class
public class LinkedMaze
{
 public static void main(String[] args)
 {
  boolean[][] maze = new boolean[10][10];
  makeRandomMaze(maze);
  List path = findShortestPath(maze);
  if (path == null)
  {
   System.out.println("No path possible");
   return;
  }
  for (Object cell: path)
   System.out.print(cell + ",");
 }

//Constructor class that will define a cell. 
//A cell has two integer values, rows and columns.
private static class Cell
 {
  public int row;
  public int col;
//If the cell has a predetermined number of rows and columns
public Cell(int row, int column)
  {
   this.row = row;
   this.col = column;
  }

//Equals method, compares the object in the cell to the parameter given
public boolean equals(Object obj)
{
 if (this == obj)
  return true;
 if ((obj == null) || (obj.getClass() != this.getClass()))
  return false;
 Cell cell = (Cell) obj;
 if (row == cell.row && col == cell.col)
  return true;
 return false;
}


public String toString()
{
 return "(" + row + "," + col + ")";
}
}


private static List findShortestPath(boolean[][] maze)
{
	  int[][] theMatrix = new int[maze.length][maze[0].length];
	  for (int i = 0; i < maze.length; ++i)
	   for (int j = 0; j < maze[0].length; ++j)
	   {
	    theMatrix[i][j] = maze[i][j] == true ? -1 : 0;
	   }
	  //Create a new cell queue and initialize
	  LinkedList < Cell > cellQueue = new LinkedList < Cell >();
	  Cell start = new Cell(0, 0);
	  Cell end = new Cell(maze.length - 1, maze[0].length - 1);
	  cellQueue.add(start);
	  theMatrix[start.row][start.col] = 1;
	 
	  while (!cellQueue.isEmpty())
	  {
	   Cell cell = cellQueue.poll();
	   if (cell == end)
	    break;
	   int level = theMatrix[cell.row][cell.col];
	   Cell[] nextCells = new Cell[4];
	   nextCells[3] = new Cell(cell.row, cell.col - 1);
	   nextCells[2] = new Cell(cell.row - 1, cell.col);
	   nextCells[1] = new Cell(cell.row, cell.col + 1);
	   nextCells[0] = new Cell(cell.row + 1, cell.col);

	   for (Cell nextCell : nextCells)
	   {
	    if (nextCell.row < 0 || nextCell.col < 0)
	     continue;
	    if (nextCell.row == maze.length
	      || nextCell.col == maze[0].length)
	     continue;
	    if (theMatrix[nextCell.row][nextCell.col] == 0)
	    {
	     cellQueue.add(nextCell);
	     theMatrix[nextCell.row][nextCell.col] = level + 1;
	    }
	   }
	  }
	  
	  if (theMatrix[end.row][end.col] == 0)
	   return null;
	  LinkedList < Cell > path = new LinkedList < Cell >();
	  Cell cell = end;
	  while (!cell.equals(start))
	  {
	   path.push(cell);
	   int level = theMatrix[cell.row][cell.col];
	   Cell[] nextCells = new Cell[4];
	   nextCells[0] = new Cell(cell.row + 1, cell.col);
	   nextCells[1] = new Cell(cell.row, cell.col + 1);
	   nextCells[2] = new Cell(cell.row - 1, cell.col);
	   nextCells[3] = new Cell(cell.row, cell.col - 1);
	   for (Cell nextCell : nextCells)
	   {
	    if (nextCell.row < 0 || nextCell.col < 0)
	     continue;
	    if (nextCell.row == maze.length
	      || nextCell.col == maze[0].length)
	     continue;
	    if (theMatrix[nextCell.row][nextCell.col] == level - 1)
	    {
	     cell = nextCell;
	     break;
	    }
	   }
	  }
	  return path;
	 }

//A method that formats printing the maze to console.
 private static void printMaze(boolean[][] maze)
 {
  for (int i = 0; i < maze.length; ++i)
  {
   for (int j = 0; j < maze[i].length; ++j)
   {
    if (maze[i][j])
     System.out.print("#|");
    else
     System.out.print("_|");
   }
   System.out.println();
  }
 }
//Populates a random maze
 private static void makeRandomMaze(boolean[][] maze)
 {
  for (int i = 0; i < maze.length; ++i)
  {
   for (int j = 0; j < maze[0].length; ++j)
   {
    maze[i][j] = (int) (Math.random() * 3) == 1;
   }
  }
  maze[0][0] = false;
  maze[maze.length - 1][maze[0].length - 1] = false;

 }}
