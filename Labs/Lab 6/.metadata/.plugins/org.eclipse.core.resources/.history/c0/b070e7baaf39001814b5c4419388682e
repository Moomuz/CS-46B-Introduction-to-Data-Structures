package linked;


public class DNALinkedList 
{
	private Node<Character>			head;	// head.prev is always null
	private Node<Character>			tail;	// tail.next is always null
	
	
	public DNALinkedList(String s)
	{
		append(s);		
	}
	
	
	// Used by extraction methods. Not for public use.
	private DNALinkedList(Node<Character> head, Node<Character> tail)
	{ 
		this.head = head;
		head.setPrev(null);
		this.tail = tail;
		tail.setNext(null);
	}
	
	
	// Converts arg to nodes which are appended to end of this list.
	public void append(String s)
	{
		for (int i=0; i<s.length(); i++)
			append(s.charAt(i));
	}
	
	
	// Creates a node for ch and appends it to the linked list.
	// "Append" always means "at the end".
	public void append(char ch)
	{
		append(new Node<Character>(ch));
	}
	
	
	// Appends n to tail of this list.
	public void append(Node<Character> n)
	{
		// Corner case: empty list.
		if (tail == null)
		{
			n.setPrev(???);
			n.setNext(???);
			head = ???;
			tail = ???
		}
		
		// Vanilla case.
		else
		{
			tail.setNext(???);
			n.setPrev(???);
			tail = ???;
		}
	}
	
	
	public String toString()
	{
		String s = "DNALinkedList: ";
		if (head == null)
			s += "Empty";
		else
		{
			Node<Character> n = head;
			while (n != null)
			{
				s += n.getData();
				n = n.getNext();
			}
		}
		return s;
	}
	
	
	// Returns true if the node starting at startNode matches the target string.
	private boolean matches(Node<Character> startNode, String target)
	{
	

		
	}
	
	
	// If this list contains a chain of nodes whose data is the target, returns
	// the nodes at the start of that chain. If the target appears multiple times
	// in this list, returns the first occurrence. If the target is not in this list,
	// returns null.
	public Node<Character> find(String target)
	{
		// Hint: call matches(). A lot.

	}
	
	
	// Simple algorithm that assumes no corner cases: both args are in the list,
	// firstExtractedNode is not the head, and lastExtractedNode is not the tail.
	// Usually this is bad linked practice, but the ends of DNA molecules aren't
	// involved in life processes, don't have transposons, and don't need to be
	// handled as corner cases.
	public DNALinkedList extract(Node<Character> firstExtractedNode, Node<Character> lastExtractedNode)
	{
		// Find nodes just before and just after the chain to be extracted. Assume these
		// aren't null.
		Node<Character> beforeFirst = firstExtractedNode.getPrev();
		Node<Character> afterLast = lastExtractedNode.getNext();
		
		// Connect beforeFirst to afterLast.
		beforeFirst.setNext(???);
		afterLast.setPrev(???);
		
		// Return a DNALinkedList containing the extracted chain.
		return new DNALinkedList(???, ???);
	}

	
	// Reverses the order of the nodes.
	public void reverse()
	{
		// Swap next and prev of every node. Caution: in your loop, you won't be able
		// to advance n by setting n = n.next(). Why? How should you advance n?
		Node<Character> n = head;
		while (n != null)
		{
			???
		    ???
		}
		
		// Swap head and tail.
		Node<Character> temp = head;
		head = tail;
		tail = temp;
	}
	
	
	// Inserts insertMe into this list, at the node before insertionPoint. Assumes
	// insertionPoint is not the head or tail. 
	public void insert(DNALinkedList insertMe, Node<Character> insertionPoint)
	{
		// Find node immediately before insertion point.
		Node<Character> beforeInsertionPoint = ???;
		
		// Connect node immediately before insertion point to head of insertMe.
		beforeInsertionPoint.setNext(???);
		insertMe.head.setPrev(???);
		
		// Connect tail of insertMe to insertionPoint node.
		insertMe.tail.setNext(???);
		insertionPoint.setPrev(???);
	}
	

	// Removes sequence matching transposon, reverses it, and inserts it back into
	// this list immediately before target. Throws IllegalArgumentException if
	// can't find transposon or target.
	public void transpose(String transposon, String target)
	{
		// Find starting node of transposon.
		Node<Character> firstNodeOfTransposon = ???;
		if (firstNodeOfTransposon == null)
			???
		
		// Find starting node of target.
		Node<Character> firstNodeOfTarget = ???
		if (firstNodeOfTarget == null)
			???
		
		// Find last node of transposon. You'll need several lines. Set a variable to the first node
		// of the transposon, then do a loop where for every char in the transposon, you set the variable
		// to its "next".
		Node<Character> lastNodeOfTransposon = 
				
		// Extract the transposon.
		DNALinkedList transposonList = ???
		
		// Reverse the transposon.
		transposonList.reverse();
		
		// Insert immediately before target.
		insert(???, ???);
	}
		
	
	public static void main(String[] args) 
	{
		String chromosome = ???;
		DNALinkedList list = new DNALinkedList(chromosome);
		System.out.println("original: " + list);
		String transposon = ???;
		String target = ???
		list.transpose(transposon, target);
		sop("transposed: " + list);
	}
}
