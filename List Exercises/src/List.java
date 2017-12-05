class List
{
	private Node head;

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

	public void deleteFirst()
	{
		if (head==null)
			System.out.println("List is empty");
		else if (head.link==null)
			head = null;
		else
			head = head.link;
	}

	public void deleteLast()
	{
		if (head==null)
			System.out.println("List is emplty");
		else if (head.link==null)
			head = null;
		else
		{
			for (Node temp = head; temp!=null; temp=temp.link)
			{
				if (temp.link.link==null)
					temp.link=null;
			}

		}
	}

	public void addAtRear(int item)
	{
		if (head==null)
			head = new Node(item,null);
		else
		{
			Node last = null;
			for (Node temp = head; temp!=null; temp=temp.link)
			{
				if (temp.link==null)
					last = temp;
			}
			last.link = new Node(item, null);
		}
	}



	public void addAtFront(int item)
	{
		head = new Node(item, head);
	}

	public void printList()
	{
		for (Node temp = head; temp!=null; temp = temp.link)
			System.out.println(temp.info);
	}

	public void insert (int item)
	{
		//Step 1:
		//find the correct location in the list for the new node
		Node current = head;
		Node previous = null;
		boolean located = false;
		while(!located && current!=null)
		{
			if (item < current.info)
				located = true;
			else
			{
				previous = current;
				current = current.link;
			}
		}
		//Step 2:
		//Create a new node containing the item and referring it to the correct location in the list
		Node newNode= new Node(item,current);
		if (current == head)
			head = newNode;
		else
			previous.link= newNode;
	}

	public void delete (int item)
	{
		//Step 1:
		//find the node to be deleted
		Node current = head;
		Node previous = null;
		boolean found = false;
		while(!found && current!=null)
		{
			if (current.info == item)
				found = true;
			else
			{
				previous = current;
				current = current.link;
			}
		}
		//Step 2:
		//Perform the deletion by changing the links
		if (found)
		{
			if (current == head)
				head = head.link;
			else 
				previous.link= current.link;
		}
	}
	
	public boolean contains (int item){
		Node current = head;
		while (current.info != item && current.link != null){
			if (current.link.info == item) return true;
			current = current.link;
		}
		return false;
	}
	
	public void deleteAll(int item){
		Node current = head;
		while (current.link != null){
			if (current.link.info == item){
				current.link = current.link.link;
			}
			else current = current.link;
		}
		
	}
}