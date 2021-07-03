package queue_singlelinkedlist;

import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		super();
		last = null;
		size = 0;
	}
	//last.next = first
	
	/**
	* Appends the specified queue to this queue
	* post: all elements from the specified queue are appended
	* to this queue. The specified queue (q) is empty after the call.
	* @param q the queue to append
	* @throws IllegalArgumentException if this queue and q are identical
	*/

	

	/**
	 * Inserts the specified element into this queue, if possible post: The
	 * specified element is added to the rear of this queue
	 * 
	 * @param e the element to insert
	 * @return true if it was possible to add the element to this queue, else false
	 */
	public boolean offer(E e) {
		QueueNode<E> temp = new QueueNode<E>(e); 
		
		if(last == null) {
			last = temp;
			temp.next = temp; 
		} else {
			temp.next = last.next;
			last.next = temp;
			last = temp; 
		}
		size++;
		
		return true;

	}

	/**
	 * Returns the number of elements in this queue
	 * 
	 * @return the number of elements in this queue
	 */
	public int size() {
		return size;
	}

	/**
	 * Retrieves, but does not remove, the head of this queue, returning null if
	 * this queue is empty
	 * 
	 * @return the head element of this queue, or null if this queue is empty
	 */
	public E peek() {
		if(last == null) {
			return null;
		}
		else { 
			return last.next.element;
		}
	}

	/**
	 * Retrieves and removes the head of this queue, or null if this queue is empty.
	 * post: the head of the queue is removed if it was not empty
	 * 
	 * @return the head of this queue, or null if the queue is empty
	 */
	public E poll() {
		if (last==null) {
			return null;
		} else {
			QueueNode<E> temp = last.next;
			last.next = temp.next;
			size--;
			return temp.element;
		}
	}

	/**
	 * Returns an iterator over the elements in this queue
	 * 
	 * @return an iterator over the elements in this queue
	 */
	

	private class QueueIterator implements Iterator<E> {

		private QueueNode<E> pos;

		/* Konstruktor */
		private QueueIterator() {

			// Om last ej finns, pos = null
			if (last == null) {
				pos = null;
			} else {

				pos = last.next;
			}
		}

		// Om det finns fler element i iterationen
		public boolean hasNext() {
			return pos != null;
		}

		public E next() {
			if (hasNext()) {
				E temp = pos.element;
				pos = pos.next;
				if (pos.equals(last.next)) {
					pos = null;
				}
				return temp;
			}
			throw new NoSuchElementException();

		}
	}
	public void append(FifoQueue<E> q) {
		if(q==null) {
			throw new  IllegalArgumentException();

		}
		if(this.last != null && this.last == q.last ) {
			throw new  IllegalArgumentException();

		}
		if(q.last == null) {
			return;
		}
		if(this.last == null) {
			last = q.last;
			size = size + q.size;
		}
		else {
			QueueNode<E> T = last.next;
			last.next = q.last.next;
			q.last.next = T;
			last = q.last;
			size = size + q.size;
		}
		q.last = null;
		q.size = 0;
	}
	
	public Iterator<E> iterator() {
		return new QueueIterator();
	}

	private static class QueueNode<E> {
		E element; // refererar till elementet
		QueueNode<E> next; // refererar till efterföljande nod

		private QueueNode(E x) {
			element = x;
			next = null;
		}
	}

}
