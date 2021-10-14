package sudoku;

import java.util.*;


public class Grid 
{
	private int[][]						values;
	private int							gridLength;
	

	//
	// DON'T CHANGE THIS.
	//
	// Constructs a Grid instance from a string[] as provided by TestGridSupplier.
	// See TestGridSupplier for examples of input.
	// Dots in input strings represent 0s in values[][].
	//
	public Grid(String[] rows)
	{
		values = new int[9][9];
		for (int j=0; j<9; j++)
		{
			String row = rows[j];
			char[] charray = row.toCharArray();
			for (int i=0; i<9; i++)
			{
				char ch = charray[i];
				if (ch != '.')
					values[j][i] = ch - '0';
			}
		}
		gridLength = values.length;
	}
	
	
	//
	// DON'T CHANGE THIS.
	//
	public String toString()
	{
		String s = "";
		for (int j=0; j<9; j++)
		{
			for (int i=0; i<9; i++)
			{
				int n = values[j][i];
				if (n == 0)
					s += '.';
				else
					s += (char)('0' + n);
			}
			s += "\n";
		}
		return s;
	}


	//
	// DON'T CHANGE THIS.
	// Copy ctor. Duplicates its source. You'll call this 9 times in next9Grids.
	//
	Grid(Grid src)
	{
		values = new int[9][9];
		for (int j=0; j<9; j++)
			for (int i=0; i<9; i++)
				values[j][i] = src.values[j][i];
		gridLength = values.length;
	}
	
	
	//
	// COMPLETE THIS
	//
	//
	// Finds an empty member of values[][]. Returns an array list of 9 grids that look like the current grid,
	// except the empty member contains 1, 2, 3 .... 9. Returns null if the current grid is full. Don't change
	// this grid. Build 9 new grids.
	// 
	//
	// Example: if this grid = 1........
	//                         .........
	//                         .........
	//                         .........
	//                         .........
	//                         .........
	//                         .........
	//                         .........
	//                         .........
	//
	// Then the returned array list would contain:
	//
	// 11.......          12.......          13.......          14.......    and so on     19.......
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	//
	public ArrayList<Grid> next9Grids()
	{		
		if(this.isFull())
		{
			return null;
		}
		
		int xOfNextEmptyCell = 0;
		int yOfNextEmptyCell = 0;

		// Find x,y of an empty cell.
		for(int row = gridLength - 1; row > 0; row--)
		{
			for(int col = 0; col < values.length; col++)
			{
				if(values[row][col] == 0)				//current member is empty
				{
					xOfNextEmptyCell = row;
					yOfNextEmptyCell = col;
					break;
				}
			}
		}
		
		// Construct array list to contain 9 new grids.
		ArrayList<Grid> grids = new ArrayList<Grid>();

		// Create 9 new grids as described in the comments above. Add them to grids.
		for(int i = 1; i <= 9; i++)
		{
			Grid temp = new Grid(this);				//constructs temp Grid with same values
			temp.values[xOfNextEmptyCell][yOfNextEmptyCell] = i;
			sop(temp.toString());
			sop("");
			grids.add(temp);
		}
		return grids;
	}
	
	
	//
	// COMPLETE THIS
	//
	// Returns true if this grid is legal. A grid is legal if no row, column, or
	// 3x3 block contains a repeated 1, 2, 3, 4, 5, 6, 7, 8, or 9.
	//
	public boolean isLegal()
	{
		int[] listOfNum;

		// Checks every row. If an illegal row, return false.
		for(int row = 0; row < values.length; row++)
		{
			listOfNum = new int[9];
			for(int col = 0; col < values[row].length; col++)
			{
				listOfNum[col] = values[row][col];
				if(repeated(listOfNum))
				{
					return false;
				}
			}
		}

		// Checks every column. If an illegal column, return false.
		for(int row = 0; row < values.length; row++)
		{
			listOfNum = new int[9];
			for(int col = 0; col < values[row].length; col++)
			{
				listOfNum[col] = values[col][row];
				if(repeated(listOfNum))
				{
					return false;
				}
			}
		}
		
		// Check every block. If an illegal block, return false.
		for(int i = 0; i < values.length; i = i +3) 
		{
			listOfNum = new int[9];
			for(int j = 0; j < values[i].length; j = j + 3) 
			{
				int temp = 0;
				for(int row = i;row < i + 3; row++) 
				{
					for(int col = j;col < j + 3;col++) 
					{
						listOfNum[temp] = values[row][col];
						temp++;
					}
				}
				if(repeated(listOfNum)) 
				{
					return false;
				}
			}
		}

		// All rows/cols/blocks are legal.
		return true;
	}

	// Checks for any repeated number in the array.
	// @param input is the desired array to be checked for repeating numbers
	// @return true if there is a repeating number and false if there are no repeating numbers.
	public static boolean repeated(int[] input)
	{
		for(int i = 0; i < 8; i++)
		{
			int tempNum = input[i];
			for(int j = i + 1; j <= 8; j++)
			{
				if(tempNum == input[j] && tempNum != 0)
				{
					return true;
				}
			}
		}
		return false;
	}

	
	//
	// Returns true if every cell member of values[][] is a digit from 1-9.
	//
	public boolean isFull()
	{
		for(int i = 0; i < gridLength; i++)
		{
			for(int j = 0; j < gridLength; j++)
			{
				if(values[i][j] == 0)				//current member is empty
				{
					return false;
				}
			}
		}
		return true;
	}
	

	//
	// Returns true if x is a Grid and, for every (i,j), 
	// x.values[i][j] == this.values[i][j].
	//
	public boolean equals(Object x)
	{
		Grid that = (Grid)x;
		for(int i = 0; i < gridLength; i++)
		{
			for(int j = 0; j < gridLength; j++)
			{
				if(this.values[i][j] != that.values[i][j])				
				{
					return false;
				}
			}
		}
		return true;
	}
	
	static void sop(Object x)
	{
		System.out.println(x);
	}
	
	public static void main(String[] args)
	{
		Grid a = new Grid(TestGridSupplier.getPuzzle1());
		//Grid b = new Grid(TestGridSupplier.getReject4());
		sop(a.next9Grids());
	}	
}
