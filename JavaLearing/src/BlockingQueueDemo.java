import java.util.LinkedList;
import java.util.List;

public class BlockingQueueDemo {
	public static void main(String[] args) {
		BlockingQueueDemo demo = new BlockingQueueDemo(10);
		try {
			demo.enqueue(1);
			demo.enqueue(2);
			demo.dequeue();
			demo.enqueue(3);
			demo.dequeue();
			demo.dequeue();
			demo.enqueue(4);
			demo.dequeue();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	private List<Integer> queue = new LinkedList<>();
	private int limit = 10;

	public BlockingQueueDemo(int limit){
	    this.limit = limit;
	  }

	public synchronized void enqueue(Integer item) throws InterruptedException {
		while (this.queue.size() == this.limit) {
			wait();
		}
		this.queue.add(item);
		System.out.println("item added " + item);
		if (this.queue.size() == 1) {
			notifyAll();
		}
	}

	public synchronized Object dequeue() throws InterruptedException {
		while (this.queue.size() == 0) {
			wait();
		}
		if (this.queue.size() == this.limit) {
			notifyAll();
		}
		System.out.println("remvoed item " + queue.get(0));
		return this.queue.remove(0);
	}
}
