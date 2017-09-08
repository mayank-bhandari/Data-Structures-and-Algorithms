import java.util.*;

class SinglyLinkedList{
	class Node{
		public int val;
		public Node next;

		//constructors
		public Node(int val){
			this.val = val;
			next = null;
		}	
	}
	public Node head = null, last = null;
	//constructors
	public SinglyLinkedList(){
		head = null;
		last = null;
	}
	public SinglyLinkedList(Node head){
		this.head = head;
		while(head.next != null){
			head = head.next;
		}
		last = head;
	}

	//display the list
	void display(){
		Node temp = head;
		System.out.print("List : ");
		while(temp!=null){
			System.out.print(temp.val +" ");
			temp = temp.next;
		}
		System.out.println();
	}


	public void insert(int val){
		if(head==null){
			head = last = new Node(val);
		}else{
			last.next = new Node(val);
			last = last.next;
		}

	}  
}

class MyList extends SinglyLinkedList{
	

	public MyList(){
		super();
	}
	public MyList(Node head){
		super(head);
	}

	//keep odd numbers first
	void setOddBeforeEven(){
		Node temp = head;
		Node oddHead=null, evenHead=null, curOdd=null, curEven=null;
		//while list is not exhausted
		while(temp!=null){
			head = temp.next;
			if(temp.val%2==0){//if data in current node is even
				if(evenHead==null){	//if even list is empty
					evenHead = temp;
					curEven = temp;
				}else{
					curEven.next = temp;
					curEven = temp;
				}
				curEven.next = null;
			}
			else{
				if(oddHead==null){
					oddHead = temp;
					curOdd = temp;
				}else{
					curOdd.next = temp;
					curOdd = temp;
				}
				curOdd.next = null;
			}
			temp = head;
		}

		if(curOdd!=null){//if list had odd numbers
			head = oddHead;
			curOdd.next = evenHead;
		}else{//if there were no odd numbers
			head = evenHead;
		}
	}

	void insert_n_values(int n){
		//insert n random integers
		Random rand = new Random();
		for(int i = 0; i<n;i++){
			this.insert(rand.nextInt());
		}
	}

}

class OddBeforeEvenListDriver{
	public static void main(String[] args){
		MyList my_list = new MyList();
		my_list.insert_n_values(15);
		my_list.display();
		my_list.setOddBeforeEven();
		my_list.display();
	}
}