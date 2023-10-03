package Assignment;

public class CQueue {
int SIZE = 10; 
int front, rear;
int items[] = new int[SIZE];

	CQueue() {
	    front = -1;
	    rear = -1;
	}


	boolean isFull() {
		 if (front == 0 && rear == SIZE - 1) {
		   return true;
		 }
		 if (front == rear + 1) {
		   return true;
		 }
		 return false;
	}


	boolean isEmpty() {
		 if (front == -1)
		   return true;
		 else
		   return false;
	}


	void enQueue(int element) {
	 if (isFull()) {
	   System.out.println("Order can not be placed at this time.");
	 } else {
	   if (front == -1)
	     front = 0;
	   rear = (rear + 1) % SIZE;
	   items[rear] = element;
	   System.out.println("Order number for your pizza is " + element + " and is placed.");
	 }
  }


	 int deQueue() {
		 int element;
		 if (isEmpty()) {
		   System.out.println("There is no order.");
		   return (-1);
		 } else {
		   element = items[front];
		   if (front == rear) {
		     front = -1;
		     rear = -1;
		   } 
		   else {
		     front = (front + 1) % SIZE;
		   }
		   return (element);
		 }
	}

	void display() {
	 
	 int i;
	 if (isEmpty()) {
	   System.out.println("Empty Queue");
	 } else {
	   for (i = front; i != rear; i = (i + 1) % SIZE)
	     System.out.print(items[i] + " ");
	   System.out.println(items[i]);
	 }
	}

public static void main(String[] args) {

 CQueue q = new CQueue();

 q.enQueue(1);
 q.enQueue(2);
 q.enQueue(3);
 q.enQueue(4);
 q.enQueue(5);

q.display();
q.deQueue();
q.display();
}

}
