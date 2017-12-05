
public class Test {
	public static void main(String[] args){
		 Queue q = new Queue();
		 for (int i = 0; i <= 10; i++){
			 q.enqueue(i);
		 }
		 for (int i = 0; i <= 10; i++){
			 System.out.println(q.dequeue());
		 }
		 System.out.println(q.isEmpty());
	}
}
