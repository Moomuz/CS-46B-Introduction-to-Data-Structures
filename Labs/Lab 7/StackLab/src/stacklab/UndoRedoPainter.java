package stacklab;

import java.util.*;


public class UndoRedoPainter extends Painter
{
	public UndoRedoPainter()
	{
		super.setUndoButtonEnabled(false);
		super.setRedoButtonEnabled(false);
	}
	
	// Called when the user pushes the Undo button.
	void undo()
	{
		if(super.getHistory().size() <= 0) {
			super.setUndoButtonEnabled(false);
			return;
		}
		Circle undoCircle = super.getHistory().pop();	//gets last circle out of stack
		super.getUndoHistory().push(undoCircle);		//puts circle into undo stack
		super.repaint();
	}


	// Called when the user pushes the Redo button.
	void redo()
	{
		if(super.getUndoHistory().size() <= 0) {
			super.setRedoButtonEnabled(false);
			return;
		}
		Circle redoCircle = super.getUndoHistory().pop();	//gets
		super.getHistory().push(redoCircle);
		super.repaint();
	}
	
	
	public static void main(String[] args)
	{
		new UndoRedoPainter().setVisible(true);
	}
}
