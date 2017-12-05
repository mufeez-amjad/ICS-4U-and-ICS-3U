
class Stack
{
	private Node top;
	class Node
	{
		int info;
		Node link;
		Node (int i, Node n)
		{
			info = i;
			link = n;
		}
	}

	public void push (int item)
	{
		if (top == null)
			top = new Node(item, null);
		else
			top = new Node(item, top);
	}

	public int peek()
	{
		if (top == null)
			System.out.println("Stack is empty");
		else
			return top.info;
		return -1;
	}
	
	public int pop()
	{
		if (top == null)
			System.out.println("Stack is empty");
		else{
			int temp = top.info;
			top = top.link;
			return temp;
		}
		return -1;
	}
	
	public boolean ifEmpty(){
		return top == null;
	}
	
	public void printStack(){
		for (Node temp = top; temp!=null; temp = temp.link)
			System.out.println(temp.info);

	}
}