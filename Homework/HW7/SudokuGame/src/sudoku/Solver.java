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
	
		
	// 
	// FINISH THIS.
	//
	// Standard backtracking recursive solver.
	//
	private void solveRecurse(Grid grid)
	{		
		Evaluation eval = evaluate(grid);
		
		if (eval == Evaluation.ABANDON)
		{
			//return;
		}
		else if (eval == Evaluation.ACCEPT)
		{
			solutions.add(grid);
		}
		else
		{
			assert eval == Evaluation.CONTINUE;
			ArrayList<Grid> temp = grid.next9Grids();
			for(int i = 0; i < 9; i++)
			{
				solveRecurse(temp.get(i));
			}
		}
	}
	
	//
	// Returns Evaluation.ABANDON if the grid is illegal. 
	// Returns ACCEPT if the grid is legal and complete.
	// Returns CONTINUE if the grid is legal and incomplete.
	//
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
		else //if(grid.isFull() && grid.isLegal())
		{
			return Evaluation.ACCEPT;
		}
	}

	
	public ArrayList<Grid> getSolutions()
	{
		return solutions;
	}
	
	
	public static void main(String[] args)
	{
		/*Grid g = TestGridSupplier.getPuzzle1();		// or any other puzzle
		Solver solver = new Solver(g);		
		System.out.println("Will solve");
		System.out.println(solver.problem);
		solver.solve();
		System.out.println("");
		System.out.println("Solutions:");
		for(int i = 0; i < 5; i++)
		{
			System.out.println(solver.getSolutions().get(i));
		}*/
		Grid g = TestGridSupplier.getPuzzle1();		// or any other puzzle
		Solver solver = new Solver(g);
		System.out.println("Will solve\n" + g);
		solver.solve();
		System.out.println(solver.getSolutions());
		System.out.println(TestGridSupplier.getSolution3());
		System.out.println(solver.getSolutions());
		
		// Print out your solution, or test if it equals() the solution in TestGridSupplier.
	}
}
