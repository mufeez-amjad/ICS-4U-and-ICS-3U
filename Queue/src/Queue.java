import java.util.Iterator;

class Queue
{
	private Node front;
	private Node rear;
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
	
	public Queue() {
        front = null;
        rear = null;
    }

	public void enqueue (int item)
	{
		Node temp = new Node(item, null);
		if (rear == null)
			//queue was empty
			front = rear = temp;
		else
			//add node at the rear of the queue
			rear = rear.link = temp;
	}
	
	public int dequeue()
	{
		if (rear == null){
			//queue was empty
			System.out.println("Queue is empty");
		}
		else{
			if (front == null){
				return -1;
			}
			int temp = front.info;
			front = front.link;
			return temp;
		}
		return -1;
	}
	
	public boolean isEmpty(){
		return rear == null || front == null;
	}
	
	public int peek(){
		if (rear == null){
			//queue was empty
			System.out.println("Queue is empty");
		}
		else
			return front.info;
		
		return -1;
	}
	
	public void printQueue(Queue q){
		for (Node temp = front; temp!=null; temp = temp.link)
			System.out.println(temp.info);

	}
	
	
}