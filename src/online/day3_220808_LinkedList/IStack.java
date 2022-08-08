package online.day3_220808_LinkedList;

public interface IStack<T> {
	
	void push(T t);
	T pop();
	T peek();
	boolean isEmpty();
	int size();

}

