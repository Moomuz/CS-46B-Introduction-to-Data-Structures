package sudoku;

import java.util.*;


public class Grid 
{
	private int[][]						values;

	// Constructs a Grid instance from a string[] as provided by TestGridSupplier.
	// See TestGridSupplier for examples of input.
	// Dots in input strings represent 0s in values[][].
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
	}

	// shows grid as String representation
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

	// Copy ctor. Duplicates its source. You’ll call this 9 times in next9Grids.
	Grid(Grid src)
	{
		values = new int[9][9];
		for (int j=0; j<9; j++)
			for (int i=0; i<9; i++)
				values[j][i] = src.values[j][i];
	}

	// searches grid for first available empty spot (i.e., index has value 0)
	// creates ArrayList of Grid of 9 grids, each having a value 1 through 9 in empty spot
	public ArrayList<Grid> next9Grids()
	{		
		int xOfNextEmptyCell = -1;
		int yOfNextEmptyCell = -1;

		if(isFull())
		{
			return null;
		}
		else
		{
			// Find x,y of an empty cell.
			for(int row = 0; row < values.length; row++)
			{
				for(int col = 0; col < values[row].length; col++)
				{
					if(values[row][col] == 0)
					{
						xOfNextEmptyCell = col;
						yOfNextEmptyCell = row;
						break;

					}
				}
			}

			// Construct array list to contain 9 new grids.
			ArrayList<Grid> grids = new ArrayList<Grid>();

			// Create 9 new grids as described in the comments above. Add them to grids.
			for(int x = 1; x <= 9; x++)
			{
				Grid newGrid = new Grid(this);
				newGrid.values[yOfNextEmptyCell][xOfNextEmptyCell] = x;
				grids.add(newGrid);
			}
			return grids;
		}
	}

	// checks the board if there are any repeated numbers in each row, column, or 3x3 block.
	public boolean isLegal()
	{
		int[] tempValues;

		// Checks every row. If an illegal row, return false.
		for(int row = 0; row < values.length; row++)
		{
			tempValues = new int[9];
			for(int col = 0; col < values[row].length; col++)
			{
				tempValues[col] = values[row][col];
				if(isRepeated(tempValues))
				{
					return false;
				}
			}
		}

		// Checks every column. If an illegal column, return false.
		for(int row = 0; row < values.length; row++)
		{
			tempValues = new int[9];
			for(int col = 0; col < values[row].length; col++)
			{
				tempValues[col] = values[col][row];
				if(isRepeated(tempValues))
				{
					return false;
				}
			}
		}
		
		// Check every block. If an illegal block, return false.
		for(int i = 0; i < values.length; i = i +3) 
		{
			tempValues = new int[9];
			for(int j = 0; j < values[i].length; j = j + 3) 
			{
				int temp = 0;
				for(int row = i;row < i + 3; row++) 
				{
					for(int col = j;col < j + 3;col++) 
					{
						tempValues[temp] = values[row][col];
						temp++;
					}
				}
				if(isRepeated(tempValues)) 
				{
					return false;
				}
			}
		}

		// All rows/cols/blocks are legal.
		return true;
	}

	// checks for any repeated numbers in array
	public boolean isRepeated(int[] input)
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

	// checks if every index in grid has value 1 through 9
	// if contains 0, grid is not considered full
	public boolean isFull()
	{
		for(int row = 0; row < values.length; row++)
		{
			for(int col = 0; col < values[row].length; col++)
			{
				if(values[row][col] == 0)
				{
					return false;
				}
			}
		}
		return true;
	}

	// checks if two boards are deep equal
	public boolean equals(Object x)
	{
		Grid g = (Grid)x;
		for(int row = 0; row < values.length; row++)
		{
			for(int col  = 0; col < values[row].length; col++)
			{
				if(this.values[row][col] != g.values[row][col])
				{
					return false;
				}
			}
		}
		return true;
	}
}