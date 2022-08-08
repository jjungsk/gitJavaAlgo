package online.day3_220808_LinkedList;

import java.lang.reflect.Array;

public class SsafyStack<E> implements IStack<E> {

	private Node<E> top; // not dummy
	
	@Override
	public void push(E data) { // 첫 노드 삽입 알고리즘
		// TODO Auto-generated method stub
		top = new Node<E>(data, top);
	}

	@Override
	public E pop() {
		if (isEmpty()) {
			System.out.println("공백스택이어서 작업이 불가");
			return null;
			
		}
		
		Node<E> popNode = top;
		top = popNode.link;
		popNode.link = null;
		
		return popNode.data;
	}

	@Override
	public E peek() {
		if (isEmpty()) {
			System.out.println("공백스택이어서 작업이 불가");
			return null;
			
		}
		return top.data;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return top == null;
	}

	@Override
	public int size() {
		int cnt = 0;
		for (Node<E> temp = top; temp != null; temp = temp.link) {
			++cnt;
		}
		
		return cnt;
	}

}
