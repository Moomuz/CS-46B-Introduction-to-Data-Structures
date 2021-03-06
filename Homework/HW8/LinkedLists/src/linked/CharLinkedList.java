package linked;

import java.util.*;


public class CharLinkedList 
{
	private CharNode		head;	// Empty if head and
	private CharNode		tail;	// tail are null
	
	
	public CharLinkedList()		{ }
	
	
	public CharLinkedList(String s)
	{
		for (int i=s.length()-1; i>=0; i--)
			insertAtHead(s.charAt(i));
	}
	
	
	public void insertAtHead(char ch)
	{
		assert hasIntegrity();		// Precondition
		
		CharNode node = new CharNode(ch);
		node.setNext(head);
		head = node;
		if (tail == null)
			tail = node;			// Corner case: inserting into empty node
		
		assert hasIntegrity();		// Postcondition
	}
	
	
	public String toString()
	{
		String s = "";
		CharNode node = head;
		while (node != null)
		{
			s += node.getData();
			node = node.getNext();
		}
		return s;
	}
	
	
	//
	// Returns true if this list has emptiness integrity, has tail integrity, has no loops,  
	// and tail is reachable from head.
	//
	// Caution: this checks for most but not all common integrity problems. 
	//
	boolean hasIntegrity()
	{
		// Check emptiness. If either head or tail is null, the other must
		// also be null. Different logic from what you saw in lecture. Returns
		// immediately if this list is empty.
		if (head == null  ||  tail == null)
			return head == null  &&  tail == null;
		
		// Check tail integrity (tail.next must be null).
		if (tail.getNext() != null)
			return false;
		
		// Check for loops.
		Set<CharNode> visitedNodes = new HashSet<>();
		CharNode node = head;
		while (node != null)
		{
			if (visitedNodes.contains(node))
				return false;		// Current node has been visited before, we must have a loop
			visitedNodes.add(node); // First visit to this node
			node = node.getNext();
		}
		
		// Make sure tail is reachable from head.
		node = head;
		while (node != null && node != tail)
			node = node.getNext();
		return node == tail;
	}
	
	public CharNode find(char ch)
	{	
		// Check if list is empty
		if(head == null && tail == null) 
		{
			return null;
		}
		
		// Searches through list to find node containing char ch
		CharNode node = head;
		while(node != null)
		{
			if(node.getData() == ch)
			{
				return node;
			}
			node = node.getNext();
		}
		return null;			// Has gone through entire list and did not find ch
	}
	
	public void duplicate(char ch)
	{
		/*assert hasIntegrity();	// Precondition
		
		// Illegal Arg Case
		if(this.find(ch) == null)
		{
			throw new IllegalArgumentException("Node with wanted char not found.");
		}
		
		// Tail Case
		if(this.find(ch) == tail)
		{
			CharNode n = this.find(ch);
			CharNode n1 = new CharNode(ch);
			n.setNext(n1);
			tail = n1;
		}
		
		// Vanilla + Head Case
		else if(this.find(ch) != null)
		{
			CharNode n = this.find(ch);
			CharNode n1 = new CharNode(ch);
			n1.setNext(n.getNext());
			n.setNext(n1);
		}
		
		assert hasIntegrity();	// Postcondition*/
		
		// USE VARIABLES WHEN POSSIBLE**
		
		assert hasIntegrity();	// Precondition
		
		CharNode target = this.find(ch);
		
		// Illegal Arg Case
		if(target == null)
		{
			throw new IllegalArgumentException("Node with wanted char not found.");
		}
		
		CharNode n = this.find(ch);
		CharNode n1 = new CharNode(ch);
		n.setNext(n1);
		
		if(target == tail)
		{
			tail = target;
		}
		
		assert hasIntegrity();	// Postcondition
	}
}
