import java.io.PrintStream;
import java.util.NoSuchElementException;

/**
 * Defines the methods for a FIFO queue that handles String items
 */
public interface StringQueue {

	/**
	 * @return true if the queue is empty
	 */
	public boolean isEmpty();

	/**
	 * insert a String item to the queue
	 */
	public void put(String item);

	/**
	 * remove and return the oldest item of the queue
	 * 
	 * @return oldest item of the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	public String get() throws NoSuchElementException;

	/**
	 * return without removing the oldest item of the queue
	 * 
	 * @return oldest item of the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	public String peek() throws NoSuchElementException;

	/**
	 * print the elements of the queue, starting from the oldest
	 * item, to the print stream given as argument. For example, to
	 * print the elements to the
	 * standard output, pass System.out as parameter. E.g.,
	 * printQueue(System.out);
	 */
	public void printQueue(PrintStream stream);

	/**
	 * return the size of the queue, 0 if it is empty
	 * 
	 * @return number of elements in the queue
	 */
	public int size();
}

class StringQueueImpl implements StringQueue {

	private String[] queue; // The string array that holds the queue
	/**
	 * queue's pointers
	 */
	private int head;
	private int tail;

	private static final int defaultSize = 2;
	private static final int growSize = 2;
	private int size = 0;

	// Initializing the queue pointers and array size
	public StringQueueImpl() {
		queue = new String[defaultSize];
		head = 0;
		tail = -1;

	}

	/*
	 * A method to get the position after the current value
	 * if next position overflows the queue length it returns 0
	 */
	private int positionAfter(int current) {
		return (current + 1) % queue.length;

	}

	// A method to autogrow the queue size
	private void growSize() {

		String[] newQueue = new String[queue.length + growSize];
		for (int i = 0; i < size; ++i) {
			newQueue[i] = queue[head];
			head = positionAfter(head);
		}
		queue = newQueue;
		head = 0;
		tail = size - 1;
	}

	@Override
	public boolean isEmpty() {

		return size() == 0;
	}

	@Override
	public void put(String item) {
		if (size == queue.length) {
			growSize();
		}
		tail = positionAfter(tail);
		queue[tail] = item;
		size += 1;

	}

	@Override
	public String get() throws NoSuchElementException {
		if (isEmpty())
			throw new NoSuchElementException();
		String element = queue[head];
		head = positionAfter(head);
		size -= 1;

		return element;
	}

	@Override
	public String peek() throws NoSuchElementException {
		if (isEmpty())
			throw new NoSuchElementException();

		return queue[head];
	}

	@Override
	public void printQueue(PrintStream stream) {
		stream = new PrintStream(System.out);
		for (int i = head; i <= tail; i++) {
			stream.print(queue[i]);
			stream.println();
		}

	}

	@Override
	public int size() {
		if (isEmpty())
			return 0;
		else
			return size;
	}

}