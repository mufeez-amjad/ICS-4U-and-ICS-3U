
public class Test {
	public static void main(String[] args){
		Stack s = new Stack();
		for (int i = 0; i <= 10; i++){
			s.push(i);
		}
		s.printStack();
		for (int i = 0; i <= 10; i++){
			s.pop();
		}
		System.out.println(s.ifEmpty());
	}
}
