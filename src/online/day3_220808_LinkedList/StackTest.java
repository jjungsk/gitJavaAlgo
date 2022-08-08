package online.day3_220808_LinkedList;

public class StackTest {
	
	public static void main(String[] args) {
		IStack<String> stack = new SsafyStack<String>();
		
		System.out.println(stack.isEmpty() + "/" + stack.size());
		stack.push("비봉이");
		stack.push("대포");
		stack.push("금등이");
		
		System.out.println("peek item : " + stack.peek());
		System.out.println(stack.isEmpty() + "/" + stack.size());
		System.out.println("pop item : " + stack.pop());
		System.out.println("pop item : " + stack.pop());
		System.out.println(stack.isEmpty() + "/" + stack.size());
		System.out.println("pop item : " + stack.pop());
		System.out.println(stack.isEmpty() + "/" + stack.size());
		stack.pop();
		
	}

}
