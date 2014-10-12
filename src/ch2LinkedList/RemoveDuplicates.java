package ch2LinkedList;




public class RemoveDuplicates {
	
	static public void removeDuplicates(Node n){
		Node iter = n;
		while(iter != null){
		    removeNodeByValue(iter,iter.value);
			iter = iter.next;
		}
	}
	

	static public void removeNodeByValue(Node n, char v){
		if(n == null || n.next == null)
			return;
		
		if(n.next.value == v){
			n.next = n.next.next;
			removeNodeByValue(n, v);
		}
		else
			removeNodeByValue(n.next,v);
		
		
					
		
		
	}
	
	static public void main(String[] args){
		Node head = new Node('F');
		head.insertAtEnd('O');
		head.insertAtEnd('L');
		head.insertAtEnd('L');
		head.insertAtEnd('O');
		head.insertAtEnd('W');
		head.insertAtEnd(' ');
		head.insertAtEnd('U');
		head.insertAtEnd('P');
		head.insertAtEnd('R');
		head.insertAtEnd('L');
		head.insertAtEnd('L');
		head.printAllValues();
		
		removeDuplicates(head);
		head.printAllValues();
	}


	
	public static class Node{
		public char value;
		public Node next;
		
		public Node(char value){
			this.value = value;
			next = null;
		}
		
		
		public void removeNext(){
			
			if(this.next == null)
				return;
			else
				this.next = this.next.next;
		}
		
		
		public void insertAtEnd(char value){
			Node iter = this;
			while(iter.next!=null)
				iter = iter.next;
			iter.next = new Node(value);
		}
		
		public void printAllValues(){
			Node iter = this;
			while(iter!=null){
				System.out.print(iter.value);
				iter = iter.next;
			}
			System.out.println();
			
		}
		
	}


	
}


