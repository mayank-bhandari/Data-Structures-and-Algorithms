/*
Question : Detect if a singly linked list has a cycle in it or not.
*/

import java.util.Random;

class Node{
	public int data;
	public Node next = null;	
	//constructors
	public Node(){
		data = 0;
		next = null;
	}
	public Node(int val){
		data = val;
		next = null;
	}
	public Node(int val, Node next){
		data = val;
		this.next = next;
	}
}

class SingleLinkedList{

	//head and tail of linked list
	Node head, last;

	//constructors
	public SingleLinkedList(){
		head = null;
		last = null;
	}
	// if head and tail are given
	public SingleLinkedList(Node head, Node tail){
		this.head = head;
		this.last = tail;
	}

	//insert at beginning
	public void insertAtBeginning(int val){
		//if list contains no elements
		if(head==null){
			head = new Node(val);
			last = head;
			return;
		}
		//if list has some elements
		Node aux_node = new Node(val, head);
		head = aux_node;
	}

	//insert the node at last
	public void insertAtLast(int val){
		//if list is empty
		if(last==null){
			head = new Node(val);
			last = head;
			return;	
		}
		last.next = new Node(val);
		last = last.next; 
	}

	//insert after the node given
	public void insertAfterNode(int val, Node node){
		//if node doesn't exist
		if(node==null){
			System.out.println("Node not found");
			return;
		}
		//if node exists add the node then
		Node aux_node = new Node(val, node.next);
		node.next = aux_node;
	}
	
	//given head, last, node, delete the node from linked list
	public void deleteNode(Node node){
		Node temp = head;
		// if the first node is the one to be deleted
		if(head == node){
			if(head==last){
				last = null;
			}
			head = head.next;
		}
		//if there are more than one node
		else{
			//till the next node is not equal to node 
			while(temp.next != node){
				temp = temp.next;
			}
			//if node to be deleted is the last node then change last
			if(temp.next==last){
				last = temp;
			}
			temp.next = temp.next.next;
		}
	}

	//if the list is empty or not
	public boolean isEmpty(){
		return head==null;
	}

	//display the list
	public void display(){
		System.out.print("List is : ");
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}

//make your own class for specific purposes
class MySLL extends SingleLinkedList{

	// if no parameters are passed
	public MySLL(){
		super();
	}

	//if parameters are passed
	public MySLL(Node head, Node last){
		super(head, last);
	}

	

	//a function to create cycle in the singly linked list, where size of linked list is given
	public void create_cycle(int size){
		
		int junction = new Random().nextInt(size);
		Node temp = head;
		for(int i = 0; i<junction; i++){
			temp = temp.next;
		}
		// instead of null, set the next of last to current node that is referred by temp
		last.next = temp;

		displayCycle(size, junction);
	}

	//FLoyd method to detect cycle
	public boolean isCycle(){
		Node horse, tortoise;
		//horse will take 2 steps , tortoise will take 1 step
		horse = tortoise = head;
		while(horse!=null && tortoise != null){
			tortoise = tortoise.next;
			horse = horse.next;
			if(horse == null || tortoise == null)
				break;
			horse = horse.next;
			if(horse == tortoise)
				return true;
		}

		return false;
	}

	void displayCycle(int size, int junction){
		Node temp = head;
		System.out.print("List is : ");
		for(int i=0; i<=size; i++){
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
		System.out.println("Last node points to : "+(junction+1) + " node");
	}

}

class Driver{

	public static void main(String ...args){
		MySLL my_list = new MySLL();
		int size = 10;
		Random rand = new Random();
		for(int i = 0; i < 10 ; i++){
			my_list.insertAtLast(rand.nextInt());
		}

		my_list.display();
		//no cycle created till now
		System.out.println("Cycle exists : " + my_list.isCycle());
		
		my_list.create_cycle(size);
		System.out.println("Cycle exists : " + my_list.isCycle());

	} 

}