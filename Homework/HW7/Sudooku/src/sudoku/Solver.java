package sudoku;

import java.util.*;


public class Solver 
{
	private Grid						problem;
	private ArrayList<Grid>				solutions;
	
	public Solver(Grid problem)
	{
		this.problem = problem;
	}
	
	public void solve()
	{
		solutions = new ArrayList<>();
		solveRecurse(problem);
	}
	
		
	// standard backtracking recursive solver
	private void solveRecurse(Grid grid)
	{		
		Evaluation eval = evaluate(grid);
		
		if (eval == Evaluation.ABANDON)
		{
			// Abandon evaluation of this illegal board.
		}
		else if (eval == Evaluation.ACCEPT)
		{
			// A complete and legal solution. Add it to solutions.
			solutions.add(grid);
		}
		else
		{
			// Here if eval == Evaluation.CONTINUE. Generate all 9 possible next grids. Recursively 
			// call solveRecurse() on those grids.
			ArrayList<Grid> nextGrids = new ArrayList<Grid>(grid.next9Grids());
			for(int i = 0; i < 9; i++)
			{
				solveRecurse(nextGrids.get(i));
			}
		}
	}
	
	// Returns Evaluation.ABANDON if the grid is illegal. 
	// Returns ACCEPT if the grid is legal and complete.
	// Returns CONTINUE if the grid is legal and incomplete.
	public Evaluation evaluate(Grid grid)
	{		
		if(!grid.isLegal())
		{
			return Evaluation.ABANDON;
		}
		else if(!grid.isFull())
		{
			return Evaluation.CONTINUE;
		}
		else
		{
			return Evaluation.ACCEPT;
		}
	}

	// returns ArrayList of solutions to problem grid
	public ArrayList<Grid> getSolutions()
	{
		return solutions;
	}
	
	// tester method
	public static void main(String[] args)
	{
		Grid g = TestGridSupplier.getPuzzle3();												// or any other puzzle
		Solver solver = new Solver(g);
		System.out.println("Will solve:");
		System.out.println(g);																//prints given puzzle
		solver.solve();
		System.out.println("Solution:");
		System.out.println(solver.getSolutions());											//prints solution
		System.out.println("");
		System.out.println("Given solution:");
		System.out.println(TestGridSupplier.getSolution3());								//prints given solution
		System.out.println("Matches given solution? " + 
				solver.getSolutions().get(0).equals(TestGridSupplier.getSolution3()));		//prints true if my solution matches given solution,
																							//false, if not
	}
}