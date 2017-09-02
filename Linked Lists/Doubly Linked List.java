import java.utils.Random;

class DoublyLinkedList{

	class DLLNode{
		int data;
		DLLNode prev, next;

		//constructor, node is generally initiated with a val
		DLLNode(int val){
			data = val;
			prev = null;
			next = null;
		}

	}

	//head points to first element, last points to the last element
	DLLNode head, last;

	// new DLL
	public DoublyLinkedList(){
		head = null;
	}

	//already existing a DLL
	public DoublyLinkedList(DLLNode head){
		this.head = head;
	}

	public void insertAtBeginning(int val){
		//if the DLL is empty
		if(head==null){
			last = head = new DLLNode(val);
		}
		else{
			// if there are some elements
			DLLNode aux_node = new DLLNode(val);
			aux_node.next = head;
			head.previous = aux_node;
			head = aux_node;
		}
	}

	public void insertAtEnd(int val){
		//if list is empty
		if(last==null){
			head = last = new DLLNode(val);
		}else{//if last element exists
			DLLNode aux_node = new DLLNode(val);
			last.next = aux_node;
			aux_node.previous = last;
			last = aux_node;
		}
	}

	public void insertAfterNode(int val, DLLNode node){
		if(node==null){
			System.out.println("Node doesn't exxist");
			return;
		}
		DLLNode aux_node = new DLLNode(val);
		aux_node.next = node.next;
		aux_node.previous = node;
		node.next.previous = aux_node;
		node.next = aux_node;
	}

	public void deleteFrontNode(){
		if(head != null){
			head = head.next;
			if(head!=null){
				//if there are more than two elements then no need to change the last, 
				//set the head to next node and set next nodes previous to null, i.e.remove reference to the initial head
				head.previous = null;
			}else{// if there was only one element
				last = null;
			}
		}
	}

	//delete from the ending
	public void deleteLastNode(){
		if(last!=null){
			if(head==last){// if only one node
				last = head = null;
			}else{
				//more than 1 element
				last = last.previous;
				last.next = null;
			}
		}
	}

	public void deleteAfterNode(DLLNode node){
		if(node){
			node.next = node.next.next;
			node.next.previous = node;
		}

	}

	public boolean isEmpty(){
		return head==null;
	}

}

class DLL_DriverClass{
	public static void main(String ...args){
		//your code here
	}
}