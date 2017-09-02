//Node for circular linked list
class CLLNode{
	public int val;
	public CLLNode next, previous;
	//one parameter constructor
	public CLLNode(int val){
		this.val = val;
		previous = next = null;
	}
}

class CircluarLinkedList{
	
	//we are using doubly circular linked list, singly list version can be made by changing CLLNode class and changing methods

	public CLLNode head,last;

	//no parameter constructor
	public CircluarLinkedList(){
		head = last = null;
	}

	// one parameter constructor
	public CircluarLinkedList(CLLNode head, CLLNode last){
		this.head = head;
		this.last = last;
	}

	//add an element int the front
	public void addInFront(int val){
		if(head == null){
			//if list is empty
			head = new CLLNode(val);
			head.next = head;
			last = head;
			head.previous = last;
		}else{
			//if one or more elements exist
			CLLNode aux_node = new CLLNode(val);
			aux_node.next = head;
			aux_node.previous = last;
			head.previous = aux_node;
			last.next = aux_node;
			head = aux_node;
		}
	}

	//adding at the end
	public void addAtEnd(int val){
		if(head == null){
			//if list is empty
			head = new CLLNode(val);
			head.next = head;
			last = head;
			head.previous = last;
		}else{
			//if one or more elements exist
			CLLNode aux_node = new CLLNode(val);
			aux_node.next = head;
			aux_node.previous = last;
			head.previous = aux_node;
			last.next = aux_node;
			last = aux_node;
		}
	}

	// add after a given node
	public void addAfterNode(CLLNode node){
		if(node==null){
			System.out.println("Node doesn't exist");
			return;
		}
		else{
			if(last==node){
				//if we are adding to the last then we would need to update last too
				addAtEnd(val);
			}else{
				//else simply insert it in between
				CLLNode aux_node = new CLLNode(val);
				aux_node.next = node.next;
				node.next.previous = aux_node;
				aux_node.previous = node;
				node.next = aux_node;
			}

		}
	}

	//delete the element from the front
	public void deleteFromFront(){
		//if one or zero elements
		if(head==last){
			head = last = null;
			return;
		}
		//else link the second and last nodes, and delete the head, new head is second element
		last.next = head.next;
		head.next.previous = last;
		head.next = head.previous = null;
		head = last.next;
	}

	//delete the element from the ending
	public void deleteFromEnd(){
		// if 0 or 1 element
		if(head==null){
			head = last = null;
			return;
		}
		//else link second last and head nodes, and set last to second last element
		head.previous = last.previous;
		last.previous.next = head;
		last.next = last.previous = null;
		last = head.previous;
	}

	
	//delete the node provided from the list
	public void deleteNode(CLLNode node){
		
		//if node to be deleted is head
		if(node==head){
			deleteFromFront();
			return;
		}

		//if we node is the last node
		if(node==last){
			deleteFromEnd();
			return;
		}

		//else link the adjacent nodes
		node.previous.next = node.next;
		node.next.previous = node.previous;

	}


	public boolean isEmpty(){
		return head==null;
	}

	public display(){
		CLLNode temp = head;
		while(true){
			System.out.print(temp.val);
			temp = temp.next;	
		//if we have printed last element then break;
		if(temp==last)
			break;
		}
		System.out.println();
	}
}

class CLLDriver{
	public static void main(String ...args){
		//your code here		
		//CircluarLinkedList my_cll = new CircluarLinkedList();
	}
}