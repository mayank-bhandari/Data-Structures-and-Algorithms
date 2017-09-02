/*
Question: Find Nth node from the ending, where N is less than size of singly linked list.
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



//create your own class for specific purposes
class MySLL extends SingleLinkedList{

	// if no parameters are passed
	public MySLL(){
		super();
	}

	//if parameters are passed
	public MySLL(Node head, Node last){
		super(head, last);
	}

	// function to return length of list
	public int getLength(){
		Node temp = head;
		int count = 0;
		while(temp!=null){
			temp = temp.next;
			count+=1;
		}
		return count;
	}


	public Node NthNodeFromLastByGettingLength(int n){
		int size = getLength();
		int node_num = size-n;

		Node temp = head;
		while(node_num!=0){
			temp = temp.next;
			node_num-=1;
		}
		return temp;
	}

	public Node NthNodeFromLastByTwoPointers(int n){
		Node temp1, temp2;
		temp1 = temp2 = head;
		//move temp1 n steps ahead
		while(n!=0){
			n--;
			temp1 = temp1.next;
		}
		//now moveboth till temp1 is null
		while(temp1!=null){
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		return temp2;
	}
}

class Driver{

	public static void main(String ...args){
		MySLL my_list = new MySLL();
		Random rand = new Random();
		for(int i = 0; i < 10 ; i++){
			my_list.insertAtLast(rand.nextInt());
		}
		my_list.display();
		int n = rand.nextInt(10) + 1;
		System.out.println("Value of n : " + n);
		Node node1 = my_list.NthNodeFromLastByGettingLength(n);
		System.out.println(node1.data);
		System.out.println(node1);
		node1 = my_list.NthNodeFromLastByTwoPointers(n);
		System.out.println(node1.data);
		System.out.println(node1);
	} 

}