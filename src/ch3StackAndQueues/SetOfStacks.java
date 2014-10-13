package ch3StackAndQueues;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;


public class SetOfStacks<T>{
	private int capacity;
	private int currentStackToAdd; //to add
	private int currentStackToPop;
	private ArrayList<Stack<T>> setOfStacks;
	public int getCapacity(){
		return capacity;
	}
	
	
	public SetOfStacks (int capacity) throws IllegalArgumentException {
		if(capacity > 0)
			this.capacity = capacity;
		else 
			throw new IllegalArgumentException("Bad input");
		
		setOfStacks = new ArrayList<Stack<T>>();
		setOfStacks.add(new Stack<T>());
		
		currentStackToAdd = 0;
		currentStackToPop = -1;
		
	
	}
	
	public T pop() throws EmptyStackException{
		if(currentStackToPop == -1)
			throw new EmptyStackException();
		T result = null;
		
		result = setOfStacks.get(currentStackToPop).pop();		
		int stackSize = (setOfStacks.get(currentStackToPop).size());
		if(stackSize == 0)	
			while(currentStackToPop > 0){
				if(setOfStacks.get(currentStackToPop).size() > 0)
					break;
				currentStackToPop -= 1;
			}
		while(currentStackToPop != setOfStacks.size())
			setOfStacks.remove(setOfStacks.size()-1);
		
		return result;
	}
	
	
	public T push(T input){
		if (setOfStacks.get(currentStackToAdd).size() == capacity){
			while(setOfStacks.get(currentStackToAdd).size() == capacity){
				currentStackToAdd += 1;
				if(currentStackToAdd > setOfStacks.size())
					setOfStacks.add(new Stack<T>());
			}
			currentStackToPop = currentStackToAdd > currentStackToPop? currentStackToAdd : currentStackToPop;
		}
		
		setOfStacks.get(currentStackToAdd).push(input);
		return input;
	}
	
	public T popAt(int i){
		if(i > currentStackToPop){
			throw new IllegalArgumentException();
		}
		else if(i == currentStackToPop)
			return pop();
		else{
			T result = setOfStacks.get(i).pop();
			if(setOfStacks.get(i).size()<currentStackToAdd)
				currentStackToAdd = setOfStacks.get(i).size();
			return result; 
		}
	}
	
	public static void main(String[] args){
		
		
	
	}
}
