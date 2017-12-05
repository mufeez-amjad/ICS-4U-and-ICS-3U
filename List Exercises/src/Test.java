
public class Test {
	public static void main(String[] args){
		List l = new List();
		l.addAtFront(1);
		l.addAtFront(1);
		for (int i = 0; i <= 10; i++){
			l.addAtFront(10);
		}
		l.deleteAll(10);
		l.printList();
		//System.out.println(l.contains(0));
	}
}
